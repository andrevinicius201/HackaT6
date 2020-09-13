# Safra Collection API


Api que controla a geração de figurinhas, cadastro de prêmios e responsável por distribuir figurinhas a cada operação do banco.

Para visualização da documentação da API, visite o [swagger-ui](https://hacka-bank.herokuapp.com/api/swagger-ui/index.html?configUrl=/api/v3/api-docs/swagger-config).


## Arquitetura do sistema


A proposta é que a API seja facilmente integrável ao banco. Para isso, teremos uma fila de mensageria (RabbitMQ), que é onde todas as operações do banco devem ser registradas.

A API consome a fila e gera as figurinhas automaticamente.

Ilustração:


![Alt text](arquitetura-safra-collection.png?raw=true "Title")


Modelo Entidade Relacionamento:


![Alt text](mer.PNG?raw=true "Title")


A escolha da linguagem de desenvolvimento (Java com Spring Boot) foi devido à maior facilidade de encontrar desenvolvedores para esta tecnologia.

O banco de dados PostgreSQL possui uma integração com georeferenciamento, que, apesar de não estar no roadmap atual, pode ser interessante no futuro.

A API ainda utiliza um bucket do S3 para armazenar as imagens dos prêmios.

O firebase, apesar de não estar implementado no momento, está previsto para troca de mensagens e push notifications com todos os possíveis clients, principalmente no consumo de transações do RabbitMQ que gerem figurinhas, a notificação deverá ser feita para os dispositivos necessários.

A camada de segurança foi feita com uma Basic Authentication através do spring security. Não foi muito trabalhada na API, já que existe a intenção de deixar esta camada ser controlada por algum API gateway futuramente.

O deploy da API, do banco de dados e do RabbitMQ foi efetuado no Heroku pela facilidade e CD/CI embutido.



### Rodando o projeto


O projeto possui variáveis de ambiente que são informações sensíveis, como autenticação do AWS.

A maioria das variáveis de ambiente poderia ser feita localmente com a dockerização da API (também fica pro futuro para agilizar o desenvolvimento).

Para funcionamento correto da API, as seguinte variáveis devem ser preenchidas no [application.properties](/safra-t6/src/main/resources/application.properties):

```
spring.datasource.url=${JDBC_DATABASE_URL}
spring.datasource.username=${JDBC_DATABASE_USERNAME}
spring.datasource.password=${JDBC_DATABASE_PASSWORD}

cloud.aws.region.static=${AWS_S3_STATIC_REGION}
cloud.aws.credentials.accessKey=${AWS_ACCESS_KEY}
cloud.aws.credentials.secretKey=${AWS_SECRET_KEY}

app.bucketName=${AWS_S3_BUCKET_NAME}

app.amqpUrl=${CLOUDAMQP_URL}

app.basicUser=${BASIC_USER}
app.basicPassword=${BASIC_PASSWORD}
```

Com as configurações feitas, basta utilizar o comando:

```
$ mvn spring-boot:run
```



### Considerações importantes


Devido ao tempo curto, não foi implementado JUnit na solução, mas é necessário ter uma cobertura de testes mínima e deve ser considerado como ponto principal em uma eventual próxima iteração do projeto.

Deve-se pensar em uma camada de LOGS para o ambiente.

