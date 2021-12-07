
package pojo;

//private variables
//public getters/setters
//default constructor / parameterized construction

//override equals()
//override hashcode()
//override toString()

public class CustomerPojo {

	// convenient if the DB columns count and type matches the pojo variables
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String userType;
	private boolean customerRemoved;
	
	public CustomerPojo() {
		super();
	}

	public CustomerPojo(int customerId, String customerName, String customerEmail, String userType, 
			boolean customerRemoved) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.userType = userType;
		this.customerRemoved = customerRemoved;
	}

	public CustomerPojo(int int1, String string, String string2, String string3, String query, String query2,
			boolean boolean1) {
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isCustomerRemoved() {
		return customerRemoved;
	}

	public void setCustomerRemoved(boolean customerRemoved) {
		this.customerRemoved = customerRemoved;
	}

	@Override
	public String toString() {
		return "CustomerPojo [customerId=" + customerId + ", customerName=" + 
	customerName + ", customerEmail=" + customerEmail + ", userType=" + userType + ",customerRemoved=" + customerRemoved + "]";
	}

	
}

