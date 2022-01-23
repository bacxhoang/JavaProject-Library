package librarymanagement.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

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
		
		
		textField = new JTextField();
		textField.setBounds(109, 33, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 69, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 114, 96, 19);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(109, 162, 96, 19);
		add(textField_3);
		textField_3.setColumns(10);
		
		table = new JTable();
		table.setBounds(230, 36, 334, 292);
		add(table);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(77, 362, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(379, 362, 85, 21);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(230, 362, 85, 21);
		add(btnNewButton_2);

	}
}
