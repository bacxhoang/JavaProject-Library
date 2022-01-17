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
	SELECT Student_Id, Student_Name, Borrower_Id, Phone_Number
	FROM Student ;
END//

DELIMITER ;