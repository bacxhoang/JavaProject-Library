package librarymanagement.api;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import librarymanagement.database.MyConnection;
import librarymanagement.database.SQLCustomException;

import java.sql.CallableStatement;

public class UserRegistration{
	private JFrame UserRegistration;
    private JPanel contentPane;
    private JTextField staffId;
    private JTextField username;
    private JPasswordField passwordField;
    private JButton RegisterButton;
    private JButton BackButton;
    private JLabel lblNewUserRegister;
    private JLabel lblstaffId;
    private JLabel lblUsername;
    private JLabel lblPassword;
    
	public void setVisible(boolean b) {
		UserRegistration.setVisible(true);
		
	}

	
    
    public UserRegistration() {
    	UserRegistration = new JFrame();
    	UserRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	UserRegistration.setBounds(450, 190, 1014, 597);
    	UserRegistration.setResizable(false);
    	UserRegistration.setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        UserRegistration.setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewUserRegister = new JLabel("Staff Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(400, 53, 237, 50);
        contentPane.add(lblNewUserRegister);

        lblstaffId = new JLabel("Staff\r\n ID");
        lblstaffId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblstaffId.setBounds(582, 159, 99, 29);
        contentPane.add(lblstaffId);


        staffId = new JTextField();
        staffId.setFont(new Font("Tahoma", Font.PLAIN, 32));
        staffId.setBounds(707, 151, 228, 50);
        contentPane.add(staffId);
        staffId.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(214, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(58, 159, 99, 29);
        contentPane.add(lblUsername);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(58, 245, 99, 29);
        contentPane.add(lblPassword);
       
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(214, 235, 228, 50);
        contentPane.add(passwordField);
        
        RegisterButton = new JButton("Register");
        RegisterButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        RegisterButton.setBounds(145, 420, 259, 74);
        contentPane.add(RegisterButton);
        
        BackButton = new JButton("Back");
        BackButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        BackButton.setBounds(600, 420, 259, 74);
        contentPane.add(BackButton);
   
       

        
        RegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int staffID = Integer.valueOf(staffId.getText());
                String userName = username.getText();
				String password = String.valueOf(passwordField.getPassword());
				Connection myConn = null;
				String register = "{call Register(?,?,?,?)}";
				CallableStatement myStmt = null;
			

                
     
            

                 try {
                	 // Connect to database
                	myConn = MyConnection.connect();
                    // Prepare the stored procedure call
                    myStmt = myConn.prepareCall(register);
                    // Set parameter
                    myStmt.setInt(1,staffID);
                    myStmt.setString(2,userName);
                    myStmt.setString(3,password);
                    myStmt.registerOutParameter(4,Types.INTEGER);
                    myStmt.execute();
                   int status = myStmt.getInt(4);
                 if (status != 200) {
                     throw new SQLCustomException(status);
                   }
                 else {
                	 JOptionPane.showMessageDialog(RegisterButton, "You have successfully registered ");
                	 UserRegistration.dispose();
                	 LaunchPage launchPage = new LaunchPage();
             		 launchPage.setVisible(true);
                
                 }

                 } catch (SQLException ex) {
                	 JOptionPane.showMessageDialog(RegisterButton, "Error: "+ex.toString());
                   
                 }
                }
                
           
        });
        BackButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		UserRegistration.dispose();
        		LaunchPage launchPage = new LaunchPage();
        		launchPage.setVisible(true);
        	
        	}
        });
   
    }







}