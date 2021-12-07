package service;

import java.util.List;			 

import exception.ApplicationException;
import pojo.CustomerPojo;


public interface CustomerService {
	static CustomerPojo addCustomer(CustomerPojo customerPojo) throws ApplicationException {
		String query = "INSERT INTO customer_details(customer_name, customer_email, user_type, item_removed) VALUES(?, ?, ?, ?)";
		System.out.println("A new customer was added!");
		return customerPojo;
	}
	static CustomerPojo updateCustomer(CustomerPojo customerPojo) throws ApplicationException {
		String query = "INSERT INTO customer_details(customer_name, customer_email, user_type, item_removed) VALUES(?, ?, ?, ?)";
		System.out.println("A new customer was added!");
		return customerPojo;
	}
	CustomerPojo customerPojo = null;
	boolean deleteCustomer(int customerId) throws ApplicationException;
	static List<CustomerPojo> getAllCustomers() throws ApplicationException {
		
		String customerName = null;
		int customerId = 0;
		
		System.out.println("Item to be deleted is: " +customerId+ " , "
				+ "" +customerName+".");
		String query = "DELETE FROM customer_details WHERE customerId IN (SELECT customer_id FROM customer_details)";
		int customerPojo = 0;
		System.out.println(+customerPojo+": "+customerName+" was deleted.");
		return null;
	}
	static CustomerPojo getCustomer(int customerId) throws ApplicationException {
		String query = "SELECT* FROM customer_details (customer_name, customer_email, user_type, customer_removed) VALUES(?,?,?,?)";
		System.out.println("The item you requested!");
		return customerPojo;
	}
	void exitApplication();
	CustomerPojo addCustomer1(CustomerPojo customerPojo) throws ApplicationException;
	CustomerPojo updateCustomer1(CustomerPojo customerPojo) throws ApplicationException;
	CustomerPojo getACustomer1(int customerId) throws ApplicationException; 
}
