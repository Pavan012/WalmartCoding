package com.walmart.store.drivers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="store_detail")
@Table(name = "store_detail", schema="public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDetail implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String storeID;
	
	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;
}
