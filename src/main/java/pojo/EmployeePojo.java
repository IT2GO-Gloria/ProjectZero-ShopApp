package pojo;

//private variables
//public getters/setters
//default constructor / parameterized construction

//override equals()
//override hashcode()
//override toString()

public class EmployeePojo {

	// convenient if the DB columns count and type matches the pojo variables
	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	private String userType;
	private boolean employeeRemoved;
	
	public EmployeePojo() {
		super();
	}

	public EmployeePojo(int employeeId, String employeeName, String employeeEmail, String userType, 
			boolean employeeRemoved) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.userType = userType;
		this.employeeRemoved = employeeRemoved;
	}

	public EmployeePojo(int int1, String string, String string2, String string3, String query, String query2,
			boolean boolean1) {

	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isEmployeeRemoved() {
		return employeeRemoved;
	}

	public void setEmployeeRemoved(boolean employeeRemoved) {
		this.employeeRemoved = employeeRemoved;
	}

	@Override
	public String toString() {
		return "employeePojo [employeeId=" + employeeId + ", employeeName=" + employeeName + 
				"employeeEmail=" + employeeEmail + ", userType=" + userType + ",employeeRemoved=" + employeeRemoved + "]";
	}

	
}

