package librarymanagement.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import librarymanagement.database.MyConnection;
import librarymanagement.resource.Author;
import librarymanagement.resource.Book;
import librarymanagement.resource.Borrower;

public class BorrowerPanel extends JPanel {
	/**
	 * Create the panel.
	 */
	public BorrowerPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Borrower Number");
		lblNewLabel.setBounds(10, 36, 103, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Id");
		lblNewLabel_1.setBounds(10, 72, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Borrowed From");
		lblNewLabel_2.setBounds(10, 117, 103, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Borrowed To");
		lblNewLabel_3.setBounds(10, 165, 89, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Return Date");
		lblNewLabel_4.setBounds(10, 212, 103, 13);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Issued By");
		lblNewLabel_5.setBounds(10, 263, 103, 13);
		add(lblNewLabel_5);
		
		JTextField borrowerNumberTF = new JTextField();
		borrowerNumberTF.setBounds(124, 33, 96, 19);
		add(borrowerNumberTF);
		borrowerNumberTF.setColumns(10);
		
		JTextField bookIdTF = new JTextField();
		bookIdTF.setBounds(124, 69, 96, 19);
		add(bookIdTF);
		bookIdTF.setColumns(10);
		
		JTextField borrowedFromTF = new JTextField();
		borrowedFromTF.setBounds(124, 114, 96, 19);
		add(borrowedFromTF);
		borrowedFromTF.setColumns(10);
		
		JTextField borrowedToTF = new JTextField();
		borrowedToTF.setBounds(124, 162, 96, 19);
		add(borrowedToTF);
		borrowedToTF.setColumns(10);
		
		JTextField returnDateTF = new JTextField();
		returnDateTF.setBounds(124, 209, 96, 19);
		add(returnDateTF);
		returnDateTF.setColumns(10);
		
		JTextField issuedByTF = new JTextField();
		issuedByTF.setBounds(124, 260, 96, 19);
		add(issuedByTF);
		issuedByTF.setColumns(10);
		
		
		JButton btnAddButton = new JButton("Add");
		btnAddButton.setBounds(77, 362, 85, 21);
		add(btnAddButton);
		
		JButton btnUpdateButton = new JButton("Update");
		btnUpdateButton.setBounds(379, 362, 85, 21);
		add(btnUpdateButton);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.setBounds(230, 362, 85, 21);
		add(btnDeleteButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 36, 349, 294);
		add(scrollPane);

		String col[] = {"Borrower Number","Book Id", "Borrowed From", "Borrowed To", "Return Date", "Issued By"
		};
		
		JTable borrowerTable = new JTable();
		scrollPane.setViewportView(borrowerTable);
		DefaultTableModel borrowerModel = new DefaultTableModel();
		borrowerTable.setModel(borrowerModel);
		borrowerModel.setColumnIdentifiers(col);
		
		
		btnAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			}
			
		});
		
		
		btnUpdateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connect = MyConnection.connect();
					String sql = "SELECT * FROM BORROWER"; 
					//Create connection to Database

					Statement stmt =  connect.createStatement(); 

				//Executing query

					ResultSet rs = stmt.executeQuery(sql);
                    

                    //Setting up table auto-resizable.
					borrowerTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					borrowerTable.setFillsViewportHeight(true);
					borrowerTable.setFocusable(false);
						while(rs.next()) {
							Borrower newBorrower = new Borrower();
							int borrowerId = newBorrower.getborrowerId(rs.getInt(2));
							int bookId = newBorrower.getBookId(rs.getInt(3));
							Date borrowedFrom = newBorrower.getBorrowedFrom(rs.getDate(4));
							Date borrowedTo = newBorrower.getBorrowedTo(rs.getDate(5));
							Date returnedDate = newBorrower.getReturnedDate(rs.getDate(6));
							int issuedBy = newBorrower.getIssuedBy(rs.getInt(7));
							borrowerModel.addRow(new Object[] {borrowerId, bookId, borrowedFrom, borrowedTo, returnedDate, issuedBy});
						}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		btnDeleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
			
		});
	}
}
