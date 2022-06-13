package com.bayzdelivery.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.bayzdelivery.model.Delivery;

@RestResource(exported = false)
public interface DelayedDeliveryRepository extends CrudRepository<Delivery, Long> {
	
	@Query(value = "select * from delivery where "
			+ "TIMESTAMPDIFF(MINUTE,start_time,end_time) > 45", nativeQuery = true)
	List<Delivery> findDelayedDeliveries();
}
