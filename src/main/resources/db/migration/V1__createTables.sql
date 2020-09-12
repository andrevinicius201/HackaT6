CREATE TABLE account_holder (
    id NUMERIC  NOT NULL ,
    agency_number VARCHAR(4),
    account_number VARCHAR(6),
    balance NUMERIC(15,2),
    phone_number VARCHAR(16),
    PRIMARY KEY (id)
);

CREATE TABLE movements (
    id NUMERIC NOT NULL ,
    account_holder_id NUMERIC,
    movement_type VARCHAR(20),
    value NUMERIC(15,2),
    description VARCHAR(50),
    date TIMESTAMP,
    quantity_stickers INT,
    PRIMARY KEY (id),
    FOREIGN KEY(account_holder_id) REFERENCES account_holder (id)
);

CREATE TABLE invites (
    id NUMERIC NOT NULL ,
    account_holder_id NUMERIC,
    invitation_date TIMESTAMP,
    invited_email VARCHAR(50),
    description VARCHAR(50),
    made_effective BOOLEAN,
    PRIMARY KEY (id),
    FOREIGN KEY(account_holder_id) REFERENCES account_holder (id)
);

CREATE TABLE prize (
    id NUMERIC NOT NULL ,
    description VARCHAR(45),
    image VARCHAR(255),
    price NUMERIC(15,2),
    PRIMARY KEY (id)
);

CREATE TABLE stickers (
    id NUMERIC NOT NULL ,
    prize_id NUMERIC,
    piece INT,
    rows_quantity INT,
    columns_quantity INT,
    PRIMARY KEY (id),
    FOREIGN KEY(prize_id) REFERENCES prize(id)
);

CREATE TABLE account_holder_prize_status (
    id NUMERIC NOT NULL,
    description VARCHAR(45),
    PRIMARY KEY (id)
);

CREATE TABLE account_holder_prize (
    id NUMERIC NOT NULL ,
    account_holder_id NUMERIC,
    account_holder_prize_status_id NUMERIC,
    PRIMARY KEY (id),
    FOREIGN KEY(account_holder_id) REFERENCES account_holder (id),
    FOREIGN KEY(account_holder_prize_status_id) REFERENCES account_holder_prize_status (id)
);

CREATE TABLE sticker_account_holder (
    id NUMERIC NOT NULL ,
    account_holder_id NUMERIC,
    sticker_id NUMERIC,
    movement_id NUMERIC,
    PRIMARY KEY (id),
    FOREIGN KEY(account_holder_id) REFERENCES account_holder (id),
    FOREIGN KEY(movement_id) REFERENCES movements (id)
);