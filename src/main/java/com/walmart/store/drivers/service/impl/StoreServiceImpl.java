package com.walmart.store.drivers.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.store.drivers.dto.StoreRequestDTO;
import com.walmart.store.drivers.entity.StoreDetail;
import com.walmart.store.drivers.repository.StoreDetailRepository;
import com.walmart.store.drivers.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreDetailRepository storeDetailRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public StoreDetail saveStoreInfo(final StoreRequestDTO storeRequestDTO) {
		StoreDetail storeDetail=modelMapper.map(storeRequestDTO, StoreDetail.class);
		return storeDetailRepository.save(storeDetail);
	}
}
