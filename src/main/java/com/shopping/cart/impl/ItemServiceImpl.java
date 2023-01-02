package com.shopping.cart.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shopping.cart.exception.ResourceNotFoundException;
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

	@Override
	public List<Item> getAllItem() {
		return this.itemRepository.findAll();
	}

	@Override
	public Item getItemByID(long id) {
		Optional<Item> item = this.itemRepository.findById(id);
		if (item.isPresent()) {
			return item.get();
		} else {
			throw new ResourceNotFoundException("Employee", "id", item);
		}

	}

	@Override
	public Item updateItem(Item item, long id) {
		Optional<Item> tempItem = this.itemRepository.findById(id);

		if (tempItem.isPresent()) {
			Item existItem = tempItem.get();
			existItem.setItemName(item.getItemName());
			existItem.setCount(item.getCount());

			this.itemRepository.save(existItem);
			return existItem;
		} else {
			throw new ResourceNotFoundException("Employee", "id", item);
		}
	}

	@Override
	public void deleteItem(long id) {
		Optional<Item> tempItem = this.itemRepository.findById(id);
		if (tempItem.isPresent()) {
			this.itemRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Employee", "id", id);
		}
	}

}
