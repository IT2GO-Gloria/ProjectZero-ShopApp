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
import pojo.PaymentPojo;
import presentation.UserMain;

public class PaymentJdbcDaoImpl implements PaymentDao {

	private static final Logger logger = LogManager.getLogger(PaymentJdbcDaoImpl.class);
	
	@Override
	public PaymentPojo addPayment(PaymentPojo paymentPojo) throws ApplicationException {
		logger.info("Entered addPayment() in dao.");
		
		// this paymentPojo does not have an item id set in it.
		//set the payment_removed to false
		paymentPojo.setPaymentComplete(false);
		
		// jdbc steps 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "insert into payment_details(payment_id, payment_date, offer_id, user_id)" 
							+ "values('"+paymentPojo.getPaymentId()+"','"+paymentPojo.getPaymentDate()
							+"','"+paymentPojo.getOfferId()+"',"+paymentPojo.getUserId()+")";
			
			int rowsAffected = stmt.executeUpdate(query);
			if(rowsAffected != 0) { // means the record got inserted successfully
				// take out the primary key and store in the itemPojo object
				paymentPojo.setPaymentId(1);// hard coded to 1 - but later will figure out to fetch the generated
										// primary key from DB
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited addPayment() in dao.");
		return paymentPojo;
	}

	@Override
	public PaymentPojo updatePayment(PaymentPojo paymentPojo) throws ApplicationException {
		logger.info("Entered updatePayment() in dao.");
		
		// jdbc step 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "update payment_details set payment_complete="+paymentPojo.getOfferPrice()
							+" where payment_id="+paymentPojo.getPaymentId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());		
		}
		
		logger.info("Exited updatePayment() in dao.");
		return paymentPojo;
	}

	@Override
	public List<PaymentPojo> getAllPayments() throws ApplicationException {
		logger.info("Entered getAllPayments() in dao.");
		
		// create a empty collection which is going to hold all the records from the DB
		// as pojo Object
		List<PaymentPojo> allPaymentsStore = new ArrayList<PaymentPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from payment_details where payment_removed=false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// here as we iterate through the rs we should get
				// each record in a pojo object and
				// add it to the collection
				// and at the end we return the collection

				// as we iterate we are taking each record and storing it in a itemPojo object
				PaymentPojo paymentPojo = new PaymentPojo(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4),
						rs.getBoolean(5));

				// add the payment Pojo object to a collection
				allPaymentsStore.add(paymentPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllPayments() in dao.");
		return allPaymentsStore;
	}

	@Override
	public PaymentPojo getAPayment(int paymentId) throws ApplicationException {
		logger.info("Entered getAPayment() in dao.");
		
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		PaymentPojo paymentPojo = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from payment_details where payment_id="+paymentId
							+ "and payment_removed=false";
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				paymentPojo = new PaymentPojo(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4),
						rs.getBoolean(5));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAPayment() in dao.");
		return paymentPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

	@Override
	public PaymentPojo updatepayment(PaymentPojo paymentPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOffer(int paymentId) {
		// TODO Auto-generated method stub
		return false;
	}

}
