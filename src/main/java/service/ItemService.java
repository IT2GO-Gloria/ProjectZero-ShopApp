package service;

import java.util.List;					

import exception.ApplicationException;
import pojo.CustomerPojo;
import pojo.ItemPojo;

public interface ItemService {
	static ItemPojo addItem1(ItemPojo itemPojo) throws ApplicationException {
		String query = "INSERT INTO item_details(item_title, item_genre, item_artist, item_cost, item_removed) VALUES(?, ?, ?, ?)";
		System.out.println("A new item was added!");
		return itemPojo;
	}
	static ItemPojo updateItem1(ItemPojo itemPojo) throws ApplicationException {
		String query = "INSERT INTO item_details(item_title, item_genre, item_artist, item_cost, item_removed)) VALUES(?, ?, ?, ?)";
		System.out.println("An item was updated!");
		return itemPojo;
	}
	ItemPojo itemPojo = null;
	String itemId = null;
	String itemTitle = null;
	boolean deleteItem(int itemId) throws ApplicationException;
	 void getAllitems() throws ApplicationException;
	static ItemPojo getItem(int itemId) throws ApplicationException {
		String query = "SELECT* FROM item_details (item_title, item_genre, item_artist, item_cost, item_removed) VALUES(?,?,?,?)";
		System.out.println("The item you requested!");
		return itemPojo;
	}
	void exitApplication();
	ItemPojo addItem(ItemPojo itemPojo) throws ApplicationException;
	ItemPojo updateItem(ItemPojo itemPojo) throws ApplicationException;
	static ItemPojo getAItem(int itemId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
	static ItemPojo getAItem1(int itemId2) {
		// TODO Auto-generated method stub
		return null;
	}
	static ItemPojo getItem() {
		// TODO Auto-generated method stub
		return null;
	} 
}
