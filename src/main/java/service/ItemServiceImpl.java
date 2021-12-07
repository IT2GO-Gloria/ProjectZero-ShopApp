package service;

import java.util.List;				

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ItemDao;
import dao.ItemJdbcDaoImpl;
import dao.DBUtil;
import exception.ApplicationException;
import pojo.CustomerPojo;
import pojo.ItemPojo;

public class ItemServiceImpl implements ItemService{

	private static final Logger logger = LogManager.getLogger(ItemServiceImpl.class);
	
	ItemDao itemDao;
	
	public ItemServiceImpl() {
		//this.itemDao = new ItemDaoImpl();
		this.itemDao = new ItemJdbcDaoImpl();
	}
  
	public ItemPojo addItem1(ItemPojo itemPojo) throws ApplicationException {
		logger.info("Entered addItem() in service.");
		ItemPojo returnItemPojo = this.itemDao.addItem(itemPojo);
		logger.info("Exited addItem() in service.");
		return returnItemPojo;
	}

	public ItemPojo updateItem1(ItemPojo itemPojo) throws ApplicationException {
		logger.info("Entered updateItem() in service.");
		ItemPojo returnItemPojo = this.itemDao.updateItem(itemPojo);
		logger.info("Exited updateItem() in service.");
		return returnItemPojo;
	}

	@Override
	public boolean deleteItem(int itemId) throws ApplicationException {
		logger.info("Entered deleteITem() in service.");
		boolean returnFlag = this.itemDao.deleteItem(itemId);
		logger.info("Exited deleteItem() in service.");
		return returnFlag;
	}

	public List<ItemPojo> getAllItems() throws ApplicationException {
		logger.info("Entered getAllItems() in service.");
		List<ItemPojo> allItems = this.itemDao.getAllItems();
		logger.info("Exited getAllItems() in service.");
		return allItems;
	}

	public ItemPojo getAItem1(int itemId) throws ApplicationException {
		logger.info("Entered getAItem() in service.");
		ItemPojo returnItemPojo = this.itemDao.getAItem(itemId);
		logger.info("Exited getAItem() in service.");
		return returnItemPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		itemDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}

	public ItemPojo addItem(ItemPojo itemPojo) throws ApplicationException {
		return null;
	}

	
	public ItemPojo updateItem(ItemPojo itemPojo) throws ApplicationException {
		return null;
	}

	
	public ItemPojo getAItem(int itemId) throws ApplicationException {
		return null;
	}

	public CustomerPojo addCustomer1(CustomerPojo customerPojo) throws ApplicationException {
		return null;
	}

	public CustomerPojo updateCustomer1(CustomerPojo customerPojo) throws ApplicationException {
		return null;
	}

	public boolean deleteCustomer(int customerId) throws ApplicationException {
		return false;
	}

	public List<CustomerPojo> getAllCustomers() throws ApplicationException {
		return null;
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

	public void deleteItem1(int itemId) {
		
	}

	public boolean Itemdeleted(int itemId) throws ApplicationException {
		return false;
	}

	@Override
	public void getAllitems() throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

}
