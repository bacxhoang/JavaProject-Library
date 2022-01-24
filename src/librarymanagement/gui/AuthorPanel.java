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

public class AuthorPanel extends JPanel {

	private JLabel lblAuthorId;
	private JLabel lblAuthorName;
	private JTextField authorId;
	private JTextField authorName;
	private JButton btnAddButton;
	private JButton btnUpdateButton;
	private JScrollPane scrollPane;
	private JTable authorTable;
	private DefaultTableModel authorModel;
	
	public AuthorPanel() {
		setLayout(null);

		lblAuthorId = new JLabel("AuthorId");
		lblAuthorId.setBounds(10, 36, 89, 13);
		add(lblAuthorId);

		lblAuthorName = new JLabel("Author Name");
		lblAuthorName.setBounds(10, 72, 89, 13);
		add(lblAuthorName);

		authorId = new JTextField();
		authorId.setBounds(109, 33, 96, 19);
		add(authorId);
		authorId.setColumns(10);

		authorName = new JTextField();
		authorName.setBounds(109, 69, 96, 19);
		add(authorName);
		authorName.setColumns(10);

		btnAddButton = new JButton("Add");
		btnAddButton.setBounds(77, 362, 85, 21);
		add(btnAddButton);

		btnUpdateButton = new JButton("Update");
		btnUpdateButton.setBounds(379, 362, 85, 21);
		add(btnUpdateButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 36, 306, 290);
		add(scrollPane);
		
		authorTable = new JTable();
		scrollPane.setViewportView(authorTable);
		
		String[] col = { "AuthorId", "Author Name" };

		authorModel = new DefaultTableModel();
		authorModel.setColumnIdentifiers(col);
		authorTable.setModel(authorModel);


		
		btnAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int AuthorID = Integer.valueOf(authorId.getText());
				String AuthorName = authorName.getText();
				Connection myConn = null;
				String createAuthor = "{call createAuthor(?,?,?)}";
				CallableStatement myStmt = null;
			try {
				// Connect to database
            	myConn = MyConnection.connect();
                // Prepare the stored procedure call
                myStmt = myConn.prepareCall(createAuthor);
                // Set parameter
                myStmt.setInt(1,AuthorID);
                myStmt.setString(2,AuthorName);
                myStmt.registerOutParameter(3,Types.INTEGER);
                myStmt.execute();
               int status = myStmt.getInt(3);
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
					authorModel.setRowCount(0);
					Connection connect = MyConnection.connect();
					String sql = "SELECT * FROM AUTHOR"; 
					//Create connection to Database

					Statement stmt =  connect.createStatement(); 

				//Executing query

					ResultSet rs = stmt.executeQuery(sql);
                    

                    //Setting up table auto-resizable.
					authorTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					authorTable.setFillsViewportHeight(true);
					authorTable.setFocusable(false);
						while(rs.next()) {
							String authorId = String.valueOf(rs.getInt("Author_Id"));
							String authorName = rs.getString("Author_Name");
							
							String tbData[] = {authorId,authorName};
							DefaultTableModel tblModel = (DefaultTableModel)authorTable.getModel();
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
