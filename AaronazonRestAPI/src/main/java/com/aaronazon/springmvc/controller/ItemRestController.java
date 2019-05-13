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

import com.aaronazon.springmvc.service.ItemService;
import com.aaronazon.springmvc.view.ItemView;

@RestController
@RequestMapping("item")
public class ItemRestController {

	@Autowired
	private ItemService itemService;

	/**
	 * get all items
	*/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItemView>> listAllItems(){
		List<ItemView> items = itemService.findAllItems();
		if(items.isEmpty()) {
			return new ResponseEntity<List<ItemView>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ItemView>>(items, HttpStatus.OK);
	}
	
	/**
	 * get a single item
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<ItemView> getItemById(@PathVariable("id") long id){
		ItemView iView = itemService.findById(id);
		return new ResponseEntity<>(iView, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public ResponseEntity<ItemView> getItemByName(@PathVariable("name") String name){
		ItemView iView = itemService.findByName(name);
		return new ResponseEntity<>(iView, HttpStatus.OK);
	}

	/**
	 * create an item
	 */
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<ItemView> createItem(@RequestBody ItemView iView){
		if(itemService.isItemExist(iView)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		ItemView currentItem = itemService.saveItem(iView);
		return new ResponseEntity<>(currentItem, HttpStatus.CREATED);
	}
	
	/**
	 * update an item 
	 */
	@RequestMapping(value = "{id}", method=RequestMethod.PUT)
	public ResponseEntity<ItemView> updateItem(@PathVariable("id") long id, @RequestBody ItemView iView){
		ItemView currentItem = itemService.updateItem(iView);
		return new ResponseEntity<>(currentItem, HttpStatus.OK);
	}
	
	/**
	 * delete an item
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteItem(@PathVariable("id") long id){
		boolean isDeleted = itemService.deleteItemById(id);
		return new ResponseEntity<>(isDeleted, HttpStatus.OK);
	}
}