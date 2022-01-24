package librarymanagement.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class LaunchPage{


	private JFrame launchPage;
	private JButton RegisterButton;
	private JButton LoginButton;
	private JPanel contentPane;


	/**
	 * Create the application.
	 */
	public LaunchPage() {
		
	
		launchPage = new JFrame();
		launchPage.setBounds(450, 190, 1014, 597);
		launchPage.setResizable(false);
		launchPage.setVisible(true);
		launchPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    launchPage.setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    
		RegisterButton = new JButton("Register");
		RegisterButton.setBounds(388,272,242,79);
		RegisterButton.setFocusable(false);
		contentPane.add(RegisterButton);
		
		LoginButton = new JButton("Login");
		LoginButton.setBounds(388,390,242,79);
		LoginButton.setFocusable(false);
		contentPane.add(LoginButton);
		
		
		JLabel lblNewLabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(275, 94, 487, 90);
		contentPane.add(lblNewLabel);
		
	





	RegisterButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		launchPage.dispose();
		UserRegistration registrationframe = new UserRegistration();
		registrationframe.setVisible(true);
		

		
	}
	});
	LoginButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {;
		launchPage.dispose();
		UserLogin loginframe = new UserLogin();
		loginframe.setVisible(true);
		
	}
	});
	
}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}



