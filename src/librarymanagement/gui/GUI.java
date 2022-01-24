package librarymanagement.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import librarymanagement.api.UserLogin;
import javax.swing.JTabbedPane;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;




public class GUI{

	private JFrame GUI;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private BookPanel bookPane;
	private AuthorPanel authorPane;
	private CategoryPanel categoryPane;
	private BorrowerPanel borrowerPane;
	private StudentPanel studentPane;
	private JButton	btnLogoutButton;
	
	public void setVisible(boolean b) {
		GUI.setVisible(true);
		
	}
	public GUI() {
		GUI = new JFrame();
		GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GUI.setBounds(100, 100, 702, 585);
		GUI.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GUI.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(5, 5, 641, 465);
		contentPane.add(tabbedPane);
		
		bookPane = new BookPanel();
		tabbedPane.addTab("Book", null, bookPane, null);
		
		authorPane = new AuthorPanel();
		tabbedPane.addTab("Author", null, authorPane, null);
		
		categoryPane = new CategoryPanel();
		tabbedPane.addTab("Category", null, categoryPane, null);
		
		borrowerPane = new BorrowerPanel();
		tabbedPane.addTab("Borrower", null, borrowerPane, null);
		
		studentPane = new StudentPanel();
		tabbedPane.addTab("Student", null, studentPane, null);
		
		btnLogoutButton = new JButton("Logout");
		btnLogoutButton.setBounds(557, 498, 89, 23);
		contentPane.add(btnLogoutButton);
		btnLogoutButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                int a = JOptionPane.showConfirmDialog(btnLogoutButton, "Are you sure?");
	                // JOptionPane.setRootFrame(null);
	                if (a == JOptionPane.YES_OPTION) {
	                	GUI.dispose();
	                    UserLogin obj = new UserLogin();
	                    obj.setVisible(true);
	                }
	                GUI.dispose();
	                UserLogin obj = new UserLogin();
	                obj.setVisible(true);

	            }
	        });
		


	}
}
