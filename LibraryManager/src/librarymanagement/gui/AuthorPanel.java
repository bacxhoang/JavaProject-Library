package librarymanagement.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AuthorPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AuthorPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("AuthorId");
		lblNewLabel.setBounds(10, 36, 89, 13);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Author Name");
		lblNewLabel_1.setBounds(10, 72, 89, 13);
		add(lblNewLabel_1);

		JTextField authorIdTF = new JTextField();
		authorIdTF.setBounds(109, 33, 96, 19);
		add(authorIdTF);
		authorIdTF.setColumns(10);

		JTextField authorNameTF = new JTextField();
		authorNameTF.setBounds(109, 69, 96, 19);
		add(authorNameTF);
		authorNameTF.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 36, 349, 294);
		add(scrollPane);
		Object[][] data = {};
		String col[] = { "AuthorId", "Author Name" };

		JTable authorTable = new JTable(data, col);
		authorTable.setBounds(244, 36, 349, 294);
		scrollPane.setViewportView(authorTable);

		JButton btnAddButton = new JButton("Add");
		btnAddButton.setBounds(77, 362, 85, 21);
		add(btnAddButton);

		JButton btnUpdateButton = new JButton("Update");
		btnUpdateButton.setBounds(379, 362, 85, 21);
		add(btnUpdateButton);

	}

}
