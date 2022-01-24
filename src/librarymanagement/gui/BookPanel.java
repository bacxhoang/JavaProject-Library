package librarymanagement.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import librarymanagement.resource.Book;
import librarymanagement.database.*;

import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class BookPanel extends JPanel {
	private JTable table;
	private JTable table_1;
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
		scrollPane.setBounds(278, 36, 306, 290);
		add(scrollPane);
		
		JTable bookTable = new JTable();
		scrollPane.setViewportView(bookTable);
		
		String[] col = {"ISBN", "Title", "Book Language", "AuthorId", "CategoryId", "Number of Actual", "Number of Current"
		};
		DefaultTableModel bookModel = new DefaultTableModel();

		bookModel.setColumnIdentifiers(col);
		bookTable.setModel(bookModel);
		
		
		btnAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			String isbn = isbnTF.getText();
			String title = titleTF.getText();
			String bookLang = bookLangTF.getText();
			String authorid = authorIdTF.getText();
			String categoryid = categoryIdTF.getText();
			String noofactual= noactualTF.getText();
			String noofcurrent = nocurrentlTF.getText();
			
			if (isbn.isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Please enter isbn"); //Display dialog box with the message
			}	else if (title.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter title"); //Display dialog box with the message
            }	else if (bookLang.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Language");
			}	else if (authorid.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter author id");
			}	else if (categoryid.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter category id");
			}	else if (noofactual.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter number of book actual");
			}	else if (noofcurrent.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter number of book curret");
			}	else {

			}
			}
		});
		
		
		btnUpdateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Connection connect = MyConnection.connect();
					String sql = "SELECT * FROM BOOK"; 
					//Create connection to Database

					Statement stmt =  connect.createStatement(); 

				//Executing query

					ResultSet rs = stmt.executeQuery(sql);
                    

                    //Setting up table auto-resizable.
                    bookTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    bookTable.setFillsViewportHeight(true);
                    bookTable.setFocusable(false);
						while(rs.next()) {
							Book newBook = new Book();
							int Isbn = newBook.getIsbn(rs.getInt(2));
							String Title = newBook.getTitle(rs.getString(3));
							String language = newBook.getLanguage(rs.getString(4));
							int authorId = newBook.getAuthorId(rs.getInt(5));
							int categoryId = newBook.getCategoryId(rs.getInt(6));
							int noCopyActual = newBook.getNoCopyActual(rs.getInt(7));
							int noCopyCurrent = newBook.getNoCopyCurrent(rs.getInt(8));
							bookModel.addRow(new Object[] {Isbn, Title, language, authorId, categoryId, noCopyActual, noCopyCurrent });
						}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}
}
