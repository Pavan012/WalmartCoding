package com.walmart.store.drivers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.store.drivers.dto.DriverDetailsDTO;
import com.walmart.store.drivers.entity.DriverDetail;
import com.walmart.store.drivers.service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	@Autowired 
	private DriverService driverService;
	
	@GetMapping("nearest")
	public List<DriverDetail> getNearestNDrivers(@RequestParam("storeId") String storeId, 
			@RequestParam("N") Integer numberOfDrivers) throws Exception {
		return driverService.getNearestNDrivers(storeId, numberOfDrivers);
	}
	
	@PostMapping("/publish")
	public void publishToKafka(@RequestBody DriverDetailsDTO driverDetailsDTO) {
		driverService.publishToKafka(driverDetailsDTO);
	}
}
