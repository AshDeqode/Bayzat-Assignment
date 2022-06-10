package com.bayzdelivery.service;

import java.util.List;

import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.model.HighestDeliveryPersons;

public interface DeliveryService {

  public Delivery save(Delivery delivery);

  public Delivery findById(Long deliveryId);
  
  public List<HighestDeliveryPersons> findHighestDelivery(String startTime, String endTime);
}