package librarymanagement.gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

class AuthorPanel extends AbstractPanel {
	private DefaultTableModel tableModel;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JTable table;
	public AuthorPanel() { 
	super(); 
	
	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(122, 62, 96, 19);
	getContentPane().add(textField);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(122, 97, 96, 19);
	getContentPane().add(textField_1);
	
	JLabel lblAuthorid = new JLabel("AuthorId");
	lblAuthorid.setBounds(35, 65, 45, 13);
	getContentPane().add(lblAuthorid);
	
	JLabel lblNewLabel_1 = new JLabel("AuthorName");
	lblNewLabel_1.setBounds(35, 100, 77, 13);
	getContentPane().add(lblNewLabel_1);
	table = new JTable();
	String[] columms = new String [] {"Author_Id", "Author Name"};
	tableModel = new DefaultTableModel();
	tableModel.setColumnIdentifiers(columms);
	table.setModel(tableModel);
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
				JOptionPane.showMessageDialog(null, "DELETE ERROR!!");

	}
}