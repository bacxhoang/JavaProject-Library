DROP DATABASE IF EXISTS librarymanagementsystem;
CREATE DATABASE librarymanagementsystem;
USE librarymanagementsystem;

-- Run Database Schema --
 
 CREATE TABLE IF NOT EXISTS Author (
 	Author_PK INT AUTO_INCREMENT NOT NULL,
	Author_Id INT NOT NULL,
    Author_Name VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (Author_PK),
    CONSTRAINT Author_Id_unique UNIQUE (Author_Id)
);

 CREATE TABLE IF NOT EXISTS Category (
 	Cat_PK INT AUTO_INCREMENT NOT NULL,
	Cat_Id INT NOT NULL,
    Cat_Name VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (Cat_PK),
    CONSTRAINT Category_Id_unique UNIQUE (Cat_Id)
);

CREATE TABLE IF NOT EXISTS Book (
  Book_PK INT AUTO_INCREMENT NOT NULL,
  ISBN INT NOT NULL,
  Title VARCHAR(100),
  Book_language VARCHAR(20),
  Author_Id INT NOT NULL,
  Category_Id INT NOT NULL,
  No_Copy_Actual INT NOT NULL,
  No_Copy_Current INT NOT NULL,
  
  PRIMARY KEY (Book_PK),
  CONSTRAINT ISBN_unique UNIQUE (ISBN),
  FOREIGN KEY (Category_Id) REFERENCES Category (Cat_PK),
  FOREIGN KEY (Author_Id) REFERENCES Author (Author_PK)
);

 CREATE TABLE IF NOT EXISTS Staff (
 Staff_PK INT AUTO_INCREMENT NOT NULL,
 Staff_Id INT NOT NULL,
 User_Name VARCHAR(30) NOT NULL,
 Login_Password VARCHAR(50) NOT NULL,
 
 PRIMARY KEY (Staff_PK),
 CONSTRAINT StaffId_Unique UNIQUE (Staff_Id),
 CONSTRAINT Username_Unique UNIQUE (User_Name)
 );
 
CREATE TABLE IF NOT EXISTS Student (
 Student_PK INT AUTO_INCREMENT NOT NULL,
 Student_Id INT NOT NULL,
 Student_Name VARCHAR(50) NOT NULL,
 Borrower_Id INT NOT NULL,
 Phone_Number INT NOT NULL,
 
 PRIMARY KEY (Student_PK),
 CONSTRAINT StudentId_Unique UNIQUE (Student_Id),
 CONSTRAINT Borrower_Unique UNIQUE (Borrower_Id),
 CONSTRAINT Phonenumber_Unique UNIQUE (Phone_Number)
 );
    
CREATE TABLE IF NOT EXISTS Borrower (
	Borrower_PK INT AUTO_INCREMENT NOT NULL,
	Borrower_Num INT NOT NULL,
    Book_Id INT NOT NULL,
    Borrowed_from DATE NOT NULL,
    Borrowed_to DATE NOT NULL,
    Returned_date DATE DEFAULT '0000-00-00',
    Issued_by INT NOT NULL,
    
    PRIMARY KEY (Borrower_PK),
	CONSTRAINT Borrower_Unique UNIQUE (Borrower_Num,Book_Id),
    FOREIGN KEY (Book_Id) REFERENCES Book (Book_PK) ON DELETE CASCADE,
    FOREIGN KEY (Issued_by) REFERENCES Staff (Staff_PK) ON DELETE CASCADE,
    FOREIGN KEY (Borrower_Num) REFERENCES Student (Student_PK) ON DELETE CASCADE
);

-- Run Procedures --
DELIMITER //

DROP PROCEDURE IF EXISTS Register //
CREATE PROCEDURE Register (
	IN inStaffId INT,
    IN inUsername VARCHAR(30),
    IN inPassword VARCHAR(50),
    OUT statusCode INT
)
BEGIN CASE
	WHEN inUsername REGEXP '[^a-zA-Z0-9]+' THEN
		SET statusCode = 460; -- invalid input
    WHEN inUsername IN (SELECT User_Name FROM Staff) THEN
		SET statusCode = 410; -- Username already exists
	WHEN inStaffId IN (SELECT Staff_Id FROM Staff) THEN
    SET statusCode = 415; -- Staff Id already exists
	ELSE
		SET statusCode = 200;
		INSERT INTO Staff (Staff_Id,User_Name,Login_Password)
		VALUES (inStaffId,inUsername,inPassword);
	END CASE;
END//

DELIMITER ;
    

DELIMITER //

DROP PROCEDURE IF EXISTS createAuthor //
CREATE PROCEDURE createAuthor (
	IN inAuthorId INT,
    IN inAuthorName VARCHAR(50),
    OUT statusCode INT
)
BEGIN CASE
	WHEN inAuthorName NOT REGEXP '[^a-zA-Z]+' THEN
		SET statusCode = 460; -- invalid input
    WHEN inAuthorId IN (SELECT Author_Id FROM Author) THEN
		SET statusCode = 411; -- Author Id already exists
	ELSE
		SET statusCode = 200;
		INSERT INTO Author (Author_Id,Author_Name)
		VALUES (inAuthorId,inAuthorName);
	END CASE;
END//

DELIMITER ;

DELIMITER //

DROP PROCEDURE IF EXISTS createCategory //
CREATE PROCEDURE createCategory (
	IN inCatId INT,
    IN inCatName VARCHAR(50),
    OUT statusCode INT
)
BEGIN CASE
	WHEN inCatName REGEXP '[^a-zA-Z]+' THEN
		SET statusCode = 460; -- invalid input
    WHEN inCatId IN (SELECT Cat_Id FROM Category) THEN
		SET statusCode = 414; -- Category Id already exists
	ELSE
		SET statusCode = 200;
		INSERT INTO Category (Cat_Id,Cat_Name)
		VALUES (inCatId,inCatName);
	END CASE;
END//

DELIMITER ;

DELIMITER //

DROP PROCEDURE IF EXISTS createBook //
CREATE PROCEDURE createBook (
	IN inISBN INT,
    IN inTitle VARCHAR(100),
    IN inLanguage VARCHAR(20),
    IN inAuthorId INT,
    IN inCategoryId INT,
    IN inNoActual INT,
    IN inNoCurrent INT,
    OUT statusCode INT
)
BEGIN CASE
	WHEN inLanguage REGEXP '[^a-zA-Z]+'  THEN
		SET statusCode = 460; -- invalid input
    WHEN inTitle IS NULL THEN
		SET statusCode = 460; -- invalid input
	WHEN inAuthorId IS NULL AND inAuthorId NOT IN (SELECT Author_Id FROM Author) THEN
		SET statusCode = 460; -- invalid input
	When inCategoryId IS NULL AND inCategoryId NOT IN (SELECT Cat_Id FROM Category) THEN
		SET statusCode = 460; -- invalid input
    WHEN inISBN IN (SELECT ISBN FROM Book) THEN
		SET statusCode = 412; -- ISBN already exists
	ELSE
		SET statusCode = 200;
		INSERT INTO Book (ISBN,Title,Book_Language,Author_Id,Category_Id,No_Copy_Actual,No_Copy_Current)
		VALUES (inISBN,inTitle,inLanguage,(SELECT Author_PK FROM Author WHERE Author_Id = inAuthorId),(SELECT Cat_PK FROM Category WHERE Cat_Id = inCategoryId),inNoActual,inNoCurrent);
	END CASE;
END//

DELIMITER ;

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

DELIMITER //

DROP PROCEDURE IF EXISTS getAuthor //
CREATE PROCEDURE getAuthor (
    OUT statusCode INT
)
BEGIN
	SET statusCode = 200; 
	SELECT Author_Id, Author_Name
	FROM Author;
END//

DELIMITER ;

DELIMITER //

DROP PROCEDURE IF EXISTS getCategory //
CREATE PROCEDURE getCategory (
    OUT statusCode INT
)
BEGIN
	SET statusCode = 200; 
	SELECT Cat_Id,Cat_Name
	FROM Category ;
END//

DELIMITER ;

DELIMITER //

DROP PROCEDURE IF EXISTS getBook //
CREATE PROCEDURE getBook (
    OUT statusCode INT
)
BEGIN
	SET statusCode = 200; 
	SELECT ISBN, Title, Book_Language, A.Author_Id, Cat_Id, No_Copy_Actual, No_Copy_Current
	FROM Book B 
    INNER JOIN Author A ON B.Author_Id = A.Author_PK
    INNER JOIN Category C ON B.Category_Id = C.Cat_PK;
END//

DELIMITER ;

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

DELIMITER //

DROP PROCEDURE IF EXISTS getBorrower //
CREATE PROCEDURE getBorrower (
    OUT statusCode INT
)
BEGIN
	SET statusCode = 200; 
	SELECT Borrower_Id,Student_Name, Title, ISBN, Borrowed_from, Borrowed_to, Returned_date, Staff_Id
	FROM Borrower R
    INNER JOIN Book B ON R.Book_Id = B.Book_PK
    INNER JOIN Student S ON R.Borrower_Num = S.Student_PK
    INNER JOIN Staff F ON R.Issued_by = F.Staff_PK;
END//

DELIMITER ;

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





 








