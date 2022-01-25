package librarymanagement.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import librarymanagement.database.*;
import librarymanagement.resource.Borrower;

//Borrower GUI
public class BorrowerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblBorrowerNumber;
	private JLabel lblBookId;
	private JLabel lblBorrowedFrom;
	private JLabel lblBorrowedTo;
	private JLabel lblIssuedBy;
	private JLabel lblReturnDate;
	private JTextField borrowerNumber;
	private JTextField bookId;
	private JTextField borrowedFrom;
	private JTextField borrowedTo;
	private JTextField issuedBy;
	private JTextField returnedDate;
	private JButton btnAddButton;
	private JButton btnUpdateButton;
	private JButton btnDeleteButton;
	private JButton btnReturnButton;
	private JScrollPane scrollPane;
	private JTable borrowerTable;
	private DefaultTableModel borrowerModel;
	
	
	
	public BorrowerPanel() {
		setLayout(null);
		
		lblBorrowerNumber = new JLabel("Borrower Number");
		lblBorrowerNumber.setBounds(10, 40, 103, 13);
		add(lblBorrowerNumber);
		
		lblBookId = new JLabel("Book Id");
		lblBookId.setBounds(10, 80, 45, 13);
		add(lblBookId);
		
		lblBorrowedFrom = new JLabel("Borrowed From");
		lblBorrowedFrom.setBounds(10, 120, 103, 13);
		add(lblBorrowedFrom);
		
		lblBorrowedTo = new JLabel("Borrowed To");
		lblBorrowedTo.setBounds(10, 160, 89, 13);
		add(lblBorrowedTo);
		
		lblIssuedBy = new JLabel("Issued By");
		lblIssuedBy.setBounds(10, 200, 103, 13);
		add(lblIssuedBy);
		
		borrowerNumber = new JTextField();
		borrowerNumber.setBounds(124, 35, 96, 19);
		add(borrowerNumber);
		borrowerNumber.setColumns(10);
	
		bookId = new JTextField();
		bookId.setBounds(124, 75, 96, 19);
		add(bookId);
		bookId.setColumns(10);
		
		borrowedFrom = new JTextField();
		borrowedFrom.setBounds(124, 115, 96, 19);
		add(borrowedFrom);
		borrowedFrom.setColumns(10);
		
		borrowedTo = new JTextField();
		borrowedTo.setBounds(124, 155, 96, 19);
		add(borrowedTo);
		borrowedTo.setColumns(10);
		
		issuedBy = new JTextField();
		issuedBy.setBounds(124, 195, 96, 19);
		add(issuedBy);
		issuedBy.setColumns(10);
		
	    returnedDate = new JTextField();
	    returnedDate.setColumns(10);
	    returnedDate.setBounds(124, 287, 96, 19);
		add(returnedDate);
		
		btnAddButton = new JButton("Add");
		btnAddButton.setBounds(65, 362, 85, 21);
		add(btnAddButton);
		
		btnUpdateButton = new JButton("Update");
		btnUpdateButton.setBounds(508, 362, 85, 21);
		add(btnUpdateButton);
		
		btnDeleteButton = new JButton("Delete");
		btnDeleteButton.setBounds(290, 362, 85, 21);
		add(btnDeleteButton);
		
		btnReturnButton = new JButton("Return");
		btnReturnButton.setBounds(65, 317, 85, 21);
	    add(btnReturnButton);
	
		
		lblReturnDate = new JLabel("Returned Date");
		lblReturnDate.setBounds(10, 291, 103, 13);
		add(lblReturnDate);


		scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 36, 349, 294);
		add(scrollPane);

		String col[] = {"Borrower Number","Book Id", "Borrowed From", "Borrowed To", "Return Date", "Issued By"
		};
		
	    borrowerTable = new JTable();
		scrollPane.setViewportView(borrowerTable);
		borrowerModel = new DefaultTableModel(){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		borrowerTable.setModel(borrowerModel);
		
				
		
		borrowerModel.setColumnIdentifiers(col);
		
		// function for Add Button
		btnAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Borrower borrower = new Borrower(0, 0, null, null, null, 0);
				borrower.setBorrowerNum(Integer.valueOf(borrowerNumber.getText()));
				borrower.setBorrowerbookId(Integer.valueOf(bookId.getText()));
				borrower.setBorrowedFrom(Date.valueOf(borrowedFrom.getText()));
				borrower.setBorrowedTo(Date.valueOf(borrowedTo.getText()));
				borrower.setIssuedBy(Integer.valueOf(issuedBy.getText()));
				Connection myConn = null;
				String createBorrower = "{call createBorrower(?,?,?,?,?,?)}";
				CallableStatement myStmt = null;
			try {
				// Connect to database
            	myConn = MyConnection.connect();
                // Prepare the stored procedure call
                myStmt = myConn.prepareCall(createBorrower);
                // Set parameter
                myStmt.setInt(1,borrower.getBorrowerNum());
                myStmt.setInt(2,borrower.getBorrowerbookId());
                myStmt.setDate(3,borrower.getBorrowedFrom());
                myStmt.setDate(4,borrower.getBorrowedTo());
                myStmt.setInt(5,borrower.getIssuedBy());
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
		
		//function for Update Button
		btnUpdateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Connection myConn = null;
				String getBorrower = "{call getBorrower(?)}";
				CallableStatement myStmt = null;
				try {
					borrowerModel.setRowCount(0);
					// Connect to database
	            	myConn = MyConnection.connect();
	                // Prepare the stored procedure call
	                myStmt = myConn.prepareCall(getBorrower);
	                // Set Parameter
	                myStmt.registerOutParameter(1,Types.INTEGER);
	            	//Executing query
	                ResultSet rs = myStmt.executeQuery();
	                int status = myStmt.getInt(1);
			

                    //Setting up table auto-resizable.
	                borrowerTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					borrowerTable.setFillsViewportHeight(true);
					borrowerTable.setFocusable(false);
					if(status != 200) {
						throw new SQLCustomException(status);
						}
					else{
						while(rs.next()) {
					
						String BorrowerNum = String.valueOf(rs.getInt("Borrower_Id"));
						String BookId = String.valueOf(rs.getInt("ISBN"));
						String BorrowedFrom = String.valueOf(rs.getDate("Borrowed_from"));
						String BorrowedTo = String.valueOf(rs.getDate("Borrowed_to"));
						String ReturnedDate = String.valueOf(rs.getDate("Returned_date"));
						String IssuedBy = String.valueOf(rs.getInt("Staff_Id"));
					
						
						String tbData[] = {BorrowerNum,BookId,BorrowedFrom,BorrowedTo,ReturnedDate,IssuedBy};
						DefaultTableModel tblModel = (DefaultTableModel)borrowerTable.getModel();
						tblModel.addRow(tbData);
					}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		//function for Delete Button
		btnDeleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Borrower borrower = new Borrower(0, 0, null, null, null, 0);
				borrower.setBorrowerNum(Integer.valueOf(borrowerNumber.getText()));
				borrower.setBorrowerbookId(Integer.valueOf(bookId.getText()));
				Connection myConn = null;
				String deleteBorrower = "{call deleteBorrower(?,?,?)}";
				CallableStatement myStmt = null;
				try {
					// Connect to database
	            	myConn = MyConnection.connect();
	                // Prepare the stored procedure call
	                myStmt = myConn.prepareCall(deleteBorrower);
	                // Set parameter
	                myStmt.setInt(1,borrower.getBorrowerNum());
	                myStmt.setInt(2,borrower.getBorrowerbookId());
	                myStmt.registerOutParameter(3,Types.INTEGER);
	                myStmt.execute();
	               int status = myStmt.getInt(3);
	             if (status != 200) {
	                 throw new SQLCustomException(status);
	               }
	             else {
	            	 JOptionPane.showMessageDialog(btnDeleteButton, "Deleted Successfully ");
					
				}
				 } catch (SQLException ex) {
	            	 JOptionPane.showMessageDialog(btnDeleteButton, "Error: "+ex.toString());
	               
				}
				
				
				
			}
			
		});
		// function for Return Button
		btnReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Borrower borrower = new Borrower(0, 0, null, null, null, 0);
				borrower.setBorrowerNum(Integer.valueOf(borrowerNumber.getText()));
				borrower.setBorrowerbookId(Integer.valueOf(bookId.getText()));
				borrower.setReturnedDate(Date.valueOf(returnedDate.getText()));
				
				Connection myConn = null;
				String setReturnedDate = "{call setReturnedDate(?,?,?,?)}";
				CallableStatement myStmt = null;
				
				try {
					// Connect to database
	            	myConn = MyConnection.connect();
	                // Prepare the stored procedure call
	                myStmt = myConn.prepareCall(setReturnedDate);
	                // Set parameter
	                myStmt.setInt(1,borrower.getBorrowerNum());
	                myStmt.setInt(2,borrower.getBorrowerbookId());
	                myStmt.setDate(3,borrower.getReturnedDate());
	                myStmt.registerOutParameter(4,Types.INTEGER);
	                myStmt.execute();
	                int status = myStmt.getInt(4);
	                
	                if (status != 200) {
		                 throw new SQLCustomException(status);
		               }
		             else {
		            	 JOptionPane.showMessageDialog(btnReturnButton, "Returned Successfully ");
						
					}
					 } catch (SQLException ex) {
		            	 JOptionPane.showMessageDialog(btnReturnButton, "Error: "+ex.toString());
		               
					}
					
					
					
				}
			
		});
		// auto-fill the textField whenever you click on a table row
		borrowerTable.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseClicked(MouseEvent evt) {
				int selectedRowIndex = borrowerTable.getSelectedRow();
				
				borrowerNumber.setText(borrowerModel.getValueAt(selectedRowIndex, 0).toString());
				bookId.setText(borrowerModel.getValueAt(selectedRowIndex, 1).toString());
				borrowedFrom.setText(borrowerModel.getValueAt(selectedRowIndex, 2).toString());
				borrowedTo.setText(borrowerModel.getValueAt(selectedRowIndex, 3).toString());
				returnedDate.setText(borrowerModel.getValueAt(selectedRowIndex, 4).toString());
				issuedBy.setText(borrowerModel.getValueAt(selectedRowIndex, 5).toString());
			}
		});
	}
}
