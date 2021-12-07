package service;

import java.util.List;		

import exception.ApplicationException;
import pojo.OfferPojo;

public interface OfferService {
	static OfferPojo addOffer(OfferPojo offerPojo) throws ApplicationException {
		return null;
	}
	static OfferPojo updateOffer(OfferPojo offerPojo) throws ApplicationException {
		return null;
	}
	static OfferPojo getAOffer(int offerId) throws ApplicationException {
		return null;
	}
	void exitApplication();
	OfferPojo addOffer1(OfferPojo offerPojo) throws ApplicationException;
	OfferPojo updateItem1(OfferPojo offerPojo) throws ApplicationException;
	OfferPojo getAOffer1(int offerId) throws ApplicationException;
	OfferPojo updateOffer1(OfferPojo offerPojo) throws ApplicationException;
	boolean deleteOffer(int offerId) throws ApplicationException;
	List<OfferPojo> getAllOffers() throws ApplicationException; 
}
