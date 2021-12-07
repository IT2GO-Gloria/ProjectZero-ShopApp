package service;

import java.util.List;			

import exception.ApplicationException;
import pojo.PaymentPojo;

public interface PaymentService {
	
	public static final String customerName = "";
	public static final String itemName = "";
	int offerPrice = 0;
	
	static PaymentPojo addPayment(PaymentPojo paymentPojo) throws ApplicationException {

		// determine ^ offer that is > the base price of $10
		String query = "SELECT customer_id, "
				+ "MAX(amount) FROM offer_details "
				+ "GROUP BY customer_id HAVING MAX(amount) >10"; 
		
		System.out.println("Congradulations! " + customerName + " won " +itemName+ " for $ "+"offerWon");
		
		// change offer won to true ==> toggles the Boolean
		String query1 = "UPDATE offer_details SET offer_won = NOT offer_won";
		
		// change payment to complete ==> toggles the Boolean
		String query2 = "UPDATE payment_details SET payment_complete = NOT payment_complete";
		
		// print out that the offer and payment are both complete
		System.out.println(customerName+ ", we have received your payment of: $"+offerPrice+ " for " +itemName+".");
		System.out.println("Thank you for your payment!");
		return PaymentPojo;
	}
	
	PaymentPojo PaymentPojo = null;
	static PaymentPojo getPayment(int itemId) throws ApplicationException {
		String query = "SELECT* FROM payment_details WHERE payment_complete ='true'";
		System.out.println("The payment confirmation you requested!");
		return PaymentPojo;
	}
	void exitApplication();
	PaymentPojo addPayment1(PaymentPojo paymentPojo) throws ApplicationException;
	PaymentPojo updatePayment1(PaymentPojo paymentPojo) throws ApplicationException;
	PaymentPojo getAPayment1(int paymentId) throws ApplicationException;
	boolean deletePayment(int paymentId) throws ApplicationException;
	List<PaymentPojo> getAllPayments() throws ApplicationException;
	<paymentPojo> pojo.PaymentPojo updatepayment1(paymentPojo paymentPojo) throws ApplicationException;
	<updatePayment> pojo.PaymentPojo updatePayment(pojo.PaymentPojo paymentPojo) throws ApplicationException;
	<updatePayment> pojo.PaymentPojo updatePayment11(pojo.PaymentPojo paymentPojo) throws ApplicationException;
	pojo.PaymentPojo updateAPayment(pojo.PaymentPojo paymentPojo) throws ApplicationException; 
}
