package librarymanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import librarymanagement.database.MyConnection;
import librarymanagement.resource.Borrower;

public class BorrowerService {
	private Connection connection;
	
	public BorrowerService()
	{
		Connection connection = MyConnection.getConnection();
	}
	void addBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		try {
			String sql = "INSERT INTO BORROWER VALUES(?,?,?,?,?,?)";
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
			pstm.setInt(1, borrower.getborrowerId());
			pstm.setInt(2, borrower.getBookId());
			pstm.setDate(3, borrower.getBorrowedFrom());
			pstm.setDate(4, borrower.getBorrowedTo());
			pstm.setDate(5, borrower.getReturnedDate());
			pstm.setInt(6, borrower.getIssuedBy());
			pstm.executeUpdate();
		} catch (SQLException e) {
	         e.printStackTrace();
	      }		
	}

	void deleteBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		try {
			String sql = "DELETE FROM BORROWER WHERE Borrower_Id = ?";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, borrower.getborrowerId());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		finally {
			connection.close();			
		}
	}
	
	public ArrayList<Object> getBorrowerInfo(Borrower borrower) {
		ArrayList<Object> BorrowerInfo = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM Borrower";
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery(sql);
			while(rs.next()) {
				BorrowerInfo.add(rs.getInt("Borrower_Id"));
				BorrowerInfo.add(rs.getString("Student_Name"));
				BorrowerInfo.add(rs.getInt("Title"));
				BorrowerInfo.add(rs.getInt("ISBN"));
				BorrowerInfo.add(rs.getString("Borrowed_from"));
				BorrowerInfo.add(rs.getInt("Borrowed_to"));
				BorrowerInfo.add(rs.getInt("Returned_date"));
				BorrowerInfo.add(rs.getInt("Issued_by"));
			}
			
	} catch (SQLException e) {
        e.printStackTrace();
     }
		return BorrowerInfo;
	}
}

