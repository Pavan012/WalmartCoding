package com.walmart.store.drivers.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.store.drivers.dto.DriverDetailsDTO;
import com.walmart.store.drivers.service.DriverService;

@RunWith(MockitoJUnitRunner.class)
public class DriverControllerTest {

	private MockMvc mockMvc;
	@InjectMocks
	private DriverController driverController;
	@Mock
	private DriverService driverService;

	private DriverDetailsDTO driverDetailsDTO;

	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(driverController)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).build();

		driverDetailsDTO = new DriverDetailsDTO("1", 1.2, 2.4);
	}


	@Test
	public void testGetNearestNDrivers() throws Exception {
		String driverDetail = mapper.writeValueAsString(driverDetailsDTO);
		this.mockMvc.perform(get("/drivers/nearest").contentType(MediaType.APPLICATION_JSON)
				.queryParam("storeId", "1")
				.queryParam("N", "1"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testPublishToKafka() throws Exception {
		String driverDetail = mapper.writeValueAsString(driverDetailsDTO);
		this.mockMvc.perform(post("/drivers/publish").contentType(MediaType.APPLICATION_JSON).content(driverDetail))
				.andExpect(status().isOk());
	}

}
