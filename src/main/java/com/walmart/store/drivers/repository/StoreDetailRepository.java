package com.walmart.store.drivers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walmart.store.drivers.entity.StoreDetail;

@Repository
public interface StoreDetailRepository extends JpaRepository<StoreDetail, String>{
}
