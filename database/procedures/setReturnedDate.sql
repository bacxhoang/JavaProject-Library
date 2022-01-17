/* 
     Set returned date for borrower when return book to the library identified by BorrowerId and BookId with returned date identified by ReturnedDate
*/
DELIMITER //

DROP PROCEDURE IF EXISTS setReturnedDate //
CREATE PROCEDURE setReturnedDate (
	IN inBorrowerId INT,
    IN inBookId INT,
	IN inReturnedDate DATE,
    OUT statusCode INT
)
BEGIN CASE
    WHEN inReturnedDate > CURDATE() THEN
		SET statusCode = 409; -- Returned Date cannot be in the future
	WHEN inReturnedDate IN (SELECT Returned_date FROM Borrower INNER JOIN Book ON Book_Id = Book_PK WHERE (Borrower_Num,Book_Id) = 
    ((SELECT Student_PK FROM Student WHERE Borrower_Id = inBorrowerId), (SELECT Book_PK FROM Book WHERE ISBN = inBookId))) THEN
		SET statusCode = 420; -- Book already returned
    WHEN (inBorrowerId,inBookId) NOT IN (SELECT Borrower_Id,ISBN FROM Borrower INNER JOIN Book ON Book_Id = Book_PK INNER JOIN Student ON Borrower_Num = Student_PK) THEN
		SET statusCode = 421; -- NON-EXISTENT Borrower+Book combination
	ELSE
		SET statusCode = 200;
		UPDATE Borrower
        SET Returned_date = inReturnedDate
        WHERE (Borrower_Num,Book_Id) = ((SELECT Student_PK FROM Student WHERE Borrower_Id = inBorrowerId),(SELECT Book_PK FROM Book WHERE ISBN = inBookId));
        UPDATE Book
        INNER JOIN Borrower ON Book_PK = Book_Id
        SET No_Copy_Current = No_Copy_Current + 1
        WHERE ISBN = inBookId;
	END CASE;
END//

DELIMITER ;
