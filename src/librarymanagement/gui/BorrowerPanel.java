package librarymanagement.gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

class BorrowerPanel extends AbstractPanel {
	private DefaultTableModel tableModel;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	JTable table;
	
	public BorrowerPanel() { 
	super(); 
	
	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(121, 62, 96, 19);
	getContentPane().add(textField);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(121, 97, 96, 19);
	getContentPane().add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(121, 141, 96, 19);
	getContentPane().add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(121, 183, 96, 19);
	getContentPane().add(textField_3);
	
	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setBounds(121, 225, 96, 19);
	getContentPane().add(textField_4);
	
	textField_5 = new JTextField();
	textField_5.setColumns(10);
	textField_5.setBounds(121, 263, 96, 19);
	getContentPane().add(textField_5);
	
	JLabel lblBorrowerid = new JLabel("BorrowerId");
	lblBorrowerid.setBounds(34, 65, 77, 13);
	getContentPane().add(lblBorrowerid);
	
	JLabel lblNewLabel_1 = new JLabel("BookId");
	lblNewLabel_1.setBounds(34, 100, 45, 13);
	getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Borrowed From");
	lblNewLabel_2.setBounds(34, 144, 77, 13);
	getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Borrowed To");
	lblNewLabel_3.setBounds(34, 186, 77, 13);
	getContentPane().add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("ReturnDate");
	lblNewLabel_4.setBounds(34, 228, 78, 13);
	getContentPane().add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Issued By");
	lblNewLabel_5.setBounds(34, 266, 62, 13);
	getContentPane().add(lblNewLabel_5);
	table = new JTable();
	String[] columms = new String [] {"Borrower_Id", "Book_id", "From-to", "Return date", "Librarian_Id"};
	tableModel = new DefaultTableModel();
	tableModel.setColumnIdentifiers(columms);
	table.setModel(tableModel);
	}
	
	void handleBtnRefresh(ActionEvent evt) {
		Object[][] data = new Object [][] {
			{"10001", "101","2022-1-16","2022-2-15","13298"},
			{"10001", "104","2022-1-16","2022-2-15","13298"},
			{"10002", "102","2022-1-16","2022-2-15","13298"},
			{"10003", "101","2022-1-16","2022-2-15","13298"},
			{"10004", "103","2022-1-16","2022-2-15","13298"},
			{"10005", "103","2022-1-16","2022-2-15","13298"},
		};
		
		int len = data.length;
		for(int i=0; i<len; i++){
			tableModel.addRow(data[i]);
		}
	}

	void handleBtnAdd(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	void handleBtnDelete(ActionEvent evt) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int count = table.getRowCount();
		if(count > 0){
			int idx = table.getSelectedRow();
			if (idx >= 0)
				tableModel.removeRow(idx);
			else
				JOptionPane.showMessageDialog(null, "DELETE ERROR!!");
		}
		else
			JOptionPane.showMessageDialog(null, "Table does not contain any records!!");
	}
}