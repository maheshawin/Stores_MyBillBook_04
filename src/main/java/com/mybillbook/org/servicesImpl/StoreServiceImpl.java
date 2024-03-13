package com.mybillbook.org.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybillbook.org.entities.Store;
import com.mybillbook.org.exceptions.StoreNotFoundException;
import com.mybillbook.org.repositories.StoreRepository;
import com.mybillbook.org.services.StoreService;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	StoreRepository storeRepository;	
	
	@Override
	public String createStore(Store store) {
		storeRepository.save(store);
		return "Store Details Saved";
	}

	@Override
	public String updateStore(Store store) throws StoreNotFoundException {
		Store store1 = getStoreById(store.getStoreId());
		store1.setStoreName(store.getStoreName());
		store1.setStoreType(store.getStoreType());
		store1.setAddress(store.getAddress());
		store1.setGstNo(store.getGstNo());
		
		storeRepository.save(store1);
		return "Store Updated Successfully";
	}

	@Override
	public String deleteStore(long storeId) {
		storeRepository.deleteById(storeId);
		return "Store Deleted";
	}

	@Override
	public Store getStoreById(long storeId) throws StoreNotFoundException {
		
		return storeRepository.findById(storeId).orElseThrow(()->new StoreNotFoundException("Store id not found"));
	}

	@Override
	public List<Store> getAllStores() {
		
		return storeRepository.findAll();
	}

	@Override
	public Store getStoreByUserId(String userId) throws StoreNotFoundException {
		
		return storeRepository.findByUserId(userId);
	}

	

}