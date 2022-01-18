package librarymanagement.service;

import java.sql.*;
import java.sql.PreparedStatement;
import librarymanagement.database.MySQLConnUtils;
import librarymanagement.resource.*;

public class BookService {

	public void addBook(Book book) throws ClassNotFoundException, SQLException {
		Connection db = MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "INSERT INTO BOOK VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstm = db.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery(sql);

			int i = 1;
			while (rs.next()) {
				if (i != rs.getInt(1)) {
					break;
				}
				i++;
			}
			pstm = db.prepareStatement(sql);
			pstm.setInt(1, book.getIsbn());
			pstm.setString(2, book.getTitle());
			pstm.setString(3, book.getLanguage());
			pstm.setInt(4, book.getAuthorId());
			pstm.setInt(5, book.getCategoryId());
			pstm.setInt(6, book.getNoCopyActual());
			pstm.setInt(7, book.getNoCopyCurrent());
			pstm.executeUpdate();
		} catch (SQLException e) {
	         e.printStackTrace();
	      } 		finally {
				db.close();			
			}
	}
	void deleteBook(Book book) throws ClassNotFoundException, SQLException{
		Connection db= MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "DELETE FROM BOOK WHERE ISBN = ?";
			PreparedStatement pstm = db.prepareStatement(sql);
			pstm.setInt(1, book.getIsbn());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		finally {
			db.close();			
		}
	}
	
	void getBookInfo(Book book) {
		
	}
	
	void addAuthor(Author author) throws ClassNotFoundException, SQLException {
		Connection db = MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "INSERT INTO AUTHOR VALUES(?,?)";
			PreparedStatement pstm = db.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery(sql);

			int i = 1;
			while (rs.next()) {
				if (i != rs.getInt(1)) {
					break;
				}
				i++;
			}
			pstm = db.prepareStatement(sql);
			pstm.setInt(1, author.getAuthorId());
			pstm.setString(2, author.getAuthorName());
		} catch (SQLException e) {
	         e.printStackTrace();
	      } 		finally {
				db.close();			
			}
	}
	
	void deleteAuthor(Author author) throws ClassNotFoundException, SQLException{
		Connection db= MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "DELETE FROM AUTHOR WHERE Author_ID= ?";
			PreparedStatement pstm = db.prepareStatement(sql);
			pstm.setInt(1, author.getAuthorId());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		finally {
			db.close();			
		}
	}
	
	void getAuthorInfo(Author author) {
		
	}
	
	void addCategory(Category category) throws ClassNotFoundException, SQLException {
		Connection db = MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "INSERT INTO CATEGORY VALUES(?,?)";
			PreparedStatement pstm = db.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery(sql);

			int i = 1;
			while (rs.next()) {
				if (i != rs.getInt(1)) {
					break;
				}
				i++;
			}
			pstm = db.prepareStatement(sql);
			pstm.setInt(1, category.getCategoryId());
			pstm.setString(2, category.getCategoryName());
			pstm.executeUpdate();
		} catch (SQLException e) {
	         e.printStackTrace();
	      } 		finally {
				db.close();			
			}
	}
	
	void deleteCategory(Category category) throws ClassNotFoundException, SQLException{
		Connection db= MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "DELETE FROM CATEGORY WHERE Cat_id = ?";
			PreparedStatement pstm = db.prepareStatement(sql);
			pstm.setInt(1, category.getCategoryId());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		finally {
			db.close();			
		}
	}
	
	void getCategoryInfo(Category category) {
		
	}
}
