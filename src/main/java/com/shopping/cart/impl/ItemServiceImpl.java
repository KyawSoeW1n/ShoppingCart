package com.shopping.cart.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.model.Item;
import com.shopping.cart.repository.ItemRepository;

import com.shopping.cart.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	private ItemRepository itemRepository;

	public ItemServiceImpl(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}

	@Override
	public Item saveItem(Item item) {
		return this.itemRepository.save(item);
	}
	
	

}
