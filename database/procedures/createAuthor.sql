/* 
     Creates a author identified by a Author Id, Author Name
*/
DELIMITER //

DROP PROCEDURE IF EXISTS createAuthor //
CREATE PROCEDURE createAuthor (
	IN inAuthorId INT,
    IN inAuthorName VARCHAR(50),
    OUT statusCode INT
)
BEGIN CASE
	WHEN inAuthorId NOT REGEXP '[0-9]+' AND inAuthorName NOT REGEXP '[^a-zA-Z]+' THEN
		SET statusCode = 460; -- invalid input
    WHEN inAuthorId IN (SELECT Author_Id FROM Author) THEN
		SET statusCode = 402; -- Author Id already exists
	ELSE
		SET statusCode = 200;
		INSERT INTO Author (Author_Id,Author_Name)
		VALUES (inAuthorId,inAuthorName);
	END CASE;
END//

DELIMITER ;
