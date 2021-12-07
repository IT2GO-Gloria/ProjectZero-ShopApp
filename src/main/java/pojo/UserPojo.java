package pojo;

// private variables
// public getters/setters
// default constructor / parameterized construction

// override equals()
// override hashcode()
// override toString()

public class UserPojo {

	// convenient if the DB columns count and type matches the pojo variables
	private int userId;
	private String userName;
	private String userEmail;
	private boolean userRemoved;
	
	public UserPojo() {
		super();
	}

	public UserPojo(int userId, String userName, String userEmail,
			boolean userRemoved) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userRemoved = userRemoved;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserRemoved(boolean userRemoved) {
		this.userRemoved = userRemoved;
	}

	@Override
	public String toString() {
		return "userPojo [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + "]";
	}

	public String getUserId1() {
		return "userPojo [userId=" + userId + ", userName=" + userName + "]";
	}

	public String getUserName1() {
		return "userPojo [userName=" + userName + "]";
	}

	public String getEmail() {
		return "userPojo [userEmail=" + userEmail + "]";
	}

	public String isUserRemoved() {
		return "userPojo [userRemoved=" + userRemoved + "]";
	}

	public void setUserId(int i) {
		// Done automatically if set in postgres SQL table as follows: 
		// "user_id INT generated always as identity PRIMARY KEY"
		
	}

	public void setItemRemoved(boolean b) {
		
		
	}

	public String getUserType() {
		return null;
	}

	public void setUserType(String string) {
/*		
		if userType == Customer {
			this user = Customer
		}
		else if userType == Employee
				this user = Employee
	*/	
	}

	public void setUserPassword(String nextLine) {
	
		
	}

}

