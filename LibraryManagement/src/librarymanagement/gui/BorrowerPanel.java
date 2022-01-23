package librarymanagement.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
		
		JTextField borrowerNumberTF = new JTextField();
		borrowerNumberTF.setBounds(124, 33, 96, 19);
		add(borrowerNumberTF);
		borrowerNumberTF.setColumns(10);
		
		JTextField bookIdTF = new JTextField();
		bookIdTF.setBounds(124, 69, 96, 19);
		add(bookIdTF);
		bookIdTF.setColumns(10);
		
		JTextField borrowedFromTF = new JTextField();
		borrowedFromTF.setBounds(124, 114, 96, 19);
		add(borrowedFromTF);
		borrowedFromTF.setColumns(10);
		
		JTextField borrowedToTF = new JTextField();
		borrowedToTF.setBounds(124, 162, 96, 19);
		add(borrowedToTF);
		borrowedToTF.setColumns(10);
		
		JTextField returnDateTF = new JTextField();
		returnDateTF.setBounds(124, 209, 96, 19);
		add(returnDateTF);
		returnDateTF.setColumns(10);
		
		JTextField issuedByTF = new JTextField();
		issuedByTF.setBounds(124, 260, 96, 19);
		add(issuedByTF);
		issuedByTF.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 36, 349, 294);
		add(scrollPane);
		Object[][] data= {};
		String col[] = {"Borrower Number","Book Id", "Borrowed From", "Borrowed To", "Return Date", "Issued By"
		};
		
		JTable borrowerTable = new JTable(data, col);
		borrowerTable.setBounds(244, 36, 349, 294);
		scrollPane.setViewportView(borrowerTable);
		
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
