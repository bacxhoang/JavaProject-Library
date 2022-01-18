package librarymanagement.gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class StudentPanel extends AbstractPanel {
	private DefaultTableModel tableModel;
	private JPanel contentPane;
	
	public StudentPanel() { 
	super(); 
	table = new JTable();
	String[] columms = new String [] {"Student_Id", "Student Name", "Borrower_Id", "Phone Number" };
	tableModel = new DefaultTableModel();
	tableModel.setColumnIdentifiers(columms);
	table.setModel(tableModel);
	
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setBounds(10, 10, 546, 319);
	add(scrollPane);
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