package com.aaronazon.springmvc.service;

import java.util.List;

import com.aaronazon.springmvc.model.Item;

public interface ItemService {
	 Item findById(long id);
	 Item findByName(String name);
	 void saveItem(Item item);
	 void updateItem(Item item);
	 void deleteItemById(long id);
	 List<Item> findAllItems();
	 void deleteAllItems();
	 public boolean isItemExist(Item item);

}
