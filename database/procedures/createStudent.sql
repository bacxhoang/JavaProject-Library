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
    WHEN inStudentName NOT REGEXP '[^a-zA-Z]+' THEN
		SET statusCode = 460; -- invalid input
    WHEN inStudentId IN (SELECT Student_Id FROM Student) THEN
		SET statusCode = 416; -- Student Id already exists
	ELSE
		SET statusCode = 200;
		INSERT INTO Student (Student_Id,Student_Name,Borrower_Id,Phone_Number)
		VALUES (inStudentId,inStudentName,inBorrowerId,inPhoneNumber);
	END CASE;
END//

DELIMITER ;
