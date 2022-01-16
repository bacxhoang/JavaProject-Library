/* 
  Create a category identified by a category Id and Name
*/
DELIMITER //

DROP PROCEDURE IF EXISTS createCategory //
CREATE PROCEDURE createCategory (
	IN inCatId INT,
    IN inCatName VARCHAR(50),
    OUT statusCode INT
)
BEGIN CASE
	WHEN inCatName REGEXP '[^a-zA-Z]+' THEN
		SET statusCode = 460; -- invalid input
    WHEN inCatId IN (SELECT Cat_Id FROM Category) THEN
		SET statusCode = 414; -- Category Id already exists
	ELSE
		SET statusCode = 200;
		INSERT INTO Category (Cat_Id,Cat_Name)
		VALUES (inCatId,inCatName);
	END CASE;
END//

DELIMITER ;
