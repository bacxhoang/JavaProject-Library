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

import librarymanagement.api.LaunchPage;
import librarymanagement.database.MyConnection;
import librarymanagement.database.SQLCustomException;
import librarymanagement.resource.Author;
import librarymanagement.resource.Category;

public class CategoryPanel extends JPanel {
		private JLabel lblCategoryId;
		private JLabel lblCategoryName;
		private JTextField categoryId;
		private JTextField categoryName;
		private JButton btnAddButton;
		private JButton btnUpdateButton;
		private JScrollPane scrollPane;
		private JTable categoryTable;
		private DefaultTableModel categoryModel;
		
		public CategoryPanel() {
			setLayout(null);
			
			lblCategoryId = new JLabel("Category Id");
			lblCategoryId.setBounds(10, 36, 89, 13);
			add(lblCategoryId);
			
			lblCategoryName = new JLabel("Category Name");
			lblCategoryName.setBounds(10, 72, 89, 13);
			add(lblCategoryName);
			
			categoryId = new JTextField();
			categoryId.setBounds(109, 33, 96, 19);
			add(categoryId);
			categoryId.setColumns(10);
			
			categoryName = new JTextField();
			categoryName.setBounds(109, 69, 96, 19);
			add(categoryName);
			categoryName.setColumns(10);
			
			btnAddButton = new JButton("Add");
			btnAddButton.setBounds(77, 362, 85, 21);
			add(btnAddButton);
			
			btnUpdateButton = new JButton("Update");
			btnUpdateButton.setBounds(379, 362, 85, 21);
			add(btnUpdateButton);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(244, 36, 349, 294);
			add(scrollPane);
			String col[] = {"Category Id", "Category Name"
			};
			
			categoryTable = new JTable();
			scrollPane.setViewportView(categoryTable);
			categoryModel = new DefaultTableModel();
			categoryModel.setColumnIdentifiers(col);
			categoryTable.setModel(categoryModel);
			
			btnAddButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						int CategoryID = Integer.valueOf(categoryId.getText());
						String CategoryName = categoryName.getText();
						Connection myConn = null;
						String createCategory = "{call createCategory(?,?,?)}";
						CallableStatement myStmt = null;
					try {
						// Connect to database
	                	myConn = MyConnection.connect();
	                    // Prepare the stored procedure call
	                    myStmt = myConn.prepareCall(createCategory);
	                    // Set parameter
	                    myStmt.setInt(1,CategoryID);
	                    myStmt.setString(2,CategoryName);
	                    myStmt.registerOutParameter(3,Types.INTEGER);
	                    myStmt.execute();
	                   int status = myStmt.getInt(3);
	                 if (status != 200) {
	                     throw new SQLCustomException(status);
	                   }
	                 else {
	                	 JOptionPane.showMessageDialog(btnAddButton, "Added Successfully");
						
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
						categoryModel.setRowCount(0);
						Connection connect = MyConnection.connect();
						String sql = "SELECT * FROM CATEGORY"; 
						//Create connection to Database

						Statement stmt =  connect.createStatement(); 

					//Executing query

						ResultSet rs = stmt.executeQuery(sql);
	                    

	                    //Setting up table auto-resizable.
						categoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						categoryTable.setFillsViewportHeight(true);
						categoryTable.setFocusable(false);
							while(rs.next()) {
								String CategoryId = String.valueOf(rs.getInt("Cat_Id"));
								String CategoryName = rs.getString("Cat_Name");
								String tbData[] = {CategoryId,CategoryName};
								DefaultTableModel tblModel = (DefaultTableModel)categoryTable.getModel();
								tblModel.addRow(tbData);
							}
							
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
	}
}
