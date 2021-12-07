package pojo;

// private variables
// public getters/setters
// default constructor, parameterized construction

// override equals()
// override hashcode()
// override toString()

public class OfferPojo {

	// convenient if the DB columns count and type matches the pojo variables
	private int offerId;
	private int itemId;
	private int userId;
	private int offerPrice;
	private boolean offerWon;
	
	public OfferPojo() {
		super();
	}

	public OfferPojo(int offerId, int itemId, int userId, int offerPrice, 
			boolean offerWon) {
		super();
		this.offerId = offerId;
		this.itemId = itemId;
		this.userId = userId;
		this.offerPrice = offerPrice;
		this.offerWon = offerWon;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(int offerPrice) {
		this.offerPrice = offerPrice;
	}

	public boolean isOfferWon() {
		return offerWon;
	}

	public void setOfferWon(boolean offerWon) {
		this.offerWon = offerWon;
	}

	@Override
	public String toString() {
		return "OfferPojo [offerId=" + offerId + ", itemId=" + itemId + ", userId=" + userId + ", offerPrice="
				+ offerPrice + ", offerWon=" + offerWon + "]";
	}

	public String setOfferWon1(boolean offerWon) {
		return "OfferPojo [offerId=" + offerId + ", itemId=" + itemId + ", userId=" + userId + ", offerPrice="
				+ offerPrice + ", offerWon=" + offerWon + "]";
		
	}

	
}
