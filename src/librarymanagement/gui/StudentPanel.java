package librarymanagement.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import librarymanagement.database.MyConnection;
import librarymanagement.database.SQLCustomException;
import librarymanagement.resource.Student;

//Student GUI
public class StudentPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		studentModel = new DefaultTableModel(){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		studentModel.setColumnIdentifiers(col);
		studentTable.setModel(studentModel);
		
		//function for Add Button
		btnAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student student = new Student(0, null, 0, 0);
				student.setStudentId(Integer.valueOf(studentId.getText()));
				student.setStudentName(studentName.getText());
				student.setBorrowerId(Integer.valueOf(borrowerId.getText()));
				student.setPhoneNumber(Integer.valueOf(phoneNumber.getText()));
				Connection myConn = null;
				String createStudent = "{call createStudent(?,?,?,?,?)}";
				CallableStatement myStmt = null;
			try {
				// Connect to database
            	myConn = MyConnection.connect();
                // Prepare the stored procedure call
                myStmt = myConn.prepareCall(createStudent);
                // Set parameter
                myStmt.setInt(1,student.getStudentId());
                myStmt.setString(2,student.getStudentName());
                myStmt.setInt(3,student.getBorrowerId());
                myStmt.setInt(4,student.getPhoneNumber());
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
		
		//function for Update Button
		btnUpdateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					Connection myConn = null;
					String getStudent = "{call getStudent(?)}";
					CallableStatement myStmt = null;
					try {
						studentModel.setRowCount(0);
						// Connect to database
	                	myConn = MyConnection.connect();
	                    // Prepare the stored procedure call
	                    myStmt = myConn.prepareCall(getStudent);
	                    // Set parameter
	            
	                    myStmt.registerOutParameter(1,Types.INTEGER);
	                    ResultSet rs = myStmt.executeQuery();
	                    int status = myStmt.getInt(1);

						

	                    //Setting up table auto-resizable.
						studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						studentTable.setFillsViewportHeight(true);
						studentTable.setFocusable(false);
						if(status != 200) {
							throw new SQLCustomException(status);
						}
						else {
							while(rs.next()) {
								String StudentId = String.valueOf(rs.getInt("Student_Id"));
								String StudentName = rs.getString("Student_Name");
								String BorrowerId = String.valueOf(rs.getInt("Borrower_Id"));
								String PhoneNumber = String.valueOf(rs.getInt("Phone_Number"));
								String tbData[] = {StudentId,StudentName,BorrowerId,PhoneNumber};
								DefaultTableModel tblModel = (DefaultTableModel)studentTable.getModel();
								tblModel.addRow(tbData);
							}
						}
							
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			
		});
		//function for Delete Button
		btnDeleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student student = new Student(0, null, 0, 0);
				student.setStudentId(Integer.valueOf(studentId.getText()));
				Connection myConn = null;
				String deleteStudent = "{call deleteStudent(?,?)}";
				CallableStatement myStmt = null;
				try {
					// Connect to database
	            	myConn = MyConnection.connect();
	                // Prepare the stored procedure call
	                myStmt = myConn.prepareCall(deleteStudent);
	                // Set parameter
	                myStmt.setInt(1,student.getStudentId());
	                myStmt.registerOutParameter(2,Types.INTEGER);
	                myStmt.execute();
	               int status = myStmt.getInt(2);
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
		// auto-fill the textField whenever you click on a table row
		studentTable.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseClicked(MouseEvent evt) {
				int selectedRowIndex = studentTable.getSelectedRow();
				
				studentId.setText(studentModel.getValueAt(selectedRowIndex, 0).toString());
				studentName.setText(studentModel.getValueAt(selectedRowIndex, 1).toString());
				borrowerId.setText(studentModel.getValueAt(selectedRowIndex,2).toString());
				phoneNumber.setText(studentModel.getValueAt(selectedRowIndex,3).toString());
			}
		});
	}
}
