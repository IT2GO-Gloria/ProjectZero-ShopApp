package pojo;

import java.sql.Timestamp;

// private variables
// public getters/setters
// default constructor / parameterized construction

// override equals()
// override hashcode()
// override toString()

public class PaymentPojo {

	// convenient if the DB columns count and type matches the pojo variables
	private int paymentId;
	private Timestamp paymentDate;
	private int offerId;
	private int userId;
	private boolean paymentComplete;
	
	public PaymentPojo() {
		super();
	}

	public PaymentPojo(int paymentId, Timestamp paymentDate, int offerId, int userId, 
			boolean paymentComplete) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.offerId = offerId;
		this.userId = userId;
		this.paymentComplete = paymentComplete;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PaymentPojo [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", offerId=" + offerId + ", userId="
				+ userId + ", paymentComplete=" + paymentComplete+"]";
	}

	public void setPaymentComplete(boolean b) {
		return;
	}

	public String getOfferPrice() {
		// TODO Auto-generated method stub
		return null;
	}
}
		
	
