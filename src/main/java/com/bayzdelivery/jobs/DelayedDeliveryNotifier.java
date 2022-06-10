	package com.bayzdelivery.jobs;

import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.repositories.DelayedDeliveryRepository;
import java.time.Instant;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DelayedDeliveryNotifier {
	
	@Autowired
	DelayedDeliveryRepository delayedDeliveryRepository;
	
    private static final Logger LOG = LoggerFactory.getLogger(DelayedDeliveryNotifier.class);

    /**
     *  Use this method for the TASK 3
     */
    @Scheduled(fixedDelay = 30000)
    public void checkDelayedDeliveries() {
    	
    	//list of delayed deliveries in case it needs to be sent to customer support team
    	List<Delivery> delayedDeliveries = delayedDeliveryRepository.findDelayedDeliveries();
    	
    	for (Delivery delivery : delayedDeliveries) {
			System.out.println(delivery);
		}
    	
    	if(delayedDeliveries.isEmpty() != true) {
    		notifyCustomerSupport();
    	}
    }


    /**
     * This method should be called to notify customer support team
     * It just writes notification on console but it may be email or push notification in real.
     * So that this method should run in an async way.
     */
    @Async
    public void notifyCustomerSupport() {
        LOG.info("Customer support team is notified!");
    }
}