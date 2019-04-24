package com.aaronazon.springmvc.dao;

import java.util.List;

import com.aaronazon.springmvc.model.Item;

public interface ItemDao {
	Item saveItem(Item item);
	List<Item> findAllItems();
	boolean deleteItemById(long id);
	Item findById(long id);
	Item findByName(String name);
	Item updateItem(Item item);
}
