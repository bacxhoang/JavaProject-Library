package librarymanagement.gui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class BookPanel extends AbstractPanel {
	private DefaultTableModel tableModel;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	JTable table;
	
	public BookPanel() {
		super();
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(115, 62, 96, 19);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 97, 96, 19);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 141, 96, 19);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(115, 183, 96, 19);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(115, 225, 96, 19);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(115, 263, 96, 19);
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(28, 65, 45, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setBounds(28, 100, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("authorId");
		lblNewLabel_2.setBounds(28, 144, 45, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AuthorId");
		lblNewLabel_3.setBounds(28, 186, 45, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CategoryId");
		lblNewLabel_4.setBounds(28, 228, 78, 13);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NoOfCurrent");
		lblNewLabel_5.setBounds(28, 266, 62, 13);
		getContentPane().add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(115, 302, 96, 19);
		getContentPane().add(textField_6);
		
		JLabel lblNewLabel_6 = new JLabel("NoOfActual");
		lblNewLabel_6.setBounds(28, 305, 62, 13);
		getContentPane().add(lblNewLabel_6);
		table = new JTable();
		String[] columms = new String [] {"ISBN", "Title", "Language", "AuthorId", "CategoryId", "No_of_current", "No_of_actual"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columms);
		table.setModel(tableModel);

	}
	
	@Override
	void handleBtnUpdate(ActionEvent evt) {
		Object[][] data = new Object [][] {
			{"101", "Harry Potter","English","3","13","10","10"},
			{"102", "It","English","2","14","5","5"},
			{"103", "The Shining","English","2","14","10","10"},
			{"104", "Cujo","English","2","14","3","3"},
			{"105", "The Adventure of Tom Sawyer","English","1","16","15","15"},
			{"106", "A Christmas Carol","English","4","18","5","5"},
		};
		
		int len = data.length;
		for(int i=0; i<len; i++){
			tableModel.addRow(data[i]);
		}
	}

	@Override
	void handleBtnAdd(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void handleBtnDelete(ActionEvent evt) {
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