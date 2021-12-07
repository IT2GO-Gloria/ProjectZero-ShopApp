package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.CustomerDao;
import dao.CustomerJdbcDaoImpl;
import exception.ApplicationException;
import pojo.CustomerPojo;
import pojo.ItemPojo;

public class CustomerServiceImpl implements ItemService{

	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);
	
	CustomerDao customerDao;
	
	public CustomerServiceImpl() {
		//this.customerDao = new customerDaoImpl();
		this.customerDao = new CustomerJdbcDaoImpl();
	}
  
	public CustomerPojo addCustomer1(CustomerPojo customerPojo) throws ApplicationException {
		logger.info("Entered addCustomer() in service.");
		CustomerPojo returnCustomerPojo = this.customerDao.addCustomer(customerPojo);
		logger.info("Exited addItem() in service.");
		return returnCustomerPojo;
	}

	public CustomerPojo updateCustomer1(CustomerPojo customerPojo) throws ApplicationException {
		logger.info("Entered updateCustomer() in service.");
		CustomerPojo returnCustomerPojo = this.customerDao.updateCustomer(customerPojo);
		logger.info("Exited updateCustomer() in service.");
		return returnCustomerPojo;
	}

	public boolean deleteCustomer(int customerId) throws ApplicationException {
		logger.info("Entered deleteCustomer() in service.");
		boolean returnFlag = this.customerDao.deleteCustomer(customerId);
		logger.info("Exited deleteCustomer() in service.");
		return returnFlag;
	}

	public List<CustomerPojo> getAllCustomers() throws ApplicationException {
		logger.info("Entered getAllItems() in service.");
		List<CustomerPojo> allCustomers = this.customerDao.getAllCustomers();
		logger.info("Exited getAllItems() in service.");
		return allCustomers;
	}

	public CustomerPojo getACustomer1(int customerId) throws ApplicationException {
		logger.info("Entered getACustomer() in service.");
		CustomerPojo returnCustomerPojo = this.customerDao.getACustomer(customerId);
		logger.info("Exited getACustomer() in service.");
		return returnCustomerPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		CustomerDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}

	public CustomerPojo addCustomer(CustomerPojo customerPojo) throws ApplicationException {
		return null;
	}

	public CustomerPojo updateCustomer(CustomerPojo customerPojo) throws ApplicationException {
		return null;
	}

	public CustomerPojo getACustomer(int customerId) throws ApplicationException {
		return null;
	}

	public boolean Itemdeleted(int itemId) throws ApplicationException {
		return false;
	}

	public ItemPojo addItem1(ItemPojo itemPojo) throws ApplicationException {
		return null;
	}

	public ItemPojo updateItem1(ItemPojo itemPojo) throws ApplicationException {
		return null;
	}

	public ItemPojo getAItem1(int itemId) throws ApplicationException {
		return null;
	}

	public boolean deleteItem(ItemPojo itemPojo) throws ApplicationException {
		return false;
	}

	public List<ItemPojo> getAllItems() throws ApplicationException {
		return null;
	}

	public ItemPojo updateItem(ItemPojo itemPojo) {
		return null;
	}

	public void deleteItem1(int itemId) {
		
	}

	@Override
	public boolean deleteItem(int itemId) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	public ItemPojo getAItem(int itemId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemPojo addItem(ItemPojo itemPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAllitems() throws ApplicationException {
		// TODO Auto-generated method stub
		
	}
	

}
