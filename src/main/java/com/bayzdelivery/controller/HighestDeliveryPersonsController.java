package com.bayzdelivery.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.model.HighestDeliveryPersons;
import com.bayzdelivery.model.Person;
import com.bayzdelivery.service.DeliveryService;
import com.bayzdelivery.service.PersonService;

@RestController
public class HighestDeliveryPersonsController {
	@Autowired
	PersonService personService;
	
	@Autowired
	DeliveryService deliveryService;
	
	  @GetMapping(path = "/api/toppersons/{start-time}/{end-time}")
	  public ResponseEntity<List<HighestDeliveryPersons>> getHighestDeliveryPersons(@PathVariable(name="start-time",required=true)String startTime,
			  @PathVariable(name="end-time", required = true) String endTime){
		  List<HighestDeliveryPersons> highestDeliveryPersons = deliveryService.findHighestDelivery(startTime, endTime);;

	    if (highestDeliveryPersons !=null)
	      return ResponseEntity.ok(highestDeliveryPersons);
	    return ResponseEntity.notFound().build();
	  }
}
