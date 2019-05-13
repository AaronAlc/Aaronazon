package com.aaronazon.springmvc.entity;

public class ItemType {
	
	private String itemTypeName;
	
	public ItemType() {}
	public ItemType(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public String getItemTypeName() {
		return this.itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	
	@Override
	public String toString() {
		return this.itemTypeName;
	}


}
