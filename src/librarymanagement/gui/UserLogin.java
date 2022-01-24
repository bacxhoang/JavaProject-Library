
package librarymanagement.gui;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;


import librarymanagement.resource.Staff;
import librarymanagement.database.MyConnection;



public class UserLogin{
	private JFrame UserLogin;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	private JButton btnLoginButton;
	private JButton btnBack;
	private JLabel lblUserLogin;
	private JLabel lblUsername;
	private JLabel  lblPassword;
	

	
	public void setVisible(boolean b) {
		UserLogin.setVisible(true);
		
	}



	public UserLogin() {
		UserLogin = new JFrame();
		UserLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UserLogin.setBounds(450, 190, 1014, 597);
		UserLogin.setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        UserLogin.setContentPane(contentPane);
        contentPane.setLayout(null);


        lblUserLogin = new JLabel("Staff Login");
        lblUserLogin.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblUserLogin.setBounds(421, 53, 237, 50);
        contentPane.add(lblUserLogin);
        
        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(399, 181, 228, 50);
        contentPane.add(username);
        username.setColumns(10);


        lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(290, 196, 99, 29);
        contentPane.add(lblUsername);


        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(290, 291, 99, 29);
        contentPane.add(lblPassword);
       
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(399, 276, 228, 50);
        contentPane.add(passwordField);
        
        
        btnLoginButton = new JButton("Login");
        btnLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnLoginButton.setBounds(130, 425, 259, 74);
        contentPane.add(btnLoginButton);
        
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnBack.setBounds(625, 425, 259, 74);
        contentPane.add(btnBack);
        
        btnLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

        Staff staff = new Staff(0, null, null);
				staff.setUsername(username.getText());
				staff.setPassword(String.valueOf(passwordField.getPassword()));

				Connection myConn = null;
				PreparedStatement myStmt = null;
				ResultSet rs = null;
		try {
			 // Connect to database
			myConn = MyConnection.connect();
            // Prepare the stored procedure call
            myStmt = myConn.prepareStatement("Select User_Name, Login_Password from Staff where User_Name=? and Login_Password=?");
            myStmt.setString(1,staff.getUsername());
            myStmt.setString(2,staff.getPassword());
            rs = myStmt.executeQuery();
            if (rs.next()) {
                UserLogin.dispose();
                GUI home = new GUI();
                home.setVisible(true);
                JOptionPane.showMessageDialog(btnLoginButton, "You have successfully logged in");
            } else {
                JOptionPane.showMessageDialog(btnLoginButton, "Wrong Username & Password");
            }
            {
            	myConn.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
});
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		UserLogin.dispose();
        		LaunchPage launchPage = new LaunchPage();
        		launchPage.setVisible(true);
        	}
        });

}
}