package com.shopping.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.model.Item;
import com.shopping.cart.service.ItemService;

@RestController
@RequestMapping("api/item")
public class ItemController {

	private ItemService itemService;

	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@PostMapping(value = "/addItem")
	public ResponseEntity<Item> saveItem(Item item) {
//		return new ResponseEntity<Item>(itemService.saveItem(item), HttpStatus.CREATED);
		return new ResponseEntity<Item>(itemService.saveItem(new Item(1,"Item ", 1)), HttpStatus.CREATED);
	}
}
