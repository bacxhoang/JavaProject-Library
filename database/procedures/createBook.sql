/* 
     Creates a book identified by an ISBN, has a Title, written in a specific language identified by Book_language, 
     written by an author identified by an Author_Id, is of a specific category identified by Category_Id, 
     has a number of book identifed by No_Copy_Actual, and has a number of book currently on shelf identified by No_Copy_Current
*/
DELIMITER //

DROP PROCEDURE IF EXISTS createBook //
CREATE PROCEDURE createBook (
	IN inISBN INT,
    IN inTitle VARCHAR(100),
    IN inLanguage VARCHAR(20),
    IN inAuthorId INT,
    IN inCategoryId INT,
    IN inNoActual INT,
    IN inNoCurrent INT,
    OUT statusCode INT
)
BEGIN CASE
	WHEN inLanguage REGEXP '[^a-zA-Z]+'  THEN
		SET statusCode = 460; -- invalid input
    WHEN inTitle IS NULL THEN
		SET statusCode = 460; -- invalid input
	WHEN inAuthorId IS NULL AND inAuthorId NOT IN (SELECT Author_Id FROM Author) THEN
		SET statusCode = 460; -- invalid input
	When inCategoryId IS NULL AND inCategoryId NOT IN (SELECT Cat_Id FROM Category) THEN
		SET statusCode = 460; -- invalid input
    WHEN inISBN IN (SELECT ISBN FROM Book) THEN
		SET statusCode = 412; -- ISBN already exists
	ELSE
		SET statusCode = 200;
		INSERT INTO Book (ISBN,Title,Book_Language,Author_Id,Category_Id,No_Copy_Actual,No_Copy_Current)
		VALUES (inISBN,inTitle,inLanguage,(SELECT Author_PK FROM Author WHERE Author_Id = inAuthorId),(SELECT Cat_PK FROM Category WHERE Cat_Id = inCategoryId),inNoActual,inNoCurrent);
	END CASE;
END//

DELIMITER ;
