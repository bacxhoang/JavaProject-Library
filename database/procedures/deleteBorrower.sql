
/*---------------------------deleteBorrower--------------------------*/
-- Remove [Borrower] information from table <Borrower>
-- Input: Borrower Id
-- Output: Status Code
/*-------------------------------------------------------------------*/
DELIMITER //
DROP PROCEDURE IF EXISTS deleteBorrower//
CREATE PROCEDURE deleteBorrower(
	IN inBorrowerId INT,
    IN inBookId INT,
	OUT statusCode INT) 
BEGIN CASE
  WHEN inBorrowerId NOT IN (SELECT Borrower_Id FROM Student INNER JOIN Borrower ON Student_PK = Borrower_Num WHERE Borrower_Id = inBorrowerId
  ) THEN
  SET
    statusCode = 403;
-- NON-EXISTENT/INVALID Borrower Id
  WHEN (SELECT DISTINCT Returned_Date FROM Borrower INNER JOIN Student ON Borrower_Num = Student_PK WHERE Borrower_Id = inBorrowerId AND Book_Id = (SELECT Book_PK FROM Book WHERE ISBN = inBookId)) IS NULL THEN
  SET statusCode = 495; -- DELETE VIOLATION
    ELSE
  SET statusCode = 200; -- SUCCESS
  DELETE FROM
    Borrower
  WHERE
    (Borrower_Num,Book_Id) = ((SELECT Student_PK FROM Student WHERE Borrower_Id = inBorrowerId),(SELECT Book_PK FROM Book WHERE ISBN = inBookId));
END CASE;
END//
DELIMITER ;

