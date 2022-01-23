package librarymanagement.gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

class StudentPanel extends AbstractPanel {
	private DefaultTableModel tableModel;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JTable table;
	public StudentPanel() { 
	super(); 
	
	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(118, 64, 96, 19);
	getContentPane().add(textField);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(118, 99, 96, 19);
	getContentPane().add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(118, 143, 96, 19);
	getContentPane().add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(118, 185, 96, 19);
	getContentPane().add(textField_3);
	
	JLabel lblNewLabel = new JLabel("StudentId");
	lblNewLabel.setBounds(31, 67, 45, 13);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("StudentName");
	lblNewLabel_1.setBounds(31, 102, 77, 13);
	getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("BorrowerId");
	lblNewLabel_2.setBounds(31, 146, 77, 13);
	getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Phone Number");
	lblNewLabel_3.setBounds(31, 188, 77, 13);
	getContentPane().add(lblNewLabel_3);
	table = new JTable();
	String[] columms = new String [] {"Student_Id", "Student Name", "Borrower_Id", "Phone Number" };
	tableModel = new DefaultTableModel();
	tableModel.setColumnIdentifiers(columms);
	table.setModel(tableModel);
	}
	
	void handleBtnRefresh(ActionEvent evt) {
		Object[][] data = new Object [][] {
			{"1001", "Peter Parker","10001","0123456789"},
			{"1002", "Ned Leeds","10002","1234567890"},
			{"1003", "Marry Jane","10003","1237894560"},
			{"1004", "Gwen Stacy","10004","0987654321"},
			{"1005", "Barry Allen","10005","025917782"},
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