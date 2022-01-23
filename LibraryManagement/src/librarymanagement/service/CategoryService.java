package librarymanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import librarymanagement.database.MyConnection;
import librarymanagement.resource.Category;

public class CategoryService {
	private Connection connection;
	private ArrayList<Category> AL;
	private ArrayList<String> CategoryIdAL;
	
	
	public CategoryService()
	{
		Connection connection = MyConnection.getConnection();
	}
	
	void addCategory(Category category) throws ClassNotFoundException, SQLException {
		try {
			String sql = "INSERT INTO CATEGORY VALUES(?,?)";
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
			pstm.setInt(1, category.getCategoryId());
			pstm.setString(2, category.getCategoryName());
			pstm.executeUpdate();
		} catch (SQLException e) {
	         e.printStackTrace();
	      }
	}
	
	void deleteCategory(Category category) throws ClassNotFoundException, SQLException{
		try {
			String sql = "DELETE FROM CATEGORY WHERE Cat_id = ?";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, category.getCategoryId());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
	}
	
	public ArrayList<Object> getCategoryInfo(Category category) {
		ArrayList<Object> categoryInfo = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM CATEGORY";
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery(sql);
			while(rs.next()) {
				categoryInfo.add(rs.getInt("Cat_Id"));
				categoryInfo.add(rs.getString("Cat_Name"));
			}
			
	} catch (SQLException e) {
        e.printStackTrace();
     }
		return categoryInfo;
	}
}
