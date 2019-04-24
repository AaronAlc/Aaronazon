package com.aaronazon.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaronazon.springmvc.dao.ItemDao;
import com.aaronazon.springmvc.dto.ItemDTO;
import com.aaronazon.springmvc.model.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	public ItemDTO findById(long id) {
		return convertItemModelToItemDTO(itemDao.findById(id));
	}

	public ItemDTO findByName(String name) {
		return convertItemModelToItemDTO(itemDao.findByName(name));
	}

	public ItemDTO saveItem(ItemDTO itemDTO) {
		return convertItemModelToItemDTO(itemDao.saveItem(convertItemDTOToItemModel(itemDTO)));
	}

	public ItemDTO updateItem(ItemDTO itemDTO) {
		itemDao.updateItem(convertItemDTOToItemModel(itemDTO));
		return itemDTO;
	}

	public boolean deleteItemById(long id) {
		return itemDao.deleteItemById(id);
	}

	public List<ItemDTO> findAllItems() {
		List<Item> itemList = itemDao.findAllItems();

		List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
		for (Item item : itemList) {
			itemDTOList.add(convertItemModelToItemDTO(item));
		}

		return itemDTOList;
	}

	public boolean isItemExist(ItemDTO itemDTO) {
		return findByName(itemDTO.getItemName()) != null;
	}

	public ItemDTO convertItemModelToItemDTO(Item item) {
		if (item == null)
			return null;

		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setId(item.getId());
		itemDTO.setItemName(item.getItemName());
		itemDTO.setDescription(item.getDescription());
		itemDTO.setImageLoc(item.getImageLoc());

		return itemDTO;
	}

	public Item convertItemDTOToItemModel(ItemDTO itemDTO) {
		if (itemDTO == null)
			return null;

		Item item = new Item();
		item.setId(itemDTO.getId());
		item.setItemName(itemDTO.getItemName());
		item.setDescription(itemDTO.getDescription());
		item.setImageLoc(itemDTO.getImageLoc());
		return item;
	}

}