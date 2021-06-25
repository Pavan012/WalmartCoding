package com.walmart.store.drivers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreRequestDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String storeID;
	private Double latitude;
	private Double longitude;

}
