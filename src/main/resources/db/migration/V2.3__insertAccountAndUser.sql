INSERT INTO users (id, name, cpf)
VALUES (nextval('hibernate_sequence'), 'Susan Wojcicki da Silva', '09327456440');
INSERT INTO accounts ( user_id,id, agency_number, account_number, balance, phone_number)
VALUES ((select id from users where cpf = '09327456440'),nextval('hibernate_sequence'), '0071', '1234511', 250.00, '11999999999');