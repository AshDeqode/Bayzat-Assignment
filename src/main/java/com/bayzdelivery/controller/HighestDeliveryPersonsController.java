package com.bayzdelivery.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bayzdelivery.model.HighestDeliveryPersons;
import com.bayzdelivery.service.DeliveryService;

@RestController
public class HighestDeliveryPersonsController {
	
	@Autowired
	DeliveryService deliveryService;
	
	  //method to fetch top 3 delivery persons whose deliveries are highest paid
	  @GetMapping(path = "/api/toppersons/{start-time}/{end-time}")
	  public ResponseEntity<List<HighestDeliveryPersons>> getHighestDeliveryPersons(
			  @PathVariable(name="start-time",required=true)String startTime,
			  @PathVariable(name="end-time", required = true) String endTime){
		  
		  List<HighestDeliveryPersons> highestDeliveryPersons = deliveryService.findHighestDelivery(startTime, endTime);;

		  if (highestDeliveryPersons !=null)
			  return ResponseEntity.ok(highestDeliveryPersons);
		  return ResponseEntity.notFound().build();
	  }
}
