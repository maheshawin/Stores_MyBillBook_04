package com.mybillbook.org.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybillbook.org.entities.Store;
import com.mybillbook.org.exceptions.StoreNotFoundException;
import com.mybillbook.org.services.StoreService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = {"${app.security.cors.origin}"})
@RestController
@RequestMapping("/stores")
@Slf4j
@Tag(name ="Store Management Service", description = "Store Info")
public class StoreController {

	
	@Autowired
	StoreService storeService;
	
	
	@PostMapping("/save")
	public String saveStore(@RequestBody Store store) {
		log.info("inside saveStore");
		return storeService.createStore(store);
	}
	
	
	@PostMapping("/delete")
	public String deleteStore(@RequestBody long storeId) {
		log.info("inside deleteStore");
		return storeService.deleteStore(storeId);
	}

	@PostMapping("/update")
	public String updateStore(@RequestBody Store store) throws StoreNotFoundException{
		log.info("inside updateStore");
		return storeService.updateStore(store);
	}
	
	@GetMapping("/s/{storeId}")
	public Store getStoreByStoreId(@PathVariable("storeId") long storeId) throws StoreNotFoundException {
		log.info("inside getStoreByStoreId" + storeId);
		return storeService.getStoreById(storeId);
	}

	@GetMapping("/findall")
	public List<Store> findAll() {
		log.info("inside get all stores list");
		return storeService.getAllStores();
	}
	
	@GetMapping("/{userId}")
	public Store getStoreByUserId(@PathVariable("userId") String userId) throws StoreNotFoundException {
		log.info("inside getStoreByStoreId" + userId);
		return storeService.getStoreByUserId(userId);
	}

}
