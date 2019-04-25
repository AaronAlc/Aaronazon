package com.aaronazon.springmvc.dto;

public class ItemDTO {
	private long id;
	private String itemName;
	private String description;
	private String imageLoc;

	public ItemDTO() {
	}

	public ItemDTO(long id, String itemName, String description, String imageLoc) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.imageLoc = imageLoc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(String imageLoc) {
		this.imageLoc = imageLoc;
	}

}
