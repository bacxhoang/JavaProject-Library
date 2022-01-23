package librarymanagement.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import librarymanagement.resource.Book;

import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class BookPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BookPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(10, 36, 45, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setBounds(10, 72, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book Language");
		lblNewLabel_2.setBounds(10, 117, 103, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AuthorId");
		lblNewLabel_3.setBounds(10, 165, 45, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CategoryId");
		lblNewLabel_4.setBounds(10, 206, 103, 13);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Number of Actual");
		lblNewLabel_5.setBounds(10, 260, 103, 13);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Number of Current");
		lblNewLabel_6.setBounds(10, 312, 108, 13);
		add(lblNewLabel_6);
		
		JTextField isbnTF = new JTextField();
		isbnTF.setBounds(124, 33, 96, 19);
		add(isbnTF);
		isbnTF.setColumns(10);
		
		JTextField titleTF = new JTextField();
		titleTF.setBounds(124, 69, 96, 19);
		add(titleTF);
		titleTF.setColumns(10);
		
		JTextField bookLangTF = new JTextField();
		bookLangTF.setBounds(124, 114, 96, 19);
		add(bookLangTF);
		bookLangTF.setColumns(10);
		
		JTextField authorIdTF = new JTextField();
		authorIdTF.setBounds(124, 162, 96, 19);
		add(authorIdTF);
		authorIdTF.setColumns(10);
		
		JTextField categoryIdTF = new JTextField();
		categoryIdTF.setColumns(10);
		categoryIdTF.setBounds(124, 203, 96, 19);
		add(categoryIdTF);
		
		JTextField noactualTF = new JTextField();
		noactualTF.setBounds(124, 257, 96, 19);
		add(noactualTF);
		noactualTF.setColumns(10);
		
		JTextField nocurrentlTF = new JTextField();
		nocurrentlTF.setBounds(124, 309, 96, 19);
		add(nocurrentlTF);
		nocurrentlTF.setColumns(10);
		
		JButton btnAddButton = new JButton("Add");
		btnAddButton.setBounds(77, 362, 85, 21);
		add(btnAddButton);
		
		JButton btnUpdateButton = new JButton("Update");
		btnUpdateButton.setBounds(379, 362, 85, 21);
		add(btnUpdateButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 36, 349, 294);
		add(scrollPane);
		Object[][] data= {};
		String col[] = {"ISBN", "Title", "Book Language", "AuthorId", "CategoryId", "Number of Actual", "Number of Current"
		};
		
		JTable bookTable = new JTable(data, col);
		bookTable.setBounds(244, 36, 349, 294);
		scrollPane.setViewportView(bookTable);
		

		
		
		btnAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			Book newBook = null;
			newBook.getAuthorId();
			newBook.getCategoryId();
			newBook.getClass();
			newBook.getIsbn();
			newBook.getLanguage();
			newBook.getNoCopyActual();
			newBook.getTitle();
			}
		});
		
		
		btnUpdateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
	}
}
