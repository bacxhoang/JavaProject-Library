package librarymanagement.resource;
import java.io.Serializable;

public class Staff implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int staffId;
	private String username;
	private String password;
	
	public Staff(int staffId, String username, String password) {
		this.staffId = staffId;
		this.username = username;
		this.password = password;
	}
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
