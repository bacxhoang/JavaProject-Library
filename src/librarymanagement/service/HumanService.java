package librarymanagement.service;

import java.sql.*;

import librarymanagement.database.*;

import librarymanagement.resource.*;

public class HumanService {
	
	void addBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		Connection db = MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "INSERT INTO BORROWER VALUES(?,?,?,?,?,?)";
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
			pstm.setInt(1, borrower.getborrowerId());
			pstm.setInt(2, borrower.getBookId());
			pstm.setDate(3, borrower.getBorrowedFrom());
			pstm.setDate(4, borrower.getBorrowedTo());
			pstm.setDate(5, borrower.getReturnedDate());
			pstm.setInt(6, borrower.getIssuedBy());
			pstm.executeUpdate();
		} catch (SQLException e) {
	         e.printStackTrace();
	      } 		finally {
				db.close();			
			}
	}

	void deleteBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		Connection db= MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "DELETE FROM BORROWER WHERE Borrower_Id = ?";
			PreparedStatement pstm = db.prepareStatement(sql);
			pstm.setInt(1, borrower.getborrowerId());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		finally {
			db.close();			
		}
	}
	
	void getBorrowerInfo(Borrower borrower) {
		
	}
	
	void addStudent(Student student) throws ClassNotFoundException, SQLException{
		Connection db = MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "INSERT INTO STUDENT VALUES(?,?,?,?)";
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
			pstm.setInt(1, student.getStudentId());
			pstm.setString(2, student.getStudentName());
			pstm.setInt(3, student.getBorrowerId());
			pstm.setInt(4, student.getPhoneNumber());
			pstm.executeUpdate();
		} catch (SQLException e) {
	         e.printStackTrace();
	      } 		finally {
				db.close();			
			}
	}
	
	void deleteStudent(Student student) throws ClassNotFoundException, SQLException{
		Connection db= MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "DELETE FROM STUDENT WHERE Student_Id = ?";
			PreparedStatement pstm = db.prepareStatement(sql);
			pstm.setInt(1, student.getStudentId());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		finally {
			db.close();			
		}
	}
	
	void getStudentInfo(Student student) {
		
	}
	
	void addStaff(Staff staff) throws ClassNotFoundException, SQLException{
		Connection db = MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "INSERT INTO STAFF VALUES(?,?,?)";
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
			pstm.setInt(1, staff.getStaffId());
			pstm.setString(2, staff.getUsername());
			pstm.setString(3, staff.getPassword());
			pstm.executeUpdate();
		} catch (SQLException e) {
	         e.printStackTrace();
	      } 		finally {
				db.close();			
			}
	}
	
	void deleteStaff(Staff staff) throws ClassNotFoundException, SQLException{
		Connection db= MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "DELETE FROM STAFF WHERE Staff_Id = ?";
			PreparedStatement pstm = db.prepareStatement(sql);
			pstm.setInt(1, staff.getStaffId());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		finally {
			db.close();			
		}
	}
	
	void getStaffInfo(Staff staff) {
		
	}
}
