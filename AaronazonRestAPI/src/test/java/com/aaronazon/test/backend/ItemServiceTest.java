package com.aaronazon.test.backend;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aaronazon.springmvc.dao.ItemDao;
import com.aaronazon.springmvc.entity.Item;
import com.aaronazon.springmvc.service.ItemServiceImpl;
import com.aaronazon.springmvc.view.ItemView;

@Profile("test")
@Configuration
public class ItemServiceTest {

	@Mock
	private ItemDao itemDAO;

	@InjectMocks
	private ItemServiceImpl itemService;

	private ArrayList<ItemView> itemList = new ArrayList<ItemView>();

	@BeforeClass
	public void init() throws Exception {
		MockitoAnnotations.initMocks(this);
		itemList.add(new ItemView(1L, "Heartsbane", "The sword of House Tarly", "items/default.png"));
		itemList.add(new ItemView(2L, "Longclaw", "Owner knows nothing", "items/default.png"));
		itemList.add(new ItemView(3L, "Oathkeeper", "Former sword of a kingslayer", "items/default.png"));
	}

	@Test
	public void findItemById_ReturnsItem() throws Exception {
		ItemView itemView = itemList.get(0);
		Item item = new Item(itemView);
		Mockito.when(itemDAO.findById(itemView.getId())).thenReturn(item);
		Assert.assertTrue(new ReflectionEquals(itemService.findById(itemView.getId())).matches(itemView));
	}

	@Test
	public void findItemById_ReturnsNull() throws Exception {
		long invalidLong = 20L;
		Mockito.when(itemDAO.findById(invalidLong)).thenReturn(null);
		Assert.assertNull(itemService.findById(invalidLong));
	}

	@Test
	public void findItemByName_ReturnsItem() throws Exception {
		ItemView itemView = itemList.get(1);
		Item item = new Item(itemView);
		Mockito.when(itemDAO.findByName(itemView.getItemName())).thenReturn(item);
		Assert.assertEquals(itemView.getId(), itemService.findByName(itemView.getItemName()).getId());
	}

	@Test
	public void findItemByName_ReturnsNull() throws Exception {
		String invalidString = "Will not find an item";
		Mockito.when(itemDAO.findByName(invalidString)).thenReturn(null);
		Assert.assertNull(itemService.findByName(invalidString));
	}

	@Test
	public void saveItem_ReturnsItem() throws Exception {
		ItemView itemView = itemList.get(2);
		Item item = new Item(itemView);
		Mockito.when(itemDAO.saveItem(Mockito.any(Item.class))).thenReturn(item);
		Assert.assertTrue(new ReflectionEquals(itemService.saveItem(itemView)).matches(itemView));
	}

	@Test
	public void saveItem_ReturnsNull() throws Exception {
		ItemView itemView = null;
		Mockito.when(itemDAO.saveItem(Mockito.any(Item.class))).thenReturn(null);
		Assert.assertNull(itemService.saveItem(itemView));
	}

	@Test
	public void updateItem_ReturnsItem() throws Exception {
		ItemView itemView = itemList.get(0);
		Item item = new Item(itemView);
		Mockito.when(itemDAO.updateItem(item)).thenReturn(item);
		Assert.assertTrue(new ReflectionEquals(itemService.updateItem(itemView)).matches(itemView));
	}

	@Test
	public void updateItem_ReturnsNull() throws Exception {
		ItemView itemView = null;
		Mockito.when(itemDAO.updateItem(Mockito.any(Item.class))).thenReturn(null);
		Assert.assertNull(itemService.updateItem(itemView));
	}

	@Test
	public void deleteItemById_ReturnsTrue() throws Exception {
		long good_id = 1L;
		//1 means only 1 line affected in database
		int result = 1;
		Mockito.when(itemDAO.deleteItemById(good_id)).thenReturn(result);
		Assert.assertTrue(itemService.deleteItemById(good_id));
	}

	@Test
	public void deleteItemById_ReturnsFalse() throws Exception {
		long bad_id = 11L;
		int result = 0;
		Mockito.when(itemDAO.deleteItemById(bad_id)).thenReturn(result);
		Assert.assertFalse(itemService.deleteItemById(bad_id));
	}

	@Test
	public void findAllItems_ReturnsList() throws Exception {
		List<Item> iList = convertItemTypeList(itemList);
		Mockito.when(itemDAO.findAllItems()).thenReturn(iList);
		Assert.assertTrue(new ReflectionEquals(itemService.findAllItems()).matches(itemList));
	}

	@Test
	public void findAllItems_ReturnsEmptyList() throws Exception {
		List<Item> itemList = new ArrayList<Item>();
		Mockito.when(itemDAO.findAllItems()).thenReturn(itemList);
		Assert.assertEquals(true, itemService.findAllItems().isEmpty());
	}

	@Test
	public void isItemExist_ReturnsTrue() {
		ItemView itemView = itemList.get(1);
		Assert.assertEquals(true, itemService.isItemExist(itemView));
	}

	@Test
	public void isItemExist_ReturnsFalse() {
		ItemView itemView = itemList.get(0);
		Mockito.when(itemDAO.findByName(itemView.getItemName())).thenReturn(null);
		Assert.assertEquals(false, itemService.isItemExist(itemView));
	}
	
	private static List<Item> convertItemTypeList(List<ItemView> itemViewList) {
		List<Item> iList = new ArrayList<Item>();
		for (ItemView iView: itemViewList ) {
			iList.add(new Item(iView));
		}
		return iList;
	}

}