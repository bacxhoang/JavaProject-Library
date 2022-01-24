package librarymanagement.resource;

public class Student{
	private int studentId;
	private String studentName;
	private int borrowerId;
	private int phoneNumber;

	public Student(int studentId, String studentName, int borrowerId,int phoneNumber) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.borrowerId = borrowerId;
		this.phoneNumber = phoneNumber;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public int getBorrowerId() {
		return borrowerId;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	
}
