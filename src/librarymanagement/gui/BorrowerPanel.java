package librarymanagement.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import librarymanagement.database.MyConnection;
import librarymanagement.database.SQLCustomException;
import librarymanagement.resource.Author;
import librarymanagement.resource.Book;
import librarymanagement.resource.Borrower;

public class BorrowerPanel extends JPanel {
	private JLabel lblBorrowerNumber;
	private JLabel lblBookId;
	private JLabel lblBorrowedFrom;
	private JLabel lblBorrowedTo;
	private JLabel lblIssuedBy;
	private JTextField borrowerNumber;
	private JTextField bookId;
	private JTextField borrowedFrom;
	private JTextField borrowedTo;
	private JTextField issuedBy;
	private JButton btnAddButton;
	private JButton btnUpdateButton;
	private JButton btnDeleteButton;
	private JScrollPane scrollPane;
	private JTable borrowerTable;
	private DefaultTableModel borrowerModel;
	
	
	public BorrowerPanel() {
		setLayout(null);
		
		lblBorrowerNumber = new JLabel("Borrower Number");
		lblBorrowerNumber.setBounds(10, 36, 103, 13);
		add(lblBorrowerNumber);
		
		lblBookId = new JLabel("Book Id");
		lblBookId.setBounds(10, 72, 45, 13);
		add(lblBookId);
		
		lblBorrowedFrom = new JLabel("Borrowed From");
		lblBorrowedFrom.setBounds(10, 117, 103, 13);
		add(lblBorrowedFrom);
		
		lblBorrowedTo = new JLabel("Borrowed To");
		lblBorrowedTo.setBounds(10, 165, 89, 13);
		add(lblBorrowedTo);
		
		lblIssuedBy = new JLabel("Issued By");
		lblIssuedBy.setBounds(10, 263, 103, 13);
		add(lblIssuedBy);
		
		borrowerNumber = new JTextField();
		borrowerNumber.setBounds(124, 33, 96, 19);
		add(borrowerNumber);
		borrowerNumber.setColumns(10);
		
		bookId = new JTextField();
		bookId.setBounds(124, 69, 96, 19);
		add(bookId);
		bookId.setColumns(10);
		
		borrowedFrom = new JTextField();
		borrowedFrom.setBounds(124, 114, 96, 19);
		add(borrowedFrom);
		borrowedFrom.setColumns(10);
		
		borrowedTo = new JTextField();
		borrowedTo.setBounds(124, 162, 96, 19);
		add(borrowedTo);
		borrowedTo.setColumns(10);
		
		issuedBy = new JTextField();
		issuedBy.setBounds(124, 260, 96, 19);
		add(issuedBy);
		issuedBy.setColumns(10);
		
		btnAddButton = new JButton("Add");
		btnAddButton.setBounds(77, 362, 85, 21);
		add(btnAddButton);
		
		btnUpdateButton = new JButton("Update");
		btnUpdateButton.setBounds(379, 362, 85, 21);
		add(btnUpdateButton);
		
		btnDeleteButton = new JButton("Delete");
		btnDeleteButton.setBounds(230, 362, 85, 21);
		add(btnDeleteButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 36, 349, 294);
		add(scrollPane);

		String col[] = {"Borrower Number","Book Id", "Borrowed From", "Borrowed To", "Return Date", "Issued By"
		};
		
	    borrowerTable = new JTable();
		scrollPane.setViewportView(borrowerTable);
		borrowerModel = new DefaultTableModel();
		borrowerTable.setModel(borrowerModel);
		borrowerModel.setColumnIdentifiers(col);
		
		
		btnAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int BorrowerNumber = Integer.valueOf(borrowerNumber.getText());
				int BookId = Integer.valueOf(bookId.getText());
				Date BorrowedFrom = Date.valueOf(borrowedFrom.getText());
				Date BorrowedTo = Date.valueOf(borrowedTo.getText());
				int IssuedBy = Integer.valueOf(issuedBy.getText());
				Connection myConn = null;
				String createBorrower = "{call createBorrower(?,?,?,?,?,?)}";
				CallableStatement myStmt = null;
			try {
				// Connect to database
            	myConn = MyConnection.connect();
                // Prepare the stored procedure call
                myStmt = myConn.prepareCall(createBorrower);
                // Set parameter
                myStmt.setInt(1,BorrowerNumber);
                myStmt.setInt(2,BookId);
                myStmt.setDate(3,BorrowedFrom);
                myStmt.setDate(4,BorrowedTo);
                myStmt.setInt(5,IssuedBy);
                myStmt.registerOutParameter(6,Types.INTEGER);
                myStmt.execute();
               int status = myStmt.getInt(6);
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
							String BorrowerNum = String.valueOf(rs.getInt("Borrower_Num"));
							String BookId = String.valueOf(rs.getInt("Book_Id"));
							String BorrowedFrom = String.valueOf(rs.getDate("Borrowed_from"));
							String BorrowedTo = String.valueOf(rs.getDate("Borrowed_to"));
							String ReturnedDate = String.valueOf(rs.getDate("Returned_date"));
							String IssuedBy = String.valueOf(rs.getInt("Issued_by"));
						
							
							String tbData[] = {BorrowerNum,BookId,BorrowedFrom,BorrowedTo,ReturnedDate,IssuedBy};
							DefaultTableModel tblModel = (DefaultTableModel)borrowerTable.getModel();
							tblModel.addRow(tbData);
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
