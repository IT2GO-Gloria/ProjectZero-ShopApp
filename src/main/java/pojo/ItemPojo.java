package pojo;

//private variables
//public getters/setters
//default constructor / parameterized construction

//override equals()
//override hashcode()
//override toString()

public class ItemPojo {

	// convenient if the DB columns count and type matches the pojo variables
	private static int itemId;
	private static String itemTitle;
	private static String itemGenre;
	private static String itemArtist;
	private static int itemCost;
	private boolean itemRemoved;
	
	public ItemPojo() {
		super();
	}

	public ItemPojo(int itemId, String itemTitle, String itemGenre, String itemArtist, int itemCost,
			boolean itemRemoved) {
		super();
		this.itemId = itemId;
		this.itemTitle = itemTitle;
		this.itemGenre = itemGenre;
		this.itemArtist = itemArtist;
		this.itemCost = itemCost;
		this.itemRemoved = itemRemoved;
	}

	public static int getItemId() {
		return itemId;
		}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public static String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public static String getItemGenre() {
		return itemGenre;
	}

	public void setItemGenre(String itemGenre) {
		this.itemGenre = itemGenre;
	}

	public static String getItemArtist() {
		return itemArtist;
	}

	public void setItemArtist(String itemArtist) {
		this.itemArtist = itemArtist;
	}

	public static int getItemCost() {
		return itemCost;
	}

	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}

	public boolean isItemRemoved() {
		return itemRemoved;
	}

	public void setItemRemoved(boolean itemRemoved) {
		this.itemRemoved = itemRemoved;
	}

	@Override
	public String toString() {
		return "ItemPojo [itemId=" + itemId + ", itemTitle=" + itemTitle + ", itemGenre=" + itemGenre + ", itemArtist="
				+ itemArtist + ", itemCost=" + itemCost + ", itemRemoved=" + itemRemoved + "]";
	}

	
}
