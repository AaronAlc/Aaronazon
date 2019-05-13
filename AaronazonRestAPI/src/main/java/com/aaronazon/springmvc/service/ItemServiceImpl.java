package com.aaronazon.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaronazon.springmvc.dao.ItemDao;
import com.aaronazon.springmvc.entity.Item;
import com.aaronazon.springmvc.view.ItemView;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	private static final Logger logger = LogManager.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemDao itemDao;

	public ItemView findById(long id) {
		Item item = itemDao.findById(id);
		if (item == null)
			return null;
		ItemView itemView = convertFromItemToItemView(item);
		return itemView;
	}

	public ItemView findByName(String name) {
		Item item = itemDao.findByName(name);
		if (item == null)
			return null;
		ItemView itemView = convertFromItemToItemView(item);
		return itemView;
	}

	public ItemView saveItem(ItemView itemView) {
		logger.debug("******SAVE ITEM METHOD********");
		Item item = convertFromItemViewToItem(itemView);
		item = itemDao.saveItem(item);
		logger.debug("item: " + item);
		itemView = convertFromItemToItemView(item);
		return itemView;
	}

	public ItemView updateItem(ItemView itemView) {
		Item item = convertFromItemViewToItem(itemView);
		itemDao.updateItem(item);
		itemView = convertFromItemToItemView(item);
		return itemView;
	}

	public boolean deleteItemById(long id) {
		logger.debug("**DEBUGING DELETE BY ID**");
		int result = itemDao.deleteItemById(id);
		logger.debug("Result from DAO" + result);
		return result == 1;
	}

	public List<ItemView> findAllItems() {
		List<Item> itemList = itemDao.findAllItems();
		List<ItemView> itemViewList = new ArrayList<ItemView>();
		for (Item item : itemList) {
			itemViewList.add(new ItemView(item.getId(), item.getItemName(), item.getDescription(), item.getImageLoc()));
		}
		return itemViewList;
	}

	public boolean isItemExist(ItemView itemView) {

		return findByName(itemView.getItemName()) != null;
	}

	private Item convertFromItemViewToItem(ItemView itemView) {
		if(itemView == null)
			return null;
		Item item = new Item(itemView.getId(), itemView.getItemName(), itemView.getDescription(),
				itemView.getImageLoc());
		return item;
	}

	private ItemView convertFromItemToItemView(Item item) {
		if(item == null)
			return null;
		ItemView iView = new ItemView(item.getId(), item.getItemName(), item.getDescription(), item.getImageLoc());
		return iView;
	}
}
