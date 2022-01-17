/*
    Get list of Borrower
*/
DELIMITER //

DROP PROCEDURE IF EXISTS getBorrower //
CREATE PROCEDURE getBorrower (
    OUT statusCode INT
)
BEGIN
	SET statusCode = 200; 
	SELECT Borrower_Id,Student_Name, Title, ISBN, Borrowed_from, Borrowed_to, Returned_date, Issued_by
	FROM Borrower R
    INNER JOIN Book B ON R.Book_Id = B.Book_PK
    INNER JOIN Student S ON R.Borrower_Num = S.Student_PK;
END//

DELIMITER ;