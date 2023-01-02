package com.shopping.cart.service;

import java.util.List;

import com.shopping.cart.model.Item;

public interface ItemService {
	Item saveItem(Item item);
	
	List<Item> getAllItem();
	
	Item getItemByID(long id);

	Item updateItem(Item item, long id);
	
	void deleteItem(long id);

}
