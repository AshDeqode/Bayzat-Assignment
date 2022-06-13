package com.bayzdelivery.repositories;

import com.bayzdelivery.model.Delivery;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
	
	@Query(value = "select * from delivery\n"
			+ "where start_time > :startTime and end_time < :endTime\n"
			+ "GROUP BY delivery_man_id\n"
			+ "order by max(price) desc limit 3", nativeQuery = true)
	List<Delivery> findHighestDeliveryPersons(@Param("startTime") String startTime, 
			@Param("endTime") String endTime);
	
	@Query(value = "select avg(comission) from delivery\n"
			+ "where start_time > :startTime and end_time < :endTime\n"
			+ "and delivery_man_id = :id", nativeQuery = true)
	Long findAvgComission(@Param("startTime") String startTime, 
			@Param("endTime") String endTime,
			@Param("id") Long id);

}
