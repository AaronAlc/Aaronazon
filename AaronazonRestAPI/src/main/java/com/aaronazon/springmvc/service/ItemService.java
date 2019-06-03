package com.aaronazon.springmvc.service;

import java.util.List;

import com.aaronazon.springmvc.view.ItemView;

public interface ItemService {
	ItemView findById(long id);

	ItemView findByName(String name);

	ItemView saveItem(ItemView itemView);

	ItemView updateItem(ItemView itemView);

	boolean deleteItemById(long id);

	List<ItemView> findAllItems();

	boolean isItemExist(ItemView itemView);

}
