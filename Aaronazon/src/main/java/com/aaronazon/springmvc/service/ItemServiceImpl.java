package com.aaronazon.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaronazon.springmvc.dao.ItemDao;
import com.aaronazon.springmvc.model.Item;

@Service("ItemService")
@Transactional
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;

	public Item findById(long id) {
		return itemDao.findById(id);
	}
	public Item findByName(String name) {
		return itemDao.findByName(name);
	}
	public void saveItem(Item item) {
		itemDao.saveItem(item);
	}
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}

	public void deleteItemById(long id) {
		itemDao.deleteItemById(id);
	}
	public List<Item> findAllItems() {
		return itemDao.findAllItems();
	}

	public boolean isItemExist(Item item) {
		return (itemDao.findByName(item.getItemName()) != null);
	}
	
}