package com.mybillbook.org.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybillbook.org.entities.Store;
import com.mybillbook.org.exceptions.StoreNotFoundException;



@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

	public Store findByUserId(String userId); 
	
	
}
