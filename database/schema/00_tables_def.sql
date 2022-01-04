
 
 CREATE TABLE IF NOT EXISTS Author (
	Author_Id INT NOT NULL,
    Author_Name VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (Author_Id)
);

 CREATE TABLE IF NOT EXISTS Category (
	Cat_Id INT NOT NULL,
    Cat_Name VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (Cat_Id)
);

CREATE TABLE IF NOT EXISTS Book (
  ISBN INT NOT NULL,
  Title VARCHAR(100),
  Book_language VARCHAR(20),
  Author_Id INT,
  Category_Id INT,
  No_Copy_Actual INT,
  No_Copy_Current INT,
  
  PRIMARY KEY (ISBN),
  FOREIGN KEY (Category_Id) REFERENCES Category (Cat_Id),
  FOREIGN KEY (Author_Id) REFERENCES Author (Author_Id)
);

 CREATE TABLE IF NOT EXISTS Staff (
 Staff_Id INT NOT NULL,
 User_Name VARCHAR(30) NOT NULL,
 Login_Password VARCHAR(16) NOT NULL,
 isAdmin BOOLEAN,
 
 PRIMARY KEY (Staff_Id),
 CONSTRAINT Username_Unique UNIQUE (User_Name)
 );
    
CREATE TABLE IF NOT EXISTS Borrower (
	Borrower_Id INT NOT NULL,
    Book_Id INT NOT NULL,
    Borrowed_from TIME,
    Borrowed_to TIME,
    Returned_date TIME,
    Issued_by INT,
    
    PRIMARY KEY (Borrower_Id),
    FOREIGN KEY (Book_Id) REFERENCES Book (ISBN) ON DELETE CASCADE,
    FOREIGN KEY (Issued_by) REFERENCES Staff (Staff_Id) ON DELETE CASCADE
);
    

 
  CREATE TABLE IF NOT EXISTS Student (
 Student_Id INT NOT NULL,
 Student_Name VARCHAR(50) NOT NULL,
 Borrower_Id INT,
 Phone_Number INT,
 
 PRIMARY KEY (Student_Id),
 FOREIGN KEY (Borrower_Id) REFERENCES Borrower (Borrower_Id) ON DELETE CASCADE,
 CONSTRAINT Borrower_Unique UNIQUE (Borrower_Id),
 CONSTRAINT Phonenumber_Unique UNIQUE (Phone_Number)
 );
 
 








