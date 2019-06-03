package com.aaronazon.springmvc.view;

import com.aaronazon.springmvc.entity.Item;

public class ItemView{

	private long id;
	
	private String itemName;

	private String description;

	private String imageLoc;

	public ItemView() {}

	/**
	 * @param id 
	 * @param itemName
	 * @param description
	 */
	public ItemView(long id, String itemName, String description, String imageLoc) {
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.imageLoc = imageLoc;
	}
	
	public ItemView(Item item) {
		this.id = item.getId();
		this.itemName = item.getItemName();
		this.description = item.getDescription();
		this.imageLoc = item.getImageLoc();
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

	public String getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(String imageLoc) {
		this.imageLoc = imageLoc;
	}

	@Override
	public String toString() {
		return "ItemName: " + this.itemName + " ID: " + this.id +
				" Description: " + this.description;
	}

}