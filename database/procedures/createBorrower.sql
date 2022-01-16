/* 
     Creates a book borrower identified by an BorrowerId, borrow a book with Book Id, borrowed from a time indicated by BorrowedFrom, 
     borrowed to a time indicated by BorrowedTo, has a return date identified by ReturnDate, and is issued by a staff with IssuedBy
   
*/
DELIMITER //

DROP PROCEDURE IF EXISTS createBorrower //
CREATE PROCEDURE createBorrower (
	IN inBorrowerId INT,
    IN inBookId INT,
    IN inBorrowedFrom DATE,
    IN inBorrowedTo DATE,
    IN inReturnDate DATE,
    IN inIssuedBy INT,
    OUT statusCode INT
)
BEGIN CASE
    WHEN inReturnDate > CURDATE() THEN
		SET statusCode = 409; -- Returned Date cannot be in the future
    WHEN inBorrowerId IN (SELECT Borrower_Id FROM Borrower) THEN
		SET statusCode = 413; -- Borrower Id already exists
	WHEN inBookId NOT IN (SELECT ISBN FROM Book) THEN
		SET statusCode = 402; -- NON-EXISTENT/INVALID ISBN
	ELSE
		SET statusCode = 200;
		INSERT INTO Borrower (Borrower_Id,Book_Id,Borrowed_from,Borrowed_to,Returned_date,Issued_by)
		VALUES (inBorrowerId,(SELECT Book_PK FROM Book WHERE ISBN = inBookId),inBorrowedFrom,inBorrowedTo,inReturnDate,(SELECT Staff_PK FROM Staff WHERE Staff_Id = inIssuedBy));
	END CASE;
END//

DELIMITER ;
