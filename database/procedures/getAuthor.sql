/*
    Get list of Author
*/
DELIMITER //

DROP PROCEDURE IF EXISTS getAuthor //
CREATE PROCEDURE getAuthor (
    OUT statusCode INT
)
BEGIN
	SET statusCode = 200; 
	SELECT Author_Id, Author_Name
	FROM Author;
END//

DELIMITER ;