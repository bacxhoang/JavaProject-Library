package librarymanagement.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CategoryPanel extends JPanel {


	/**
	 * Create the panel.
	 */

		private JTextField textField;
		private JTextField textField_1;
		private JTable table;

		/**
		 * Create the panel.
		 */
		public CategoryPanel() {
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Category Id");
			lblNewLabel.setBounds(10, 36, 89, 13);
			add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Category Name");
			lblNewLabel_1.setBounds(10, 72, 89, 13);
			add(lblNewLabel_1);
			
			JTextField categoryIdTF = new JTextField();
			categoryIdTF.setBounds(109, 33, 96, 19);
			add(categoryIdTF);
			categoryIdTF.setColumns(10);
			
			JTextField categoryNameTF = new JTextField();
			categoryNameTF.setBounds(109, 69, 96, 19);
			add(categoryNameTF);
			categoryNameTF.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(244, 36, 349, 294);
			add(scrollPane);
			Object[][] data= {};
			String col[] = {"Category Id", "Category Name"
			};
			
			JTable categoryTable = new JTable(data, col);
			categoryTable.setBounds(244, 36, 349, 294);
			scrollPane.setViewportView(categoryTable);
			
			JButton btnAddButton = new JButton("Add");
			btnAddButton.setBounds(77, 362, 85, 21);
			add(btnAddButton);
			
			JButton btnUpdateButton = new JButton("Update");
			btnUpdateButton.setBounds(379, 362, 85, 21);
			add(btnUpdateButton);

	}
}
