package librarymanagement.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
import librarymanagement.resource.Category;
import librarymanagement.resource.Student;

public class StudentPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StudentPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setBounds(10, 36, 89, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setBounds(10, 72, 89, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Borrower Id");
		lblNewLabel_2.setBounds(10, 117, 103, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBounds(10, 165, 89, 13);
		add(lblNewLabel_3);
		
		
		JTextField studentIdTF = new JTextField();
		studentIdTF.setBounds(109, 33, 96, 19);
		add(studentIdTF);
		studentIdTF.setColumns(10);
		
		JTextField studentNameTF = new JTextField();
		studentNameTF.setBounds(109, 69, 96, 19);
		add(studentNameTF);
		studentNameTF.setColumns(10);
		
		JTextField borrowerNumberTF = new JTextField();
		borrowerNumberTF.setBounds(109, 114, 96, 19);
		add(borrowerNumberTF);
		borrowerNumberTF.setColumns(10);
		
		JTextField phoneNumTF = new JTextField();
		phoneNumTF.setBounds(109, 162, 96, 19);
		add(phoneNumTF);
		phoneNumTF.setColumns(10);
		
		
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
		String col[] = {"Student Id", "Student Name", "Borrower Id", "Phone Number"
		};
		
		JTable studentTable = new JTable();
		scrollPane.setViewportView(studentTable);
		DefaultTableModel studentModel = new DefaultTableModel();
		studentModel.setColumnIdentifiers(col);
		studentTable.setModel(studentModel);
		
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
							Student newStudent = new Student();
							int studentId = newStudent.getStudentId(rs.getInt(2));
							String studentName = newStudent.getStudentName(rs.getString(3));
							int borrowerId = newStudent.getBorrowerId(rs.getInt(4));
							int phoneNumber = newStudent.getPhoneNumber(rs.getInt(5));
							studentModel.addRow(new Object[] {studentId, studentName, borrowerId, phoneNumber});
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
