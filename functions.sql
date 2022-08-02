DELIMITER //
CREATE FUNCTION getPersonEmail(pEmail VARCHAR(50)) RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
DECLARE vcEmail VARCHAR(50);
    SELECT mail
    INTO vcEmail
    FROM email 
    WHERE mail = pEmail;
    RETURN vcEmail;
END //
DELIMITER //
CREATE FUNCTION getPersonPassword(pPassword VARCHAR(35)) RETURNS VARCHAR(35) 
DETERMINISTIC
BEGIN
DECLARE vcPassword VARCHAR(35);
    SELECT userPassword
    INTO vcPassword
    FROM usertable
    WHERE userPassword = pPassword;
    RETURN vcPassword;
END //