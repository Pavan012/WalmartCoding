package com.walmart.store.drivers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DriverDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String driverID;
	private Double latitude;
	private Double longitude;
}
