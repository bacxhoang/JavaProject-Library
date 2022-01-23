package librarymanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import librarymanagement.database.MyConnection;
import librarymanagement.resource.Author;

public class AuthorService {
	private Connection connection;
	public AuthorService()
	{
		Connection connection = MyConnection.getConnection();
	}
	void addAuthor(Author author) throws ClassNotFoundException, SQLException {
		try {
			String sql = "INSERT INTO AUTHOR VALUES(?,?)";
			PreparedStatement pstm = connection.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery(sql);

			int i = 1;
			while (rs.next()) {
				if (i != rs.getInt(1)) {
					break;
				}
				i++;
			}
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, author.getAuthorId());
			pstm.setString(2, author.getAuthorName());
		} catch (SQLException e) {
	         e.printStackTrace();
	      }		
	}
	
	void deleteAuthor(Author author) throws ClassNotFoundException, SQLException{
		try {
			String sql = "DELETE FROM AUTHOR WHERE Author_ID= ?";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, author.getAuthorId());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
	}
	
	public ArrayList<Object> getAuthorInfo(Author author) {
		ArrayList<Object> authorInfo = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM AUTHOR";
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery(sql);
			while(rs.next()) {
				authorInfo.add(rs.getInt("Author_Id"));
				authorInfo.add(rs.getString("Author_Name"));
			}
			
	} catch (SQLException e) {
        e.printStackTrace();
     }
		return authorInfo;
	}
}

