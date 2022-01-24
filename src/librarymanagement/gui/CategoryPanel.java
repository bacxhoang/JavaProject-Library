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
import librarymanagement.resource.Author;
import librarymanagement.resource.Category;

public class CategoryPanel extends JPanel {

		/**
		 * Create the panel.
		 */
		public CategoryPanel() {
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Category Id");
			lblNewLabel.setBounds(10, 36, 89, 13);
			add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Category Name");
			lblNewLabel_1.setBounds(10, 72, 89, 13);
			add(lblNewLabel_1);
			
			JTextField categoryIdTF = new JTextField();
			categoryIdTF.setBounds(109, 33, 96, 19);
			add(categoryIdTF);
			categoryIdTF.setColumns(10);
			
			JTextField categoryNameTF = new JTextField();
			categoryNameTF.setBounds(109, 69, 96, 19);
			add(categoryNameTF);
			categoryNameTF.setColumns(10);
			
			JButton btnAddButton = new JButton("Add");
			btnAddButton.setBounds(77, 362, 85, 21);
			add(btnAddButton);
			
			JButton btnUpdateButton = new JButton("Update");
			btnUpdateButton.setBounds(379, 362, 85, 21);
			add(btnUpdateButton);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(244, 36, 349, 294);
			add(scrollPane);
			String col[] = {"Category Id", "Category Name"
			};
			
			JTable categoryTable = new JTable();
			scrollPane.setViewportView(categoryTable);
			DefaultTableModel categoryModel = new DefaultTableModel();
			categoryModel.setColumnIdentifiers(col);
			categoryTable.setModel(categoryModel);
			
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
								Category newCategory = new Category();
								int categoryId = newCategory.getCategoryId(rs.getInt(2));
								String categoryName = newCategory.getCategoryName(rs.getString(3));
								categoryModel.addRow(new Object[] {categoryId, categoryName});
							}
							
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
	}
}
