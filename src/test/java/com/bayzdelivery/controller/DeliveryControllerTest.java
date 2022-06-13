package com.bayzdelivery.controller;

import com.bayzdelivery.service.DeliveryServiceImpl;
import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DeliveryControllerTest {

  MockMvc mockMvc;

  @Mock
  private DeliveryController deliveryController;
  
  @Mock
  private DeliveryServiceImpl deliveryService;

  @Before
  public void setup() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(deliveryController).build();
  }
  
  //method to get response status from MockHttpServletRequestBuilder
  public int getFinalStatus(MockHttpServletRequestBuilder requestBuilder) throws Exception {
	  ResultActions perform = mockMvc.perform(requestBuilder);
	  
	  MvcResult mvcResult = perform.andReturn();
	  MockHttpServletResponse response = mvcResult.getResponse();
	  int status = response.getStatus();
	  
	  return status;
  }
  
  @Test
  public void testCreateNewDelivery() throws Exception { 
	  Delivery d = new Delivery();
	  Person p1 = new Person();
	  Person p2 = new Person();
	  
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

	  when(deliveryService.save(ArgumentMatchers.any())).thenReturn(d);
	  MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/delivery");
	  
	  assertEquals(200, getFinalStatus(requestBuilder));
  }

}
