package com.walmart.store.drivers.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.store.drivers.entity.DriverDetail;
import com.walmart.store.drivers.service.DriverService;

@Component
public class DriverDetailsKafkaConsumer {
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Autowired
	private ObjectMapper mapper;
	private final Logger logger = LoggerFactory.getLogger(DriverDetailsKafkaConsumer.class);
	
	@Autowired
	private DriverService driverService;
	
	@KafkaListener(topics = "#{@environment.getProperty('kafka.topic.driver')}", groupId = "#{@environment.getProperty('kafka.consumer.driver.group')}")
	public void listenGroupFoo(String message) {
	    System.out.println("Received Message in group foo: " + message);
		try {
			DriverDetail driverDetail=mapper.readValue(message, DriverDetail.class);
			driverService.saveDriverDetails(driverDetail);
		} catch (IOException ex) {
			logger.error("Error while converting Input to Type DriverDetailsDTO : ".concat(ex.getMessage()));
		}

	}
	
}
