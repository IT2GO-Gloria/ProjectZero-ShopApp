package service;

import java.util.List;	

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.OfferDao;
import dao.OfferJdbcDaoImpl;
import exception.ApplicationException;
import pojo.OfferPojo;

public class OfferServiceImpl implements OfferService{

	private static final Logger logger = LogManager.getLogger(OfferServiceImpl.class);
	
	OfferDao OfferDao;
	
	public OfferServiceImpl() {
		//this.offerDao = new offerDaoImpl();
		this.OfferDao = new OfferJdbcDaoImpl();
	}
  
	@Override
	public OfferPojo addOffer1(OfferPojo offerPojo) throws ApplicationException {
		logger.info("Entered addoffer() in service.");
		OfferPojo returnOfferPojo = this.OfferDao.addoffer(offerPojo);
		logger.info("Exited addOffer() in service.");
		return returnOfferPojo;
	}

	@Override
	public OfferPojo updateOffer1(OfferPojo offerPojo) throws ApplicationException {
		logger.info("Entered updateOffer() in service.");
		OfferPojo returnOfferPojo = this.OfferDao.updateoffer(offerPojo);
		logger.info("Exited updateOffer() in service.");
		return returnOfferPojo;
	}

	@Override
	public boolean deleteOffer(int offerId) throws ApplicationException {
		logger.info("Entered deleteOffer() in service.");
		boolean returnFlag = this.OfferDao.deleteOffer(offerId);
		logger.info("Exited deleteOffer() in service.");
		return returnFlag;
	}

	@Override
	public List<OfferPojo> getAllOffers() throws ApplicationException {
		logger.info("Entered getAllOffers() in service.");
		List<OfferPojo> allOffers = this.OfferDao.getAllOffers();
		logger.info("Exited getAllOffers() in service.");
		return allOffers;
	}

	@Override
	public OfferPojo getAOffer1(int offerId) throws ApplicationException {
		logger.info("Entered getAOffer() in service.");
		OfferPojo returnOfferPojo = this.OfferDao.getAOffer(offerId);
		logger.info("Exited getAOffer() in service.");
		return returnOfferPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		OfferDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}

	@Override
	public OfferPojo updateItem1(OfferPojo offerPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
