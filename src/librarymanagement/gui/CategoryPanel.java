package librarymanagement.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
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


import librarymanagement.database.MyConnection;
import librarymanagement.database.SQLCustomException;
import librarymanagement.resource.Category;

//Category GUI
public class CategoryPanel extends JPanel {
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
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
			categoryModel = new DefaultTableModel(){
			    /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			};
			categoryModel.setColumnIdentifiers(col);
			categoryTable.setModel(categoryModel);
			
			//function for Add Button
			btnAddButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						Category category = new Category(0, null);
						category.setCategoryId(Integer.valueOf(categoryId.getText()));
						category.setCategoryName(categoryName.getText());
						Connection myConn = null;
						String createCategory = "{call createCategory(?,?,?)}";
						CallableStatement myStmt = null;
					try {
						// Connect to database
	                	myConn = MyConnection.connect();
	                    // Prepare the stored procedure call
	                    myStmt = myConn.prepareCall(createCategory);
	                    // Set parameter
	                    myStmt.setInt(1,category.getCategoryId());
	                    myStmt.setString(2,category.getCategoryName());
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
			
			//function for Update Button
			btnUpdateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Connection myConn = null;
					String getCategory = "{call getCategory(?)}";
					CallableStatement myStmt = null;
					try {
						categoryModel.setRowCount(0);
						// Connect to database
	                	myConn = MyConnection.connect();
	                    // Prepare the stored procedure call
	                    myStmt = myConn.prepareCall(getCategory);
	                    // Set parameter
	            
	                    myStmt.registerOutParameter(1,Types.INTEGER);
	                    ResultSet rs = myStmt.executeQuery();
	                   int status = myStmt.getInt(1);

						

	                    //Setting up table auto-resizable.
						categoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						categoryTable.setFillsViewportHeight(true);
						categoryTable.setFocusable(false);
						if(status != 200) {
							throw new SQLCustomException(status);
						}
						else {
							while(rs.next()) {
								String CategoryId = String.valueOf(rs.getInt("Cat_Id"));
								String CategoryName = rs.getString("Cat_Name");
								String tbData[] = {CategoryId,CategoryName};
								DefaultTableModel tblModel = (DefaultTableModel)categoryTable.getModel();
								tblModel.addRow(tbData);
							}
						}
							
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			// auto-fill the textField whenever you click on a table row
			categoryTable.addMouseListener(new MouseAdapter() {
		
				@Override
				public void mouseClicked(MouseEvent evt) {
					int selectedRowIndex = categoryTable.getSelectedRow();
					
					categoryId.setText(categoryModel.getValueAt(selectedRowIndex, 0).toString());
					categoryName.setText(categoryModel.getValueAt(selectedRowIndex, 1).toString());
				}
			});
	}
}
