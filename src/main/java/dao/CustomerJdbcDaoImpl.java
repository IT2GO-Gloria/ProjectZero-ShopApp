package dao;

import java.sql.Connection;										
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

import exception.ApplicationException;
import pojo.CustomerPojo;
import pojo.ItemPojo;
import presentation.UserMain;

public class CustomerJdbcDaoImpl implements CustomerDao {

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerJdbcDaoImpl.class);
	
	@Override
	public CustomerPojo addItem(CustomerPojo customerPojo) throws ApplicationException {
		logger.info("Entered addCustomer() in dao.");
		
		// this CustomerPojo does not have an item id set in it.
		// set the customer_removed to false
		customerPojo.setCustomerRemoved(false);
		
		// jdbc steps 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "insert into customer_details(customer_ id, customer_name, customer_email, user_type, customer_removed)" 
							+ "values('"+customerPojo.getCustomerId()+"','"+customerPojo.getCustomerName()
							+"','"+customerPojo.getCustomerEmail()+"',"+customerPojo.getUserType()
							+","+customerPojo.isCustomerRemoved()+")";
			
			int rowsAffected = stmt.executeUpdate(query);
			if(rowsAffected != 0) { // means the record got inserted successfully
				// take out the primary key and store in the itemPojo object
				customerPojo.setCustomerId(1);// hard coded to 1 - but later will figure out to fetch the generated
										// primary key from DB
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited addItem() in dao.");
		return customerPojo;
	}

	@Override
	public CustomerPojo updateCustomer(CustomerPojo customerPojo) throws ApplicationException {
		logger.info("Entered updateCustomer() in dao.");
		
		// jdbc step 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
		    String query = "update customer_details set customer_details="+customerPojo.getCustomerId()
							+" where customer_id="+customerPojo.getCustomerId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());		
		}
		
		logger.info("Exited updateCustomer() in dao.");
		return customerPojo;
	}

	@Override
	public boolean deleteCustomer(int customerId) throws ApplicationException {
		logger.info("Entered deleteCustomer() in dao.");
		
		boolean flag = true;
		Connection conn = DBUtil.makeConnection();
		int rowsAffected = 0;
		try {
			Statement stmt = conn.createStatement();
			// here we are not going to do a hard delete, we are going 
			// for a soft delete.
			String query = "update customer_details set customer_removed=true where customer_id="+customerId;
			rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected);
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		if(rowsAffected == 0)
			flag = false;
		
		logger.info("Exited deleteCustomer() in dao.");
		return flag;
	}

	@Override
	public List<CustomerPojo> getAllCustomer() throws ApplicationException {
		logger.info("Entered getAllCustomers() in dao.");
		
		// create a empty collection which is going to hold all the records from the DB
		// as pojo Object
		List<CustomerPojo> allCustomersStore = new ArrayList<CustomerPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from customer_details where customer_removed=false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// here as we iterate through the rs we should get
				// each record in a pojo object and
				// add it to the collection
				// and at the end we return the collection

				// as we iterate we are taking each record and storing it in a itemPojo object
				CustomerPojo customerPojo = new CustomerPojo();

				// add the item Pojo object to a collection
				allCustomersStore.add(customerPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllItems() in dao.");
		return allCustomersStore;
	}

	@Override
	public CustomerPojo getACustomer(int customerId) throws ApplicationException {
		logger.info("Entered getACustomer() in dao.");
		
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		CustomerPojo customerPojo = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from customer_details where customer_id="+customerId
							+ "and customer_removed=false";
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				customerPojo = new CustomerPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						query, query, rs.getBoolean(5));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getACustomer() in dao.");
		return customerPojo;
	}

	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

	@Override
	public CustomerPojo updateitem(CustomerPojo customerPojo) {
		return null;
	}

	@Override
	public CustomerPojo addCustomer(CustomerPojo customerPojo) throws ApplicationException {
		return null;
	}

	@Override
	public List<CustomerPojo> getAllCustomers() throws ApplicationException {
		return null;
	}

	@Override
	public CustomerPojo updatecustomer(CustomerPojo customerPojo) {
		return null;
	}

	@Override
	public ItemPojo addItem(ItemPojo itemPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
