-- Add into Database Staff --
CALL Register('13298','bacxhoang','123456',@statusCode);
-- Add into Database Authors --
CALL createAuthor('1','Mark Twain', @statusCode);
CALL createAuthor('2','Stephen King', @statusCode);
CALL createAuthor('3','J K Rowlings', @statusCode);
CALL createAuthor('4','Charles Dicken', @statusCode);
CALL createAuthor('5','Agatha Christie', @statusCode);
-- Add into Database Categories --
CALL createCategory('11', 'ActionAndAdventure', @statusCode);
CALL createCategory('12', 'Art', @statusCode);
CALL createCategory('13', 'Fantasy', @statusCode);
CALL createCategory('14', 'Horror', @statusCode);
CALL createCategory('15', 'Poetry', @statusCode);
CALL createCategory('16', 'Satire', @statusCode);
CALL createCategory('17', 'ScienceFiction', @statusCode);
CALL createCategory('18', 'Thriller', @statusCode);
CALL createCategory('19', 'Western', @statusCode);
-- Add into Database Books --
CALL createBook('101', 'Harry Potter','English','3','13','10','10', @statusCode);
CALL createBook('102', 'It','English','2','14','5','5', @statusCode);
CALL createBook('103', 'The Shining','English','2','14','10','10', @statusCode);
CALL createBook('104', 'Cujo','English','2','14','3','3', @statusCode);
CALL createBook('105', 'The Adventure of Tom Sawyer','English','1','16','15','15', @statusCode);
CALL createBook('106', 'A Christmas Carol','English','4','18','5','5', @statusCode);
-- Add into Database Students --
CALL createStudent('1001', 'Peter Parker','10001','0123456789', @statusCode);
CALL createStudent('1002', 'Ned Leeds','10002','1234567890', @statusCode);
CALL createStudent('1003', 'Mary Jane','10003','1237894560', @statusCode);
CALL createStudent('1004', 'Gwen Stacy','10004','0987654321', @statusCode);
CALL createStudent('1005', 'Barry Allen','10005','025917782', @statusCode);
-- Add into Database Borrowers --
CALL createBorrower('10001', '101','2022-1-16','2022-2-15','13298', @statusCode);
CALL createBorrower('10001', '104','2022-1-16','2022-2-15','13298', @statusCode);
CALL createBorrower('10002', '102','2022-1-16','2022-2-15','13298', @statusCode);
CALL createBorrower('10003', '101','2022-1-16','2022-2-15','13298', @statusCode);
CALL createBorrower('10004', '103','2022-1-16','2022-2-15','13298', @statusCode);
CALL createBorrower('10005', '103','2022-1-16','2022-2-15','13298', @statusCode);


