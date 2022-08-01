DROP PROCEDURE IF EXISTS deleteEmail;
DELIMITER //
CREATE PROCEDURE deleteEmail(IN pEmail VARCHAR(100), OUT executionCode INT)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
		SET executionCode = -1;
        ROLLBACK;
	END;
    
    DELETE FROM email
    WHERE mail = LOWER(pEmail);
    SET executionCode = 0;
    COMMIT;
END //
DELIMITER ;

