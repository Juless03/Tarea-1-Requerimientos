INSERT INTO persona (personaid,firstname,secondName,firstsurname,secondsurname)
VALUES (default, 'Bryan','José' , 'Castro', 'Solís');

INSERT INTO persona (personaid,firstname,secondName,firstsurname,secondsurname)
VALUES (default, 'Juleisy', null, 'Porras', 'Diaz');

INSERT INTO persona (personaid,firstname,secondName,firstsurname,secondsurname)
VALUES (default, 'Nelson', null, 'Alvarado', 'Navarro');

-- ASIGNACIÓN DE EMAILS----------------------------------------------

INSERT INTO email(mail, personref)
VALUES ('bryancastrosolís732@gmail.com',1);

INSERT INTO email(mail, personref)
VALUES ('j.porrasd03@estudiantec.cr',2);

INSERT INTO email(mail, personref)
VALUES ('nelson2203@estudiantec.cr',3);


-- CONTRASEÑAS DE LAS PERSONAS----------------------------------------------

INSERT INTO usertable(userPassword, personref)
VALUES ('bryan123',1);

INSERT INTO usertable(userPassword, personref)
VALUES ('juleisy123',2);

INSERT INTO usertable(userPassword, personref)
VALUES ('nelson123',3);

