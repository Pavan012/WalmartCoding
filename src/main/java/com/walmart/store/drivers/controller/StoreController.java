package com.walmart.store.drivers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.store.drivers.dto.StoreRequestDTO;
import com.walmart.store.drivers.entity.StoreDetail;
import com.walmart.store.drivers.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@PostMapping
	public StoreDetail saveStoreInfo(@RequestBody StoreRequestDTO storeRequestDTO) {
		return storeService.saveStoreInfo(storeRequestDTO);
	}

}
