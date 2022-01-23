package librarymanagement.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class addButton extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			addButton dialog = new addButton();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public addButton() {
		setBounds(100, 100, 644, 501);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(411, 385, 85, 21);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(53, 385, 85, 21);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(234, 385, 85, 21);
		contentPanel.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(92, 31, 96, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 66, 96, 19);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 110, 96, 19);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(92, 152, 96, 19);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 194, 96, 19);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(92, 232, 96, 19);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(5, 34, 45, 13);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setBounds(5, 69, 45, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("authorId");
		lblNewLabel_2.setBounds(5, 113, 45, 13);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AuthorId");
		lblNewLabel_3.setBounds(5, 155, 45, 13);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CategoryId");
		lblNewLabel_4.setBounds(5, 197, 78, 13);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NoOfCurrent");
		lblNewLabel_5.setBounds(5, 235, 62, 13);
		contentPanel.add(lblNewLabel_5);
		
		table = new JTable();
		table.setBounds(234, 31, 369, 329);
		contentPanel.add(table);
		
		textField_6 = new JTextField();
		textField_6.setBounds(92, 271, 96, 19);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("NoOfActual");
		lblNewLabel_6.setBounds(5, 274, 62, 13);
		contentPanel.add(lblNewLabel_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
