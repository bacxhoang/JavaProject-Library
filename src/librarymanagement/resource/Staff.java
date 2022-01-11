package librarymanagement.resource;

public class Staff{
	private int staffId;
	private String username;
	private String password;

	public Staff(int staffId,String username,String password) {
		this.staffId = staffId;
		this.username = username;
		this.password = password;
	}

	public int getStaffId() {
		return staffId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
}
