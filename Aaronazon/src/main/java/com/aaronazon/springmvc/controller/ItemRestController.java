package com.aaronazon.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aaronazon.springmvc.model.Item;
import com.aaronazon.springmvc.service.ItemService;

@RestController
@RequestMapping("/item/")
public class ItemRestController {

	@Autowired
	ItemService itemService;

	//get all items
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Item>> listAllItems(){
		List<Item> items = itemService.findAllItems();
		if(items.isEmpty()) {
			return new ResponseEntity<List<Item>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	
	//get a single item
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Item>  getItem(@PathVariable("id") long id){
			Item item = itemService.findById(id);
			if(item == null) {
				return new ResponseEntity<Item>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Item>(item, HttpStatus.OK);
		}

	//create an item 
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Item> createItem(@RequestBody Item item){
		if(itemService.isItemExist(item)) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		itemService.saveItem(item);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}
	
	//update an item 
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Item> updateItem(@PathVariable("id") long id, @RequestBody Item item){
		Item currentItem = itemService.findById(id);
		if(currentItem == null) {
			return new ResponseEntity<Item>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		currentItem.setItemName(item.getItemName());
		currentItem.setDescription(item.getDescription());
		currentItem.setItemType(item.getItemType());
		
		itemService.updateItem(currentItem);
		
		return new ResponseEntity<Item>(currentItem, HttpStatus.OK);
	}
	
	//delete an item
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Item> deleteItem(@PathVariable("id") long id){
		Item item = itemService.findById(id);
		if(item == null) {
			return new ResponseEntity<Item>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		itemService.deleteItemById(id);
		return new ResponseEntity<Item>(HttpStatus.OK);
	}
}
