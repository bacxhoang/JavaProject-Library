package librarymanagement.api;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField staffId;
    private JTextField username;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JPasswordField repasswordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nhoc_\\Downloads\\Adobe Scan 03 Sep 2021_1.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Staff Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(421, 53, 237, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblstaffId = new JLabel("Staff\r\n ID");
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

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(58, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(58, 245, 99, 29);
        contentPane.add(lblPassword);
       
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(214, 235, 228, 50);
        contentPane.add(passwordField);
        
        
        
        btnNewButton = new JButton("Register");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Re-Password");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(582, 245, 119, 29);
        contentPane.add(lblNewLabel);
        
        repasswordField = new JPasswordField();
        repasswordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        repasswordField.setColumns(10);
        repasswordField.setBounds(707, 235, 228, 50);
        contentPane.add(repasswordField);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String staffID = staffId.getText();
                String userName = username.getText();
				String password = String.valueOf(passwordField.getPassword());
                String msg = "" + userName;
                msg += " \n";
                
     
            

                 try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "123456");
                    String query = "INSERT INTO Staff values('"+ staffID + "','" + userName + "','" + password + "')";
                    if(String.valueOf(passwordField.getPassword()) != String.valueOf(repasswordField.getPassword())) {
                    	JOptionPane.showMessageDialog(btnNewButton, "Password not match, please retype your password");
                    }
                    else {
                    Statement sta = connection.createStatement();
                    
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is already exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                    }
                } 
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                }
           
        });
   
    }
}