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
	SELECT ISBN, Title, Book_Language, A.Author_Id, Cat_Id, No_Copy_Actual, No_Copy_Current
	FROM Book B 
    INNER JOIN Author A ON B.Author_Id = A.Author_PK
    INNER JOIN Category C ON B.Category_Id = C.Cat_PK;
END//

DELIMITER ;