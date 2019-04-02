package com.aaronazon.springmvc.model;

@Deprecated
public abstract class AbstractItem {

	protected String itemName;
	protected String description;
	protected long id;
	protected long itemID;
	protected enum itemType{
		SHIRT;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String name) {
		this.itemName = name;
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
	public long getItemID() {
		return itemID;
	}
	public void setItemID(long itemID) {
		this.itemID = itemID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof AbstractItem)) return false;
		AbstractItem other = (AbstractItem) obj;
		if(id != other.id) return false;

		return true;
	}
	
	@Override
	public String toString() {
		return "Item: " + itemName + " ID: " + id + " Description: " + description;
	}

}