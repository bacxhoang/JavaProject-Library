/*
    Get list of Book
*/
DELIMITER //

DROP PROCEDURE IF EXISTS getBook //
CREATE PROCEDURE getBook (
    OUT statusCode INT
)
BEGIN
	SET statusCode = 200; 
	SELECT ISBN, Title, Book_Language, Author_Name, Cat_Name, No_Copy_Actual, No_Copy_Current
	FROM Book B 
    INNER JOIN Author A ON B.Author_Id = A.Author_Id
    INNER JOIN Category ON Category_Id = Cat_Id;
END//

DELIMITER ;