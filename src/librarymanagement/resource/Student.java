package librarymanagement.resource;
import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int studentId;
	private String studentName;
	private int borrowerId;
	private int phoneNumber;
	
	public Student(int studentId, String studentName, int borrowerId, int phoneNumber) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.borrowerId = borrowerId;
		this.phoneNumber = phoneNumber;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
}
