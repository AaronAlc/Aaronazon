package com.aaronazon.springmvc.service;

import java.util.List;

import com.aaronazon.springmvc.dto.ItemDTO;
import com.aaronazon.springmvc.model.Item;

public interface ItemService {
	ItemDTO findById(long id);

	ItemDTO findByName(String name);

	ItemDTO saveItem(ItemDTO item);

	ItemDTO updateItem(ItemDTO item);

	boolean deleteItemById(long id);

	List<ItemDTO> findAllItems();

	boolean isItemExist(ItemDTO item);

	ItemDTO convertItemModelToItemDTO(Item item);

	Item convertItemDTOToItemModel(ItemDTO itemDTO);

}
