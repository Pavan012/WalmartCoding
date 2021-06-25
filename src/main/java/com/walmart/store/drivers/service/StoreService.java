package com.walmart.store.drivers.service;

import com.walmart.store.drivers.dto.StoreRequestDTO;
import com.walmart.store.drivers.entity.StoreDetail;

public interface StoreService {

	 StoreDetail saveStoreInfo(final StoreRequestDTO storeRequestDTO);
}
