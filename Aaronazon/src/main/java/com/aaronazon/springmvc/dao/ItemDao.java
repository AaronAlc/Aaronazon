package com.aaronazon.springmvc.dao;

import java.util.List;

import com.aaronazon.springmvc.model.Item;

public interface ItemDao {
	void saveItem(Item item);
	List<Item> findAllItems();
	void deleteItemById(long id);
	Item findById(long id);
	Item findByName(String name);
	void updateItem(Item item);
}
