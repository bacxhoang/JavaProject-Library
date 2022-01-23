package librarymanagement.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
			
			textField = new JTextField();
			textField.setBounds(109, 33, 96, 19);
			add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(109, 69, 96, 19);
			add(textField_1);
			textField_1.setColumns(10);
			
			table = new JTable();
			table.setBounds(230, 36, 334, 292);
			add(table);
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setBounds(77, 362, 85, 21);
			add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Update");
			btnNewButton_1.setBounds(379, 362, 85, 21);
			add(btnNewButton_1);

	}
}
