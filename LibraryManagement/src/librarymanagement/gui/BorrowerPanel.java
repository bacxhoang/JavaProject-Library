package librarymanagement.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BorrowerPanel extends JPanel {
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
	public BorrowerPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Borrower Number");
		lblNewLabel.setBounds(10, 36, 103, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Id");
		lblNewLabel_1.setBounds(10, 72, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Borrowed From");
		lblNewLabel_2.setBounds(10, 117, 103, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Borrowed To");
		lblNewLabel_3.setBounds(10, 165, 89, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Return Date");
		lblNewLabel_4.setBounds(10, 212, 103, 13);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Issued By");
		lblNewLabel_5.setBounds(10, 263, 103, 13);
		add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(124, 33, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 69, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 114, 96, 19);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(124, 162, 96, 19);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(124, 209, 96, 19);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(124, 260, 96, 19);
		add(textField_5);
		textField_5.setColumns(10);
		
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
