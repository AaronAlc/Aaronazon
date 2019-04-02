package com.aaronazon.springmvc.model;

public class Item {

	private String itemName;
	private String description;
	private ItemType itemType;
	private long id;

	//list the different types of items the shop sells
	//Will have to create an object to store this information eventually
	private enum ItemType{
		SHIRT, PANTS, SOCKS;

	}
	
	/**
	 * default constructor initializes id to 0
	 */
	public Item() {}

	/**
	 * @param id 
	 * @param itemName
	 * @param description
	 * @param itemType
	 */
	public Item(long id, String itemName, String description, String itemType) {
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		if(itemType.equalsIgnoreCase("Shirt")) this.itemType = ItemType.SHIRT;
		if(itemType.equalsIgnoreCase("Pants")) this.itemType = ItemType.PANTS;
		if(itemType.equalsIgnoreCase("Socks")) this.itemType = ItemType.SOCKS;
	}
	
	//sets the item to one of the ItemTypes will have to manually add as we get more items
	public void setItemType(String itemType) {
		if(itemType.equalsIgnoreCase("Shirt")) this.itemType = ItemType.SHIRT;
		if(itemType.equalsIgnoreCase("Pants")) this.itemType = ItemType.PANTS;
		if(itemType.equalsIgnoreCase("Socks")) this.itemType = ItemType.SOCKS;
	}
	
	public String getItemType() {
		if(this.itemType == null) return "";
		return this.itemType.toString();
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ItemName: " + itemName + " ID: " + id;
	}
}
