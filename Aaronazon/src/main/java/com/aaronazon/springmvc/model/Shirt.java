package com.aaronazon.springmvc.model;

@Deprecated
public class Shirt extends AbstractItem{
	
	public enum Size{
		SMALL, MEDIUM, LARGE;
	}

	public Shirt() {
		this.id = 0;
	}
	
	public Shirt(long id, String itemName, String description) {
		System.out.println("My shirt item name is " + itemName);
		this.id = id;
		this.itemName = itemName;
		this.description = description;
	}
}
