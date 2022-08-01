-- Retorna los emails de un usuario
DELIMITER //
DROP PROCEDURE IF EXISTS getUserEmails; //
CREATE PROCEDURE getUserEmails(IN pPersonID INT) 
BEGIN
SELECT mail FROM email
WHERE personRef = pPersonID;
END; //
