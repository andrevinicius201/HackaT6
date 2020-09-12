drop table account_holder CASCADE;
drop table account_holder_prize CASCADE;
drop table account_holder_prize_status CASCADE;
drop table invites CASCADE;
drop table movements CASCADE;
drop table prize CASCADE;
drop table sticker_account_holder CASCADE;
drop table stickers CASCADE;

CREATE TABLE users (
    id NUMERIC  NOT NULL ,
    name VARCHAR(50) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE accounts (
    id NUMERIC  NOT NULL ,
	user_id NUMERIC NOT NULL,
    agency_number VARCHAR(4) NOT NULL,
    account_number VARCHAR(7) NOT NULL,
    balance NUMERIC(15,2),
    phone_number VARCHAR(16),
    PRIMARY KEY (id),
	FOREIGN KEY(user_id) REFERENCES users (id)
);

CREATE TABLE transactions (
    id NUMERIC NOT NULL ,
    account_id NUMERIC NOT NULL,
    transaction_type VARCHAR(20),
    value NUMERIC(15,2),
    description VARCHAR(50),
    date TIMESTAMP,
    quantity_stickers INT,
    PRIMARY KEY (id),
    FOREIGN KEY(account_id) REFERENCES accounts (id)
);

CREATE TABLE invites (
    id NUMERIC NOT NULL ,
    account_id NUMERIC NOT NULL,
    invitation_date TIMESTAMP,
    invited_email VARCHAR(50),
    description VARCHAR(50),
    made_effective BOOLEAN,
    PRIMARY KEY (id),
    FOREIGN KEY(account_id) REFERENCES accounts (id)
);

CREATE TABLE prizes (
    id NUMERIC NOT NULL ,
    description VARCHAR(45),
    image VARCHAR(255),
    price NUMERIC(15,2),
    PRIMARY KEY (id)
);

CREATE TABLE stickers (
    id NUMERIC NOT NULL ,
    prize_id NUMERIC NOT NULL,
    piece INT NOT NULL,
    rows_quantity INT NOT NULL,
    columns_quantity INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(prize_id) REFERENCES prizes(id)
);

CREATE TABLE account_prize_status (
    id NUMERIC NOT NULL,
    description VARCHAR(45),
    PRIMARY KEY (id)
);

CREATE TABLE account_prize (
    id NUMERIC NOT NULL ,
    account_id NUMERIC NOT NULL,
    account_prize_status_id NUMERIC NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(account_id) REFERENCES accounts (id),
    FOREIGN KEY(account_prize_status_id) REFERENCES account_prize_status (id)
);

CREATE TABLE sticker_account (
    id NUMERIC NOT NULL ,
    account_id NUMERIC NOT NULL,
    sticker_id NUMERIC NOT NULL,
    transaction_id NUMERIC NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(account_id) REFERENCES accounts (id),
	FOREIGN KEY(sticker_id) REFERENCES stickers (id),
    FOREIGN KEY(transaction_id) REFERENCES transactions (id)
);