package librarymanagement.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StudentPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setBounds(10, 36, 89, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setBounds(10, 72, 89, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Borrower Id");
		lblNewLabel_2.setBounds(10, 117, 103, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBounds(10, 165, 89, 13);
		add(lblNewLabel_3);
		
		
		JTextField studentIdTF = new JTextField();
		studentIdTF.setBounds(109, 33, 96, 19);
		add(studentIdTF);
		studentIdTF.setColumns(10);
		
		JTextField studentNameTF = new JTextField();
		studentNameTF.setBounds(109, 69, 96, 19);
		add(studentNameTF);
		studentNameTF.setColumns(10);
		
		JTextField borrowerNumberTF = new JTextField();
		borrowerNumberTF.setBounds(109, 114, 96, 19);
		add(borrowerNumberTF);
		borrowerNumberTF.setColumns(10);
		
		JTextField phoneNumTF = new JTextField();
		phoneNumTF.setBounds(109, 162, 96, 19);
		add(phoneNumTF);
		phoneNumTF.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 36, 349, 294);
		add(scrollPane);
		Object[][] data= {};
		String col[] = {"Student Id", "Student Name", "Borrower Id", "Phone Number"
		};
		
		JTable studentPanel = new JTable(data, col);
		studentPanel.setBounds(244, 36, 349, 294);
		scrollPane.setViewportView(studentPanel);
		
		JButton btnAddButton = new JButton("Add");
		btnAddButton.setBounds(77, 362, 85, 21);
		add(btnAddButton);
		
		JButton btnUpdateButton = new JButton("Update");
		btnUpdateButton.setBounds(379, 362, 85, 21);
		add(btnUpdateButton);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.setBounds(230, 362, 85, 21);
		add(btnDeleteButton);

	}
}
