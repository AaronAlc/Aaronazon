package com.aaronazon.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.aaronazon.springmvc.model.Item;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {
	private static final AtomicLong counter = new AtomicLong();
	private static List<Item> items;
	
	static {
		items = testData();
	}
	
	public Item findById(long id) {
		for(Item item: items) {
			if(item.getId() == id) return item;
		}
		return null;
	}
	public Item findByName(String name) {
		for(Item item: items) {
			if(item.getItemName().equalsIgnoreCase(name)) return item;
		}
		return null;
	}
	public void saveItem(Item item) {
		item.setId(counter.incrementAndGet());
		items.add(item);
	}
	public void updateItem(Item item) {
		int index = items.indexOf(item);
		items.set(index, item);
	}

	public void deleteItemById(long id) {
		for(int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if(item.getId() == id) items.remove(i);
		}
	}
	public List<Item> findAllItems() {
		return items;
	}
	public void deleteAllItems() {
		items.clear();
	}
	public boolean isItemExist(Item item) {
		return ((Item)findByName(item.getItemName()) != null);
	}
	
	private static List<Item> testData(){
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(counter.incrementAndGet(), "BBQ SHIRT", "This is the item I BBQ in","Shirt"));
		items.add(new Item(counter.incrementAndGet(), "Lego SHIRT", "I play with legos in this shirt", "Socks"));
		items.add(new Item(counter.incrementAndGet(), "Dancing SHIRT", "This is the shirt I dance in", "Pants"));
		return items;
	}

}