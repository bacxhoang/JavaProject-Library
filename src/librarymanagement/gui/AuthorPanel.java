package librarymanagement.gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class AuthorPanel extends AbstractPanel {
	private DefaultTableModel tableModel;
	private JPanel contentPane;
	
	public AuthorPanel() { 
	super(); 
	table = new JTable();
	String[] columms = new String [] {"Author_Id", "Author Name"};
	tableModel = new DefaultTableModel();
	tableModel.setColumnIdentifiers(columms);
	table.setModel(tableModel);
	
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setBounds(10, 10, 546, 319);
	add(scrollPane);
	}
	
	void handleBtnRefresh(ActionEvent evt) {
		Object[][] data = new Object [][] {
			{"1","Mark Twain"},
			{"2","Stephen King"},
			{"3","J K Rowlings"},
			{"4","Charles Dicken"},
			{"5","Agatha Christie"},
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