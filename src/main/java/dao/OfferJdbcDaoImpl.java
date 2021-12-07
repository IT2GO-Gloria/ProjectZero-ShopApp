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
import pojo.OfferPojo;
import presentation.UserMain;

public class OfferJdbcDaoImpl implements OfferDao {

	private static final Logger logger = LogManager.getLogger(OfferJdbcDaoImpl.class);
	
	@Override
	public OfferPojo addOffer(OfferPojo offerPojo) throws ApplicationException {
		logger.info("Entered addOffer() in dao.");
		
		// this offerPojo does not have an item id set in it.
		//set the offer_removed to false
		offerPojo.setOfferWon(false);
		
		// jdbc steps 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "insert into offer_details(offer_id, item_id, user_id, offer_price, offer_won)" 
							+ "values('"+offerPojo.getOfferId()+"','"+offerPojo.getItemId()
							+"','"+offerPojo.getUserId()+"',"+offerPojo.getOfferPrice()
							+","+offerPojo.isOfferWon()+")";
			
			int rowsAffected = stmt.executeUpdate(query);
			if(rowsAffected != 0) { // means the record got inserted successfully
				// take out the primary key and store in the itemPojo object
				offerPojo.setOfferId(1);// hard coded to 1 - but later will figure out to fetch the generated
										// primary key from DB
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited addItem() in dao.");
		return offerPojo;
	}

	@Override
	public OfferPojo updateOffer(OfferPojo offerPojo) throws ApplicationException {
		logger.info("Entered updateOffer() in dao.");
		
		// jdbc step 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "update offer_details set offer_cost="+offerPojo.getOfferPrice()
							+" where offer_id="+offerPojo.getOfferId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());		
		}
		
		logger.info("Exited updateOffer() in dao.");
		return offerPojo;
	}

	@Override
	public boolean rejectOffer(int offerId) throws ApplicationException {
		logger.info("Entered RejectOffer() in dao.");
		
		boolean flag = true;
		Connection conn = DBUtil.makeConnection();
		int rowsAffected = 0;
		try {
			Statement stmt = conn.createStatement();
			// here we are not going to do a hard delete, we are going 
			// for a soft delete.
			String query = "update Offer_details set offer_rejected=true where Offer_id="+offerId;
			rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected);
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		if(rowsAffected == 0)
			flag = false;
		
		logger.info("Exited rejectedOffer() in dao.");
		return flag;
	}

	@Override
	public List<OfferPojo> getAllOffers() throws ApplicationException {
		logger.info("Entered getAllOffers() in dao.");
		
		// create a empty collection which is going to hold all the records from the DB
		// as pojo Object
		List<OfferPojo> allOffersStore = new ArrayList<OfferPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from offer_details where offer_rejected=false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// here as we iterate through the rs we should get
				// each record in a pojo object and
				// add it to the collection
				// and at the end we return the collection

				// as we iterate we are taking each record and storing it in a itemPojo object
				OfferPojo offerPojo = new OfferPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getBoolean(5));

				// add the item Pojo object to a collection
				allOffersStore.add(offerPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllOffers() in dao.");
		return allOffersStore;
	}

	@Override
	public OfferPojo getAOffer(int offerId) throws ApplicationException {
		logger.info("Entered getAOffer() in dao.");
		
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		OfferPojo offerPojo = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from offer_details where offer_id="+offerId
							+ "and offer_rejected=false";
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				offerPojo = new OfferPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getBoolean(5));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAOffer() in dao.");
		return offerPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

	@Override
	public OfferPojo updateoffer(OfferPojo offerPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfferPojo addoffer(OfferPojo offerPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfferPojo updateItem(OfferPojo offerPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteItem(int offerId) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOffer(int offerId) {
		// TODO Auto-generated method stub
		return false;
	}

}
