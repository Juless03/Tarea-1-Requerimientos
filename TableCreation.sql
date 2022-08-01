CREATE TABLE IF NOT EXISTS person(
personid          INT NOT NULL AUTO_INCREMENT,
firstName         VARCHAR(50) NOT NULL,
secondName        VARCHAR(50),
firstSurname      VARCHAR(50) NOT NULL,
secondSurname     VARCHAR(50),

CONSTRAINT person_pk PRIMARY KEY (personid)
);

CREATE TABLE IF NOT EXISTS email(
mail           VARCHAR(50) NOT NULL,
personRef      INT NOT NULL,

CONSTRAINT email_pk PRIMARY KEY (mail),
FOREIGN KEY (personRef) REFERENCES persona(personaid)
);

CREATE TABLE IF NOT EXISTS userTable(
userPassword   VARCHAR(35) NOT NULL,
personRef      INT NOT NULL,

FOREIGN KEY (personref) REFERENCES persona(personaid)
);




