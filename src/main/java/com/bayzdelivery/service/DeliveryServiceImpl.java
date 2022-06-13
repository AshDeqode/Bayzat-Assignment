package com.bayzdelivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bayzdelivery.repositories.DeliveryRepository;
import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.model.HighestDeliveryPersons;
import com.bayzdelivery.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

  @Autowired
  DeliveryRepository deliveryRepository;

  public Delivery save(Delivery delivery) {
    return deliveryRepository.save(delivery);
  }

  public Delivery findById(Long deliveryId) {
    Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
    if (optionalDelivery.isPresent()) {
      return optionalDelivery.get();
    }else return null;
}

  @Override
  public List<HighestDeliveryPersons> findHighestDelivery(String startTime, String endTime) {
	  
	List<Delivery> highestDeliveries = deliveryRepository.
											findHighestDeliveryPersons(startTime, endTime);

	List<HighestDeliveryPersons> topDeliveryPersons = new ArrayList<HighestDeliveryPersons>();
	
	for (Delivery delivery : highestDeliveries) {
		Person deliveryMan = delivery.getDeliveryMan();
		Long avgComission = deliveryRepository.findAvgComission(startTime, endTime, deliveryMan.getId());
		topDeliveryPersons.add(new HighestDeliveryPersons(deliveryMan, avgComission));
	}
	
	return topDeliveryPersons;
  }
}
