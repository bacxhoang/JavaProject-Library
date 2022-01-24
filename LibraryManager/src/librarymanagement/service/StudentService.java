package librarymanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import librarymanagement.database.MyConnection;
import librarymanagement.resource.Student;

public class StudentService {
	private Connection connection;
	
	public StudentService() {
		Connection connection = MyConnection.getConnection();
	}
	
	public void addStudent(Student student) throws ClassNotFoundException, SQLException{
		try {
			String sql = "INSERT INTO STUDENT VALUES(?,?,?,?)";
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
			pstm.setInt(1, student.getStudentId());
			pstm.setString(2, student.getStudentName());
			pstm.setInt(3, student.getBorrowerId());
			pstm.setInt(4, student.getPhoneNumber());
			pstm.executeUpdate();
		} catch (SQLException e) {
	         e.printStackTrace();
	      } 		finally {
				connection.close();			
			}
	}
	
	void deleteStudent(Student student) throws ClassNotFoundException, SQLException{
		try {
			String sql = "DELETE FROM STUDENT WHERE Student_Id = ?";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, student.getStudentId());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		finally {
			connection.close();			
		}
	}
	
	public ArrayList<Object> getStudentInfo(Student student) {
		ArrayList<Object> studentInfo = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM STUDENT";
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery(sql);
			while(rs.next()) {
				studentInfo.add(rs.getInt("Student_Id"));
				studentInfo.add(rs.getString("Student_Name"));
				studentInfo.add(rs.getInt("Borrower_Id"));
				studentInfo.add(rs.getInt("Phone_number"));
			}
			
	} catch (SQLException e) {
        e.printStackTrace();
     }
		return studentInfo;
	}
}
