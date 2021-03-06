package com.aaronazon.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aaronazon.springmvc.view.ItemView;

@Entity
@Table(name="item")
public class Item{

	/**
	 * 
	 */
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	
	@Column(name="item_name")
	private String itemName;

	@Column(name="description")
	private String description;

	@Column(name="image_loc")
	private String imageLoc;

	public Item() {}

	/**
	 * @param id 
	 * @param itemName
	 * @param description
	 */
	public Item(long id, String itemName, String description, String imageLoc) {
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.imageLoc = imageLoc;
	}
	
	public Item(ItemView itemView) {
		this.id = itemView.getId();
		this.itemName = itemView.getItemName();
		this.description = itemView.getDescription();
		this.imageLoc = itemView.getImageLoc();
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
