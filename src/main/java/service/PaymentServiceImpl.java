package service;

import java.util.List;				

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.PaymentDao;
import dao.PaymentJdbcDaoImpl;
import exception.ApplicationException;
import pojo.PaymentPojo;

public abstract class PaymentServiceImpl<paymentPojo, updatepayment> implements PaymentService{

	private static final Logger logger = LogManager.getLogger(PaymentServiceImpl.class);
	
	PaymentDao PaymentDao;
	
	public PaymentServiceImpl() {
		//this.paymentDao = new PaymentDaoImpl();
		this.PaymentDao = new PaymentJdbcDaoImpl();
	}
  
	public PaymentPojo addPayment(PaymentPojo paymentPojo) throws ApplicationException {
		logger.info("Entered addpayment() in service.");
		PaymentPojo returnPaymentPojo = this.PaymentDao.addPayment(paymentPojo);
		logger.info("Exited addPayment() in service.");
		return returnPaymentPojo;
	}

	@Override
	public <updatePayment> PaymentPojo updatePayment(pojo.PaymentPojo paymentPojo) throws ApplicationException {
		logger.info("Entered paymentOffer() in service.");
		PaymentPojo returnpaymentPojo = this.PaymentDao.updatePayment(paymentPojo);
		logger.info("Exited updatePayment() in service.");
		return returnpaymentPojo;
	}

	@Override
	public boolean deletePayment(int paymentId) throws ApplicationException {
		logger.info("Entered deletePayment () in service.");
		boolean returnFlag = this.PaymentDao.deleteOffer(paymentId);
		logger.info("Exited deletePayment() in service.");
		return returnFlag;
	}

	@Override
	public List<PaymentPojo> getAllPayments() throws ApplicationException {
		logger.info("Entered getAllPayments() in service.");
		List<PaymentPojo> allPayments = this.PaymentDao.getAllPayments();
		logger.info("Exited getAllpayments() in service.");
		return allPayments;
	}

	@Override
	public PaymentPojo getAPayment1(int paymentId) throws ApplicationException {
		logger.info("Entered getApayment() in service.");
		PaymentPojo returnpaymentPojo = this.PaymentDao.getAPayment(paymentId);
		logger.info("Exited getAPayment() in service.");
		return returnpaymentPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		PaymentDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}

	public PaymentPojo addPayment1(PaymentPojo paymentPojo) throws ApplicationException {
		return null;
	}

	@Override
	public PaymentPojo updateAPayment(PaymentPojo paymentPojo) throws ApplicationException {
		return null;
	}

	public PaymentPojo getAPayment(int PaymentId) throws ApplicationException {
		return null;
	}

	@Override
	public <paymentPojo> pojo.PaymentPojo updatepayment1(paymentPojo paymentPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
