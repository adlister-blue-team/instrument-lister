use instruments_db;

CREATE TABLE IF NOT EXISTS users
(
    email    VARCHAR(50)  NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    image_url VARCHAR(100) NULL,
    PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXISTS instruments
(
    id              INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name            VARCHAR(50)  NOT NULL,
    description     VARCHAR(100) NOT NULL,
    owner_name      VARCHAR(100) NOT NULL,
    payment_type    VARCHAR(50)  NOT NULL,
    price           FLOAT(6, 2)  NOT NULL,
    shipping_method VARCHAR(50)  NOT NULL,
    image_url VARCHAR(100) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (owner_name) REFERENCES users (username)
    ON DELETE CASCADE
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
    FOREIGN KEY (instrument_id) REFERENCES instruments (id)
    ON DELETE CASCADE,
    FOREIGN KEY (type_name) REFERENCES types (name)
);

insert users (email, username, password)
values ('andrewisannoyed@gmail.com', 'andywandy123', 'iamannoyed'),
       ('victorbictor34@gmail.com', 'yovicto', 'puertorico12'),
       ('vanessaquesa786@yahoo.com', 'vnessisamess', 'ilovegilbert'),
       ('kelvonisdamon@outlook.com', 'vapepapi', 'ivape345');

insert into instruments (owner_name, name, description, price, payment_type, shipping_method)
values ('andywandy123', 'Dholak', ' NEW South Asian hand-played drum', 150, 'card', 'pickup'),
       ('andywandy123', 'Duff', ' NEW South Asian/ Middle Eastern hand tambourine', 50, 'cash', 'shipped'),
       ('yovicto', 'Electric Guitar', 'lightly used vintage electric guitar', 200, 'cash', 'shipped'),
       ('yovicto', 'Piano', 'used Walnut piano', 700, 'cash', 'shipped'),
       ('vnessisamess', 'Maracas', 'Set of 2 beautiful gently used Carribean maracas', 30, 'card', 'pickup'),
       ('vapepapi', 'Clarinet', 'Used clarinet', 50, 'card', 'pickup'),
       ('andywandy123', 'Flute', 'Brand new unused flute', 80, 'cash', 'shipped'),
       ('vapepapi', 'Saxophone', 'Great beginner used saxophone', 55, 'cash', 'pickup'),
       ('vnessisamess', 'Sitar', 'NEW imported South Asian lute- similar to guitar', 125, 'card', 'pickup'),
       ('vapepapi', 'Drum set', 'LIGHTLY used Drum set with drumsticks and stands', 275, 'card', 'shipped');

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


