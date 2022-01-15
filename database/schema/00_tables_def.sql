
 
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
    
CREATE TABLE IF NOT EXISTS Borrower (
	Borrower_PK INT AUTO_INCREMENT NOT NULL,
	Borrower_Id INT NOT NULL,
    Book_Id INT NOT NULL,
    Borrowed_from DATE NOT NULL,
    Borrowed_to DATE NOT NULL,
    Returned_date DATE DEFAULT NULL,
    Issued_by INT NOT NULL,
    
    PRIMARY KEY (Borrower_PK),
	CONSTRAINT BorrowerId_Unique UNIQUE (Borrower_Id),
    FOREIGN KEY (Book_Id) REFERENCES Book (Book_PK) ON DELETE CASCADE,
    FOREIGN KEY (Issued_by) REFERENCES Staff (Staff_PK) ON DELETE CASCADE
);
    

 
  CREATE TABLE IF NOT EXISTS Student (
 Student_PK INT AUTO_INCREMENT NOT NULL,
 Student_Id INT NOT NULL,
 Student_Name VARCHAR(50) NOT NULL,
 Borrower_Id INT NOT NULL,
 Phone_Number INT NOT NULL,
 
 PRIMARY KEY (Student_PK),
 FOREIGN KEY (Borrower_Id) REFERENCES Borrower (Borrower_PK) ON DELETE CASCADE,
 CONSTRAINT StudentId_Unique UNIQUE (Student_Id),
 CONSTRAINT Borrower_Unique UNIQUE (Borrower_Id),
 CONSTRAINT Phonenumber_Unique UNIQUE (Phone_Number)
 );
 
 








