package com.walmart.store.drivers.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walmart.store.drivers.dto.DriverDetailsDTO;
import com.walmart.store.drivers.entity.DriverDetail;

@Service
public interface DriverService {

	 void publishToKafka(final DriverDetailsDTO driverDetailsDTO);
	 List<DriverDetail> getNearestNDrivers(final String storeId, final Integer numberOfDrivers) throws Exception;
	void saveDriverDetails(DriverDetail driverDetail);
}
