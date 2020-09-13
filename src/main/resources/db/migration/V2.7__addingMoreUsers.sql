INSERT INTO users (id, name, cpf)
VALUES (nextval('hibernate_sequence'), 'Mark Zuckerberg da Silva', '39128247035'), --00711234533
	   (nextval('hibernate_sequence'), 'Satya Nadella da Silva', '38723367032'); --00711234522
INSERT INTO accounts ( user_id,id, agency_number, account_number, balance, phone_number)
VALUES ((select id from users where cpf = '39128247035'),nextval('hibernate_sequence'), '0071', '1234533', 2768.48, '11999999999'),
	   ((select id from users where cpf = '38723367032'),nextval('hibernate_sequence'), '0071', '1234522', 28765.93, '11999999999');