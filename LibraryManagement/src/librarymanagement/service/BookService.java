package librarymanagement.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import librarymanagement.resource.*;

import librarymanagement.database.*;
public class BookService {
	private Connection connection;
	
	public BookService()
	{
		Connection connection = MyConnection.getConnection();
	}
	
	public void addBook(Book book) {
		ArrayList<Book> bookInfoAdd;
		try {
			String sql = "INSERT TO BOOK VALUES(?,?,?,?,?,?,?)";
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
	      }
	}

	
	public ArrayList<Book> getBookInfo() throws SQLException {
		ArrayList<Book> bookInfo = new ArrayList<>();
	 
		try {
			String sql = "SELECT * FROM BOOK";
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery(sql);
			while(rs.next()) {
				int isbn = rs.getInt("ISBN");
				String title = rs.getString("Title");
				String language = rs.getString("Book_Language");
				int authorId = rs.getInt("Author_Name");
				int categoryId = rs.getInt("Cat_Name");
				int noCopyActual = rs.getInt("No_Copy_Actual");
				int noCopyCurrent = rs.getInt("No_Copy_Current");
				
				Book newBook = new Book(isbn, title, language, authorId, categoryId, noCopyActual, noCopyCurrent);
				bookInfo.add(newBook);
			}
	} catch (SQLException e) {
        e.printStackTrace();
     }
		return bookInfo;
	}
}