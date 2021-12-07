package dao;

import java.util.List;			

import exception.ApplicationException;
import pojo.OfferPojo;

public interface OfferDao {
	OfferPojo addoffer(OfferPojo offerPojo) throws ApplicationException;
	OfferPojo updateItem(OfferPojo offerPojo) throws ApplicationException;
	boolean deleteItem(int offerId) throws ApplicationException;
	List<OfferPojo> getAllOffers() throws ApplicationException;
	OfferPojo getAOffer(int offerId) throws ApplicationException;
	void exitApplication();
	OfferPojo updateoffer(OfferPojo offerPojo);
	OfferPojo addOffer(OfferPojo offerPojo) throws ApplicationException;
	OfferPojo updateOffer(OfferPojo offerPojo) throws ApplicationException;
	boolean rejectOffer(int offerId) throws ApplicationException;
	boolean deleteOffer(int offerId);
	
}
 