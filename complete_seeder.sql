DROP DATABASE instruments_db;
CREATE DATABASE IF NOT EXISTS instruments_db;

use instruments_db;

CREATE TABLE IF NOT EXISTS users
(   id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    email    VARCHAR(50)  NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    image_url VARCHAR(100) NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL ,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS instruments
(
    id              INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name            VARCHAR(50)  NOT NULL,
    description     VARCHAR(100) NOT NULL,
    owner_name      INT UNSIGNED NOT NULL,
    payment_type    VARCHAR(50)  NOT NULL,
    price           FLOAT(6, 2)  NOT NULL,
    shipping_method VARCHAR(50)  NOT NULL,
    image_url VARCHAR(100) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (owner_name) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS types
(
    name VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (name)
);

CREATE TABLE IF NOT EXISTS instruments_types
(
    instrument_id INT UNSIGNED NOT NULL,
    type_name     VARCHAR(50)  NOT NULL,
    FOREIGN KEY (instrument_id) REFERENCES instruments (id) ON DELETE CASCADE,
    FOREIGN KEY (type_name) REFERENCES types (name) ON DELETE CASCADE
);

insert users (id,first_name,last_name,email, username, password)
values (1,'Andrew','Walsh', 'andrewisannoyed@gmail.com', 'andywandy123', 'iamannoyed'),
       (2,'Victoria','Noriega', 'victorbictor34@gmail.com', 'yovicto', 'puertorico12'),
       (3,'Vicky','Da boss', 'vanessaquesa786@yahoo.com', 'vnessisamess', 'ilovegilbert'),
       (4,'Kelvon',',Patterson', 'kelvonisdamon@outlook.com', 'vapepapi', 'ivape345');

insert into instruments (owner_name, name, description, price, payment_type, shipping_method)
values (1, 'Dholak', ' NEW South Asian hand-played drum', 150, 'card', 'pickup'),
       (2, 'Duff', ' NEW South Asian/ Middle Eastern hand tambourine', 50, 'cash', 'shipped'),
       (3, 'Electric Guitar', 'lightly used vintage electric guitar', 200, 'cash', 'shipped'),
       (4, 'Piano', 'used Walnut piano', 700, 'cash', 'shipped'),
       (1, 'Maracas', 'Set of 2 beautiful gently used Carribean maracas', 30, 'card', 'pickup'),
       (2, 'Clarinet', 'Used clarinet', 50, 'card', 'pickup'),
       (3, 'Flute', 'Brand new unused flute', 80, 'cash', 'shipped'),
       (4, 'Saxophone', 'Great beginner used saxophone', 55, 'cash', 'pickup'),
       (1, 'Sitar', 'NEW imported South Asian lute- similar to guitar', 125, 'card', 'pickup'),
       (1, 'Drum set', 'LIGHTLY used Drum set with drumsticks and stands', 275, 'card', 'shipped');

insert into types (name)
values ('String'),
       ('Woodwind'),
       ('Brass'),
       ('Percussion'),
       ('Electronic'),
       ('Plucked');

insert into instruments_types (instrument_id, type_name)
values (1, 'Percussion'),
       (2, 'Percussion'),
       (3, 'String'),
       (3, 'Electronic'),
       (4, 'Plucked'),
       (5, 'Percussion'),
       (6, 'Woodwind'),
       (7, 'Woodwind'),
       (8, 'Brass'),
       (9, 'String'),
       (10, 'Percussion');




