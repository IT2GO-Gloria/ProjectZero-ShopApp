package dao;

import java.util.List;			

import exception.ApplicationException;
import pojo.CustomerPojo;
import pojo.ItemPojo;

public interface CustomerDao {
	CustomerPojo addCustomer(CustomerPojo customerPojo) throws ApplicationException;
	CustomerPojo updateCustomer(CustomerPojo CustomerPojo) throws ApplicationException;
	boolean deleteCustomer(int CustomerId) throws ApplicationException;
	List<CustomerPojo> getAllCustomers() throws ApplicationException;
	CustomerPojo getACustomer(int customerId) throws ApplicationException;
	//static void exitApplication() {
		
	//}
	CustomerPojo updatecustomer(CustomerPojo customerPojo);
	ItemPojo addItem(ItemPojo itemPojo) throws ApplicationException;
	List<CustomerPojo> getAllCustomer() throws ApplicationException;
	CustomerPojo updateitem(CustomerPojo customerPojo);
	CustomerPojo addItem(CustomerPojo customerPojo) throws ApplicationException;
	static void exitApplication() {
		// TODO Auto-generated method stub
		
	}

	
}
 