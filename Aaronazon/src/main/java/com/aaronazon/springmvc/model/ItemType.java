package com.aaronazon.springmvc.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ItemType {
	
	SHIRT("Shirt"),
	PANTS("Pants"),
	SOCKS("Socks");

	private String itemTypeName;
	private ItemType itemType;
	
	private static final HashMap<String, ItemType> itemTypeMap = (HashMap<String, ItemType>) Arrays
		.stream(ItemType.values()).collect(Collectors
		.toMap(ItemType::getItemTypeName, Function.identity()));
	
	private ItemType() {}
	private ItemType(String name) {
	}
	
	public String getItemTypeName() {
		return this.itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		if(itemTypeMap.containsKey(itemTypeName)) {
			this.itemTypeName = itemTypeName;
			this.itemType = itemTypeMap.get(itemTypeName);
		}
	}
	
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	
	public ItemType getItemType() {
		return this.itemType;
	}
	
	@Override
	public String toString() {
		return this.itemTypeName;
	}
}
