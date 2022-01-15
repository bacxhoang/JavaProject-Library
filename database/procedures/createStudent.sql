/* 
     Creates a student identified by a Student Id, has a Name, has a unique Borrower Id, and unique Phone Number
*/
DELIMITER //

DROP PROCEDURE IF EXISTS createStudent //
CREATE PROCEDURE createStudent (
	IN inStudentId INT,
    IN inStudentName VARCHAR(50),
    IN inBorrowerId INT,
    IN inPhoneNumber INT,
    OUT statusCode INT
)
BEGIN CASE
	WHEN inStudentId AND inBorrowerId NOT REGEXP '[0-9]+' 
    AND inStudentName NOT REGEXP '[^a-zA-Z]+' THEN
		SET statusCode = 460; -- invalid input
    WHEN inStudentId IN (SELECT Student_Id FROM Student) THEN
		SET statusCode = 416; -- Student Id already exists
	WHEN inBorrowerId NOT IN (SELECT Borrower_Id FROM Borrower) THEN
		SET statusCode = 403; -- NON-EXISTENT/INVALID Borrower Id
	ELSE
		SET statusCode = 200;
		INSERT INTO Student (Student_Id,Student_Name,Borrower_Id,Phone_Number)
		VALUES (inStudentId,inStudentName,(SELECT Borrower_PK FROM Borrower WHERE Borrower_Id = inBorrowerId),inPhoneNumber);
	END CASE;
END//

DELIMITER ;
