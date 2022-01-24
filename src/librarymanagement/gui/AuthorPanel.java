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
import librarymanagement.resource.Book;

public class AuthorPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AuthorPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("AuthorId");
		lblNewLabel.setBounds(10, 36, 89, 13);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Author Name");
		lblNewLabel_1.setBounds(10, 72, 89, 13);
		add(lblNewLabel_1);

		JTextField authorIdTF = new JTextField();
		authorIdTF.setBounds(109, 33, 96, 19);
		add(authorIdTF);
		authorIdTF.setColumns(10);

		JTextField authorNameTF = new JTextField();
		authorNameTF.setBounds(109, 69, 96, 19);
		add(authorNameTF);
		authorNameTF.setColumns(10);

		JButton btnAddButton = new JButton("Add");
		btnAddButton.setBounds(77, 362, 85, 21);
		add(btnAddButton);

		JButton btnUpdateButton = new JButton("Update");
		btnUpdateButton.setBounds(379, 362, 85, 21);
		add(btnUpdateButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 36, 306, 290);
		add(scrollPane);
		
		JTable authorTable = new JTable();
		scrollPane.setViewportView(authorTable);
		
		String[] col = { "AuthorId", "Author Name" };

		DefaultTableModel authorModel = new DefaultTableModel();
		authorModel.setColumnIdentifiers(col);
		authorTable.setModel(authorModel);


		
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
							Author newAuthor = new Author();
							int authorId = newAuthor.getAuthorId(rs.getInt(2));
							String authorName = newAuthor.getAuthorName(rs.getString(3));
							authorModel.addRow(new Object[] {authorId, authorName});
						}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}

}
