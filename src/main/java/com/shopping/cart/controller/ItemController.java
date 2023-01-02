package com.shopping.cart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.model.Item;
import com.shopping.cart.service.ItemService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/item")
public class ItemController {

	private ItemService itemService;

	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@PostMapping(value = "/addItem")
	public ResponseEntity<Item> saveItem(@RequestBody Item item) {
		return new ResponseEntity<Item>(itemService.saveItem(item), HttpStatus.CREATED);
	}

	@GetMapping(value = "/item")
	public List<Item> getAllItem() {
		return itemService.getAllItem();
	}

	@GetMapping(value = "/item/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable("id") long id) {
		return new ResponseEntity<Item>(itemService.getItemByID(id), HttpStatus.OK);
	}

	@PutMapping(value = "/editItem/{id}")
	public ResponseEntity<Item> editItem(@RequestBody Item item, @PathVariable("id") long id) {
		return new ResponseEntity<Item>(itemService.updateItem(item, id), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/item/{id}")
	public ResponseEntity<String> deleteItemById(@PathVariable("id") long id) {
		return new ResponseEntity<String>("Item Deleted Successfully", HttpStatus.OK);
	}
}
