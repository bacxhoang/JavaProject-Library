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
import librarymanagement.resource.Author;
// Author GUI
public class AuthorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

		authorModel = new DefaultTableModel(){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		authorModel.setColumnIdentifiers(col);
		authorTable.setModel(authorModel);


		// fuction for Add Button
		btnAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Author author = new Author(0, null);
				author.setAuthorId(Integer.valueOf(authorId.getText()));
				author.setAuthorName(authorName.getText());
				Connection myConn = null;
				String createAuthor = "{call createAuthor(?,?,?)}";
				CallableStatement myStmt = null;
			try {
				// Connect to database
            	myConn = MyConnection.connect();
                // Prepare the stored procedure call
                myStmt = myConn.prepareCall(createAuthor);
                // Set parameter
                myStmt.setInt(1,author.getAuthorId());
                myStmt.setString(2,author.getAuthorName());
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
		
		//function for Update Button
		btnUpdateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Connection myConn = null;
				String getAuthor = "{call getAuthor(?)}";
				CallableStatement myStmt = null;
				try {
					authorModel.setRowCount(0);
					// Connect to database
	            	myConn = MyConnection.connect();
	                // Prepare the stored procedure call
	                myStmt = myConn.prepareCall(getAuthor);
	                // Set Parameter
	                myStmt.registerOutParameter(1,Types.INTEGER);
	            	//Executing query
	                ResultSet rs = myStmt.executeQuery();
	                int status = myStmt.getInt(1);
			

                    //Setting up table auto-resizable.
	                authorTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					authorTable.setFillsViewportHeight(true);
					authorTable.setFocusable(false);
					if(status != 200) {
						throw new SQLCustomException(status);
						}
					else{
						while(rs.next()) {
					
						String AuthorId = String.valueOf(rs.getInt("Author_Id"));
						String AuthorName = rs.getString("Author_Name");;
					
						
						String tbData[] = {AuthorId,AuthorName};
						DefaultTableModel tblModel = (DefaultTableModel)authorTable.getModel();
						tblModel.addRow(tbData);
					}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		// auto-fill the textField whenever you click on a table row
		authorTable.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent evt) {
				int selectedRowIndex = authorTable.getSelectedRow();
				
				authorId.setText(authorModel.getValueAt(selectedRowIndex, 0).toString());
				authorName.setText(authorModel.getValueAt(selectedRowIndex, 1).toString());
			}
		});
	}

}
