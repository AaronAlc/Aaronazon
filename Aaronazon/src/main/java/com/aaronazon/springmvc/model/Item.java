package com.aaronazon.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	
	@Column(name="item_name")
	private String itemName;

	@Column(name="description")
	private String description;

	//@Embedded
	//private ItemType itemType;

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
	
	public Item(long id, String itemName, String description) {
		this.id = id;
		this.itemName = itemName;
		this.description = description;
	}

	/**
	public Item(long id, String itemName, String description, ItemType itemType) {
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.itemType = itemType;
	}
	*/
	
	/*
	public ItemType getItemType() {
		return this.itemType;
	}
	
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	*/

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
		return "ItemName: " + this.itemName + " ID: " + this.id +
				" Description: " + this.description;
	}
	
}
