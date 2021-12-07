package dao;

import java.util.List;			

import exception.ApplicationException;
import pojo.PaymentPojo;

public interface PaymentDao {
	PaymentPojo addPayment(PaymentPojo paymentPojo) throws ApplicationException;
	PaymentPojo updatePayment(PaymentPojo paymentPojo) throws ApplicationException;
	List<PaymentPojo> getAllPayments() throws ApplicationException;
	PaymentPojo getAPayment(int paymentId) throws ApplicationException;
	void exitApplication();
	PaymentPojo updatepayment(PaymentPojo paymentPojo);
	boolean deleteOffer(int paymentId);
	
}
 