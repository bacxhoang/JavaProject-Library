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

public class BookPanel extends AbstractPanel {
	private DefaultTableModel tableModel;
	private JPanel contentPane;

	
	public BookPanel() {
		super();
		table = new JTable();
		String[] columms = new String [] {"ISBN", "Title", "Language", "AuthorId", "CategoryId", "No_of_current", "No_of_actual"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columms);
		table.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 546, 319);
		add(scrollPane);

	}
	
	@Override
	void handleBtnRefresh(ActionEvent evt) {
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