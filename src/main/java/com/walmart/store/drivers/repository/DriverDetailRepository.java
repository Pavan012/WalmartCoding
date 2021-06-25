package com.walmart.store.drivers.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.walmart.store.drivers.entity.DriverDetail;

@Repository
public interface DriverDetailRepository  extends JpaRepository<DriverDetail, String>{


	String FORMULA = "(6371 * acos(cos(radians(:startlat)) * cos(radians(d.latitude)) *" +
	        " cos(radians(d.longitude) - radians(:startlng)) + sin(radians(:startlat)) * sin(radians(d.latitude))))";
	
	String sqlSelectAllPersons = "SELECT *, " + FORMULA + " as distance, latitude   "
			+ "FROM driver_detail d ORDER BY distance ";
	

	@Query(value=sqlSelectAllPersons
			, nativeQuery = true)
	List<DriverDetail> getNearestStore(Double startlat, Double startlng, Pageable pageable);
	
}
