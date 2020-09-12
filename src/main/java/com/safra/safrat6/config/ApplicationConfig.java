package com.safra.safrat6.config;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Value("${app.amqpUrl}")
  private String amqpUrl;

  @Bean
  public ConnectionFactory connectionFactory() throws URISyntaxException {
    final URI rabbitMqUrl = new URI(amqpUrl);

    final CachingConnectionFactory factory = new CachingConnectionFactory();
    factory.setUsername(rabbitMqUrl.getUserInfo().split(":")[0]);
    factory.setPassword(rabbitMqUrl.getUserInfo().split(":")[1]);
    factory.setHost(rabbitMqUrl.getHost());
    factory.setPort(rabbitMqUrl.getPort());
    factory.setVirtualHost(rabbitMqUrl.getPath().substring(1));

    return factory;
  }

}
