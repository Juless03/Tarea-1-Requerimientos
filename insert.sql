DELIMITER //
DROP PROCEDURE IF EXISTS insertPerson; //
CREATE PROCEDURE insertPerson(IN pFName VARCHAR(50), IN pSName VARCHAR(50), IN pFSurname VARCHAR(50),
                                         IN pSSurname VARCHAR(50),IN pMail VARCHAR(50), IN pPassword VARCHAR(35), OUT executionCode INT)
BODY: BEGIN

DECLARE check_email INT;

DECLARE CUSTOM_EXCEPTION CONDITION FOR SQLSTATE '45000';
DECLARE EXIT HANDLER FOR SQLSTATE '45000'
  BEGIN
  ROLLBACK;
  END;
SELECT COUNT(*) INTO check_email FROM email WHERE mail = pMail;

IF (check_email > 0) THEN
SET executionCode = -3;
SIGNAL CUSTOM_EXCEPTION;
END IF;

INSERT INTO person(firstName, secondName, firstSurname, secondSurname)
VALUES(pFName, pSName, pFSurname, pSSurname);

INSERT INTO email(mail, personRef)
VALUES(pMail, LAST_INSERT_ID());

INSERT INTO userTable (userpassword, personRef)
VALUES (pPassword);

END; //


DELIMITER //
DROP PROCEDURE IF EXISTS insertEmail; //
CREATE PROCEDURE insertEmail(IN pMail VARCHAR(50), IN pPersonID INT, OUT executionCode INT)
BEGIN

DECLARE EXIT HANDLER FOR 1062
BEGIN
    SET executionCode = -2;
    ROLLBACK;
END;

DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    SET executionCode = -1;
    ROLLBACK;
END;

INSERT INTO email(mail, personRef)
VALUES(LOWER(pMail), pPersonID);
SET executionCode = 0;
COMMIT;

END;
//


