package librarymanagement.gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

class CategoryPanel extends AbstractPanel {
	private DefaultTableModel tableModel;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JTable table;
	public CategoryPanel() { 
	super(); 
	
	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(114, 65, 96, 19);
	getContentPane().add(textField);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(114, 100, 96, 19);
	getContentPane().add(textField_1);
	
	JLabel lblCategoryid = new JLabel("CategoryId");
	lblCategoryid.setBounds(27, 68, 77, 13);
	getContentPane().add(lblCategoryid);
	
	JLabel lblNewLabel_1 = new JLabel("Category Name");
	lblNewLabel_1.setBounds(27, 103, 77, 13);
	getContentPane().add(lblNewLabel_1);
	table = new JTable();
	String[] columms = new String [] {"Category_Id", "Category Name"};
	tableModel = new DefaultTableModel();
	tableModel.setColumnIdentifiers(columms);
	table.setModel(tableModel);
	}
	
	void handleBtnRefresh(ActionEvent evt) {
		Object[][] data = new Object [][] {
			{"11", "ActionAndAdventure"},
			{"12", "Art"},
			{"13", "Fantasy"},
			{"14", "Horror"},
			{"16", "Satire"},
			{"17", "ScienceFiction"},
			{"18", "Thriller"},
			{"19", "Western"},
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
