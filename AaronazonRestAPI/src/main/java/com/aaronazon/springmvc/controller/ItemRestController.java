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

import com.aaronazon.springmvc.dto.ItemDTO;
import com.aaronazon.springmvc.service.ItemService;

@RestController
@RequestMapping("item")
public class ItemRestController {

	@Autowired
	private ItemService itemService;

	/**
	 * get all items
	*/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItemDTO>> listAllItems(){
		List<ItemDTO> itemDTOs = itemService.findAllItems();
		if(itemDTOs.isEmpty()) {
			return new ResponseEntity<List<ItemDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ItemDTO>>(itemDTOs, HttpStatus.OK);
	}
	
	/**
	 * get a single item
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<ItemDTO>  getItem(@PathVariable("id") long id){
		ItemDTO itemDTO = itemService.findById(id);
		if(itemDTO == null) {
			return new ResponseEntity<ItemDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ItemDTO>(itemDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public ResponseEntity<ItemDTO> getItem(@PathVariable("name") String name){
		ItemDTO itemDTO = itemService.findByName(name);
		if(itemDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(itemDTO, HttpStatus.OK);
	}

	/**
	 * create an item
	 */
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO){
		ItemDTO currentItem= itemService.saveItem(itemDTO);
		if(currentItem== null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(currentItem, HttpStatus.CREATED);
	}
	
	/**
	 * update an itemDTO 
	 */
	@RequestMapping(value = "{id}", method=RequestMethod.PUT)
	public ResponseEntity<ItemDTO> updateItem(@PathVariable("id") long id, @RequestBody ItemDTO itemDTO){
		ItemDTO currentItemDTO = itemService.updateItem(itemDTO);
		if(currentItemDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(currentItemDTO, HttpStatus.OK);
	}
	
	/**
	 * delete an itemDTO
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteItemDTO(@PathVariable("id") long id){
		boolean isDeleted = itemService.deleteItemById(id);
		if(!isDeleted) {
			return new ResponseEntity<>(isDeleted, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(isDeleted, HttpStatus.OK);
	}
}