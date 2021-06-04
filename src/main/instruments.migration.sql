USE instruments_db;

CREATE TABLE IF NOT EXISTS users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    email VARCHAR (50) NOT NULL,
    username VARCHAR (100) NOT NULL,
    password VARCHAR (100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS instruments (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR (50) NOT NULL,
    description VARCHAR (100) NOT NULL,
    owner_id INT UNSIGNED NOT NULL,
    payment_type VARCHAR (50) NOT NULL,
    price FLOAT(6,2) NOT NULL,
    shipping_method VARCHAR (50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (owner_id) REFERENCES users (id)
);


CREATE TABLE IF NOT EXISTS types (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR (50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS instruments_types (
    instrument_id INT UNSIGNED NOT NULL,
    type_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (instrument_id) REFERENCES instruments(id),
    FOREIGN KEY (type_id) REFERENCES types (id)
    );

