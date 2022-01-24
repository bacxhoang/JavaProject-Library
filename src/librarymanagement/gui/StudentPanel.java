package librarymanagement.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
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
import librarymanagement.resource.Student;

public class StudentPanel extends JPanel {
	private JLabel lblStudentId;
	private JLabel lblStudentName;
	private JLabel lblBorrowerId;
	private JLabel lblPhoneNumber;
	private JTextField studentId;
	private JTextField studentName;
	private JTextField borrowerId;
	private JTextField phoneNumber;
	private JButton btnAddButton;
	private JButton btnUpdateButton;
	private JButton btnDeleteButton;
	private JScrollPane scrollPane;
	private JTable studentTable;
	private DefaultTableModel studentModel;

	public StudentPanel() {
		setLayout(null);
		
		lblStudentId = new JLabel("Student Id");
		lblStudentId.setBounds(10, 36, 89, 13);
		add(lblStudentId);
		
		lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(10, 72, 89, 13);
		add(lblStudentName);
		
		lblBorrowerId = new JLabel("Borrower Id");
		lblBorrowerId.setBounds(10, 117, 103, 13);
		add(lblBorrowerId);
		
		 lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(10, 165, 89, 13);
		add(lblPhoneNumber);
		
		
		 studentId = new JTextField();
		studentId.setBounds(109, 33, 96, 19);
		add(studentId);
		studentId.setColumns(10);
		
		studentName = new JTextField();
		studentName.setBounds(109, 69, 96, 19);
		add(studentName);
		studentName.setColumns(10);
		
		borrowerId = new JTextField();
		borrowerId.setBounds(109, 114, 96, 19);
		add(borrowerId);
		borrowerId.setColumns(10);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(109, 162, 96, 19);
		add(phoneNumber);
		phoneNumber.setColumns(10);
		
		
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
		String col[] = {"Student Id", "Student Name", "Borrower Id", "Phone Number"
		};
		
		studentTable = new JTable();
		scrollPane.setViewportView(studentTable);
		studentModel = new DefaultTableModel();
		studentModel.setColumnIdentifiers(col);
		studentTable.setModel(studentModel);
		
		btnAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int StudentId = Integer.valueOf(studentId.getText());
				String StudentName = studentName.getText();
				int BorrowerId = Integer.valueOf(borrowerId.getText());
				int PhoneNumber = Integer.valueOf(phoneNumber.getText());
				Connection myConn = null;
				String createStudent = "{call createStudent(?,?,?,?,?)}";
				CallableStatement myStmt = null;
			try {
				// Connect to database
            	myConn = MyConnection.connect();
                // Prepare the stored procedure call
                myStmt = myConn.prepareCall(createStudent);
                // Set parameter
                myStmt.setInt(1,StudentId);
                myStmt.setString(2,StudentName);
                myStmt.setInt(3,BorrowerId);
                myStmt.setInt(4,PhoneNumber);
                myStmt.registerOutParameter(5,Types.INTEGER);
                myStmt.execute();
               int status = myStmt.getInt(5);
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
					studentModel.setRowCount(0);
					Connection connect = MyConnection.connect();
					String sql = "SELECT * FROM STUDENT"; 
					//Create connection to Database

					Statement stmt =  connect.createStatement(); 

				//Executing query

					ResultSet rs = stmt.executeQuery(sql);
                    

                    //Setting up table auto-resizable.
					studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					studentTable.setFillsViewportHeight(true);
					studentTable.setFocusable(false);
						while(rs.next()) {
							String StudentId = String.valueOf(rs.getInt("Student_Id"));
							String StudentName = rs.getString("Student_Name");
							String BorrowerId = String.valueOf(rs.getInt("Borrower_Id"));
							String PhoneNumber = String.valueOf(rs.getInt("Phone_Number"));
							
							
							
							String tbData[] = {StudentId,StudentName,BorrowerId,PhoneNumber};
							DefaultTableModel tblModel = (DefaultTableModel)studentTable.getModel();
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
