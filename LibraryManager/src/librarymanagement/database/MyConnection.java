package librarymanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
    
    
    // create a function to connect with mysql database
    
    public static Connection getConnection(){
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "123456");
            return con;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
		return null;
    }
    
}    
