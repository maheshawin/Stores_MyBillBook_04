package com.mybillbook.org.services;

import java.util.List;

import com.mybillbook.org.entities.Store;
import com.mybillbook.org.exceptions.StoreNotFoundException;

public interface StoreService {

	String createStore(Store store);

	String updateStore(Store store)throws StoreNotFoundException;

	String deleteStore(long userId);

	Store getStoreById(long StoreId)throws StoreNotFoundException;

	List<Store> getAllStores();
	
	Store getStoreByUserId(String userId)throws StoreNotFoundException;
	
	
}
