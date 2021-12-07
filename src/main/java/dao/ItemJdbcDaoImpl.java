package dao;

import java.sql.Connection;					
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import pojo.ItemPojo;
import presentation.UserMain;

public class ItemJdbcDaoImpl implements ItemDao {

	private static final Logger logger = LogManager.getLogger(ItemJdbcDaoImpl.class);
	
	@Override
	public ItemPojo addItem(ItemPojo itemPojo) throws ApplicationException {
		logger.info("Entered addItem() in dao.");
		
		// this itemPojo does not have an item id set in it.
		//set the book_removed to false
		itemPojo.setItemRemoved(false);
		
		// jdbc steps 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "insert into item_details(item_title, item_artist, item_genre, item_cost, item_removed)" 
							+ "values('"+itemPojo.getItemTitle()+"','"+itemPojo.getItemArtist()
							+"','"+itemPojo.getItemGenre()+"',"+itemPojo.getItemCost()
							+","+itemPojo.isItemRemoved()+")";
			
			int rowsAffected = stmt.executeUpdate(query);
			if(rowsAffected != 0) { // means the record got inserted successfully
				// take out the primary key and store in the itemPojo object
				itemPojo.setItemId(1);// hard coded to 1 - but later will figure out to fetch the generated
										// primary key from DB
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited addItem() in dao.");
		return itemPojo;
	}

	@Override
	public ItemPojo updateItem(ItemPojo itemPojo) throws ApplicationException {
		logger.info("Entered updateItem() in dao.");
		
		// jdbc step 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "update item_details set item_cost="+itemPojo.getItemCost()
							+" where item_id="+itemPojo.getItemId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());		
		}
		
		logger.info("Exited updateItem() in dao.");
		return itemPojo;
	}

	@Override
	public boolean deleteItem(int itemId) throws ApplicationException {
		logger.info("Entered deleteItem() in dao.");
		
		boolean flag = true;
		Connection conn = DBUtil.makeConnection();
		int rowsAffected = 0;
		try {
			Statement stmt = conn.createStatement();
			// here we are not going to do a hard delete, we are going 
			// for a soft delete.
			String query = "update item_details set item_removed=true where item_id="+itemId;
			rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected);
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		if(rowsAffected == 0)
			flag = false;
		
		logger.info("Exited deleteItem() in dao.");
		return flag;
	}

	@Override
	public List<ItemPojo> getAllItems() throws ApplicationException {
		logger.info("Entered getAllItems() in dao.");
		
		// create a empty collection which is going to hold all the records from the DB
		// as pojo Object
		List<ItemPojo> allItemsStore = new ArrayList<ItemPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from item_details where item_removed=false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// here as we iterate through the rs we should get
				// each record in a pojo object and
				// add it to the collection
				// and at the end we return the collection

				// as we iterate we are taking each record and storing it in a itemPojo object
				ItemPojo itemPojo = new ItemPojo(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3),
						rs.getInt(5), rs.getBoolean(6));

				// add the item Pojo object to a collection
				allItemsStore.add(itemPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllItems() in dao.");
		return allItemsStore;
	}

	@Override
	public ItemPojo getAItem(int itemId) throws ApplicationException {
		logger.info("Entered getAItem() in dao.");
		
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		ItemPojo itemPojo = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from item_details where item_id="+itemId
							+ "and item_removed=false";
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				itemPojo = new ItemPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getBoolean(6));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAItem() in dao.");
		return itemPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

	@Override
	public ItemPojo updateitem(ItemPojo itemPojo) {
		// TODO Auto-generated method stub
		return null;
	}

}
