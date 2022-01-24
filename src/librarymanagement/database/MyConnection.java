package librarymanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
    
	public static Connection connect() {
        //Making Database Connection once & using multiple times whenenver required.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "123456");
            System.out.println("Connection Successful");
            return con;
        } catch (Exception ex) {
        	System.out.println("Error connecting to Database");
            ex.printStackTrace();
        }
        return null;
    }
    
}    
