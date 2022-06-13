package com.bayzdelivery.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

import com.bayzdelivery.service.PersonServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {

  MockMvc mockMvc;

  @Mock
  private PersonController personController;
  
  @Mock
  private PersonServiceImpl personService;

  @Before
  public void setup() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
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
  public void testPersonRegister() throws Exception { 
	  when(personService.checkValidRegistration(ArgumentMatchers.any())).thenReturn(true);
	  MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/person");
	  
	  assertEquals(200, getFinalStatus(requestBuilder));
  }
  
  @Test
  public void testPersonRegisterNotEligible() throws Exception { 
	  when(personService.checkValidRegistration(ArgumentMatchers.any())).thenReturn(false);
	  MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/person");
	  
	  assertEquals(400, getFinalStatus(requestBuilder));
  }
  
  @Test
  public void testGetAllPersons() throws Exception { 
	  when(personService.checkValidRegistration(ArgumentMatchers.any())).thenReturn(false);
	  MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/person");
	  
	  assertEquals(200, getFinalStatus(requestBuilder));
  }

}
