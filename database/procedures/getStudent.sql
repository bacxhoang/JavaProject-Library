/*
    Get list of Student
*/
DELIMITER //

DROP PROCEDURE IF EXISTS getStudent //
CREATE PROCEDURE getStudent (
    OUT statusCode INT
)
BEGIN
	SET statusCode = 200; 
	SELECT Student_Id, Student_Name, B.Borrower_Id, Phone_Number
	FROM Student S
    INNER JOIN Borrower B ON S.Borrower_Id = B.Borrower_PK;
END//

DELIMITER ;