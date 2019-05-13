package com.aaronazon.springmvc.dao;

import java.util.List;

import com.aaronazon.springmvc.entity.Item;

public interface ItemDao {
	Item saveItem(Item item);
	List<Item> findAllItems();
	int deleteItemById(long id);
	Item findById(long id);
	Item findByName(String name);
	Item updateItem(Item item);
}
