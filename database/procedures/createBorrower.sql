/* 
     Creates a book borrower identified by an BorrowerId, borrow a book with Book Id, borrowed from a time indicated by BorrowedFrom, 
     borrowed to a time indicated by BorrowedTo, and is issued by a staff with IssuedBy
   
*/
DELIMITER //

DROP PROCEDURE IF EXISTS createBorrower //
CREATE PROCEDURE createBorrower (
	IN inBorrowerId INT,
    IN inBookId INT,
    IN inBorrowedFrom DATE,
    IN inBorrowedTo DATE,
    IN inIssuedBy INT,
    OUT statusCode INT
)
BEGIN CASE
	WHEN inBorrowerId NOT IN (SELECT Borrower_Id FROM Student) THEN
		SET statusCode = 403; -- NON-EXISTENT/INVALID Borrower Id
    WHEN (inBorrowerId,inBookId) IN (SELECT Borrower_Id,ISBN FROM Borrower INNER JOIN Book ON Book_Id = Book_PK INNER JOIN Student ON Borrower_Num = Student_PK) THEN
		SET statusCode = 413; -- Cannot borrow more than one copy of the same book
	WHEN inBookId NOT IN (SELECT ISBN FROM Book) THEN
		SET statusCode = 402; -- NON-EXISTENT/INVALID ISBN
	ELSE
		SET statusCode = 200;
		INSERT INTO Borrower (Borrower_Num,Book_Id,Borrowed_from,Borrowed_to,Issued_by)
		VALUES ((SELECT Student_PK FROM Student WHERE Borrower_Id=inBorrowerId),(SELECT Book_PK FROM Book WHERE ISBN = inBookId),inBorrowedFrom,inBorrowedTo,(SELECT Staff_PK FROM Staff WHERE Staff_Id = inIssuedBy));
        UPDATE Book
        SET No_Copy_Current = No_Copy_Current - 1
        WHERE ISBN = inBookId;
	END CASE;
END//

DELIMITER ;
