/* 
    Procedure for staff register
*/
DELIMITER //

DROP PROCEDURE IF EXISTS Register //
CREATE PROCEDURE Register (
	IN inStaffId INT,
    IN inUsername VARCHAR(30),
    IN inPassword VARCHAR(50),
    OUT statusCode INT
)
BEGIN CASE
	WHEN inStaffId NOT REGEXP '[0-9]+' 
    AND inUsername NOT REGEXP '[^a-zA-Z0-9]+' THEN
		SET statusCode = 460; -- invalid input
    WHEN inUsername IN (SELECT User_Name FROM Staff) THEN
		SET statusCode = 410; -- Username already exists
	WHEN inStaffId IN (SELECT Staff_Id FROM Staff) THEN
    SET statusCode = 415; -- Staff Id already exists
	ELSE
		SET statusCode = 200;
		INSERT INTO Staff (Staff_Id,User_Name,Login_Password)
		VALUES (inStaffId,inUsername,inPassword);
	END CASE;
END//

DELIMITER ;
