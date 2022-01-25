# LIBRARY MANAGEMENT SYSTEM USER GUIDE

## Database setup and connection

Step 1. run init.sql (database/init.sql) to initialize the database (preferably using MySQL WorkBench https://dev.mysql.com/downloads/workbench/)
Step 2. change the username and password inside of MyConnection.java(src/librarymanagement/database/MyConnection.java) to your MySQL username + password (as guided with the commentline)
Step 3. (Optional) run testing_dataset.sql (database/tests/testing_dataset.sql) to populate the database with example data

## Run the Program

Step 1. Run the LibraryManagement.jar
Step 2. Register your Account
Step 3. Login to use the application

## Program functions

Add buttons allow you to add more data into the database
Update buttons allow you to see what inside of the database
Delete buttons allow you to delete Borrowers and Students
Return button allow you to return the book to the shelf whenever a student returns a book