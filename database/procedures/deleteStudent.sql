
/*---------------------------deleteStudent--------------------------*/
-- Remove [Student] information from table <Student>
-- Input: Student Id
-- Output: Status Code
/*-------------------------------------------------------------------*/
DELIMITER //
DROP PROCEDURE IF EXISTS deleteStudent//
CREATE PROCEDURE deleteStudent(
	IN inStudentId INT, 
	OUT statusCode INT) 
BEGIN CASE
  WHEN inStudentId NOT IN (SELECT Student_Id FROM Student
  ) THEN
  SET
    statusCode = 406; -- NON-EXISTENT/INVALID Student Id
  WHEN (SELECT DISTINCT Borrower_Num FROM Borrower INNER JOIN Student ON Borrower_Num = Student_PK WHERE Student_Id = inStudentId) IS NOT NULL THEN
  SET statusCode = 495; -- DELETE VIOLATION
    ELSE
  SET statusCode = 200; -- SUCCESS
  DELETE FROM
    Student
  WHERE
    Student_Id = inStudentId;
END CASE;
END//
DELIMITER ;

