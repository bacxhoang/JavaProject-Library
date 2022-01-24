package librarymanagement.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import librarymanagement.resource.Book;
import librarymanagement.database.*;

import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class BookPanel extends JPanel {
	
	private JLabel lblisbn;
	private JLabel lblTitle;
	private JLabel lblLanguage;
	private JLabel lblauthorId;
	private JLabel lblcategoryId;
	private JLabel lblNoActual;
	private JLabel lblNoCurrent;
	private JTextField isbn;
	private JTextField title;
	private JTextField bookLang;
	private JTextField authorId;
	private JTextField categoryId;
	private JTextField noactual;
	private JTextField nocurrent;
	private JButton btnAddButton;
	private JButton btnUpdateButton;
	private JScrollPane scrollPane;
	private JTable bookTable;
	private DefaultTableModel bookModel;
	
	public BookPanel() {
		setLayout(null);
		
		lblisbn = new JLabel("ISBN");
		lblisbn.setBounds(10, 36, 45, 13);
		add(lblisbn);
		
		lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 72, 45, 13);
		add(lblTitle);
		
		lblLanguage = new JLabel("Book Language");
		lblLanguage.setBounds(10, 117, 103, 13);
		add(lblLanguage);
		
		lblauthorId = new JLabel("AuthorId");
		lblauthorId.setBounds(10, 165, 45, 13);
		add(lblauthorId);
		
		lblcategoryId = new JLabel("CategoryId");
		lblcategoryId.setBounds(10, 206, 103, 13);
		add(lblcategoryId);
		
		lblNoActual = new JLabel("Number of Actual");
		lblNoActual.setBounds(10, 260, 103, 13);
		add(lblNoActual);
		
		lblNoCurrent = new JLabel("Number of Current");
		lblNoCurrent.setBounds(10, 312, 108, 13);
		add(lblNoCurrent);
		
		isbn = new JTextField();
		isbn.setBounds(124, 33, 96, 19);
		add(isbn);
		isbn.setColumns(10);
		
		title = new JTextField();
		title.setBounds(124, 69, 96, 19);
		add(title);
		title.setColumns(10);
		
		bookLang = new JTextField();
		bookLang.setBounds(124, 114, 96, 19);
		add(bookLang);
		bookLang.setColumns(10);
		
		authorId = new JTextField();
		authorId.setBounds(124, 162, 96, 19);
		add(authorId);
		authorId.setColumns(10);
		
		categoryId = new JTextField();
		categoryId.setColumns(10);
		categoryId.setBounds(124, 203, 96, 19);
		add(categoryId);
		
		noactual = new JTextField();
		noactual.setBounds(124, 257, 96, 19);
		add(noactual);
		noactual.setColumns(10);
		
		nocurrent = new JTextField();
		nocurrent.setBounds(124, 309, 96, 19);
		add(nocurrent);
		nocurrent.setColumns(10);
		
		btnAddButton = new JButton("Add");
		btnAddButton.setBounds(77, 362, 85, 21);
		add(btnAddButton);
		
		btnUpdateButton = new JButton("Update");
		btnUpdateButton.setBounds(379, 362, 85, 21);
		add(btnUpdateButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 36, 306, 290);
		add(scrollPane);
		
		bookTable = new JTable();
		scrollPane.setViewportView(bookTable);
		
		String[] col = {"ISBN", "Title", "Book Language", "AuthorId", "CategoryId", "Number of Actual", "Number of Current"
		};
		bookModel = new DefaultTableModel() {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};

		bookModel.setColumnIdentifiers(col);
		bookTable.setModel(bookModel);
		
		
		btnAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int ISBN = Integer.valueOf(isbn.getText());
				String Title = title.getText();
				String BookLanguage = bookLang.getText();
				int AuthorId = Integer.valueOf(authorId.getText());
				int CategoryId = Integer.valueOf(categoryId.getText());
				int NoActual = Integer.valueOf(noactual.getText());
				int NoCurrent = Integer.valueOf(nocurrent.getText());
				Connection myConn = null;
				String createBook = "{call createBook(?,?,?,?,?,?,?,?)}";
				CallableStatement myStmt = null;
			try {
				// Connect to database
            	myConn = MyConnection.connect();
                // Prepare the stored procedure call
                myStmt = myConn.prepareCall(createBook);
                // Set parameter
                myStmt.setInt(1,ISBN);
                myStmt.setString(2,Title);
                myStmt.setString(3,BookLanguage);
                myStmt.setInt(4,AuthorId);
                myStmt.setInt(5,CategoryId);
                myStmt.setInt(6,NoActual);
                myStmt.setInt(7,NoCurrent);
                myStmt.registerOutParameter(8,Types.INTEGER);
                myStmt.execute();
               int status = myStmt.getInt(8);
             if (status != 200) {
                 throw new SQLCustomException(status);
               }
             else {
            	 JOptionPane.showMessageDialog(btnAddButton, "Added Successfully ");
				
			}
			 } catch (SQLException ex) {
            	 JOptionPane.showMessageDialog(btnAddButton, "Error: "+ex.toString());
               
			}
			}
		});
		
		
		btnUpdateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					bookModel.setRowCount(0);
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
							String ISBN = String.valueOf(rs.getInt("ISBN"));
							String Title = rs.getString("Title");
							String BookLanguage = rs.getString("Book_language");
							String AuthorId = String.valueOf(rs.getInt("Author_Id"));
							String CategoryId = String.valueOf(rs.getInt("Category_Id"));
							String NoActual = String.valueOf(rs.getInt("No_Copy_Actual"));
							String NoCurrent = String.valueOf(rs.getInt("No_Copy_Current"));
							
							String tbData[] = {ISBN,Title,BookLanguage,AuthorId,CategoryId,NoActual,NoCurrent};
							DefaultTableModel tblModel = (DefaultTableModel)bookTable.getModel();
							tblModel.addRow(tbData);
						}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		bookTable.addMouseListener(new MouseAdapter() {
			private void JTableMouseClicked() {
				// TODO Auto-generated method stub

			}
			@Override
			public void mouseClicked(MouseEvent evt) {
				int selectedRowIndex = bookTable.getSelectedRow();
				
				isbn.setText(bookModel.getValueAt(selectedRowIndex, 0).toString());
				title.setText(bookModel.getValueAt(selectedRowIndex, 1).toString());
				bookLang.setText(bookModel.getValueAt(selectedRowIndex, 2).toString());
				authorId.setText(bookModel.getValueAt(selectedRowIndex, 3).toString());
				categoryId.setText(bookModel.getValueAt(selectedRowIndex, 4).toString());
				noactual.setText(bookModel.getValueAt(selectedRowIndex, 5).toString());
				nocurrent.setText(bookModel.getValueAt(selectedRowIndex, 6).toString());
			}
		});
	}
}
