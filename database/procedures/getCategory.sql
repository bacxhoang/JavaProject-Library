/*
    Get list of Category
*/
DELIMITER //

DROP PROCEDURE IF EXISTS getCategory //
CREATE PROCEDURE getCategory (
    OUT statusCode INT
)
BEGIN
	SET statusCode = 200; 
	SELECT Cat_Id,Cat_Name
	FROM Category ;
END//

DELIMITER ;