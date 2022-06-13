package com.bayzdelivery.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.model.Person;
import com.bayzdelivery.repositories.DelayedDeliveryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class DelayedDeliveryRepositoryTest {

  MockMvc mockMvc;
  
  @Mock
  private DelayedDeliveryRepository deliveryRepo;

  @Before
  public void setup() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(deliveryRepo).build();
  }
  
  @Test
  public void testFindDelayedDeliveries() { 
	  Delivery d = new Delivery();
	  Person p1 = new Person();
	  Person p2 = new Person();
	  List<Delivery> dList = new ArrayList<Delivery>();
	  
	  p1.setId(Long.valueOf(1));
	  p1.setName("Ashish");
	  p1.setEmail("asiwal@gmail.com");
	  p1.setRegistrationNumber("123rr");
	  p1.setIsCustomer("no");
	  p1.setIsDeliveryMan("yes");
	  
	  p2.setId(Long.valueOf(2));
	  p2.setName("Kaushal");
	  p2.setEmail("kausahl@gmail.com");
	  p2.setRegistrationNumber("899bu");
	  p2.setIsCustomer("yes");
	  p2.setIsDeliveryMan("no");
	  
	  d.setStartTime(Instant.now());
	  d.setEndTime(Instant.now());
	  d.setDistance(Long.valueOf(3));
	  d.setPrice(Long.valueOf(13));
	  d.setComission(Long.valueOf(2));
	  d.setDeliveryMan(p1);
	  d.setCustomer(p2);
	  
	  dList.add(d);
	  when(deliveryRepo.findDelayedDeliveries()).thenReturn(dList);
	  
	  assertEquals(deliveryRepo.findDelayedDeliveries(), dList);
  }

}
