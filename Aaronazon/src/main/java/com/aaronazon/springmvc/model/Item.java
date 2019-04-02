package com.aaronazon.springmvc.model;

public class Item {

	private String itemName;
	private String description;
	private ItemType itemType;
	private long id;

	/**
	 * default constructor 
	 */
	public Item() {}

	/**
	 * @param id 
	 * @param itemName
	 * @param description
	 * @param itemType
	 */
	public Item(long id, String itemName, String description, ItemType itemType) {
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.itemType = itemType;
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
