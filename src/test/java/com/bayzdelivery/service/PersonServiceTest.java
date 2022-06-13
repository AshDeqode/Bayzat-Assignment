package com.bayzdelivery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bayzdelivery.model.Person;
import com.bayzdelivery.repositories.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {

  MockMvc mockMvc;
  
  @Mock
  private PersonServiceImpl personService;

  @Autowired
  PersonRepository personRepository;

  @Before
  public void setup() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(personService).build();
  }
  
  @Test
  public void testGetAll() throws Exception { 
	  Person p1 = new Person();
	  p1.setId(Long.valueOf(1));
	  p1.setName("Ashish");
	  p1.setEmail("asiwal@gmail.com");
	  p1.setRegistrationNumber("123rr");
	  p1.setIsCustomer("yes");
	  p1.setIsDeliveryMan("no");
	  
	  Person p2 = new Person();
	  p2.setId(Long.valueOf(2));
	  p2.setName("Kaushal");
	  p2.setEmail("kausahl@gmail.com");
	  p2.setRegistrationNumber("899bu");
	  p2.setIsCustomer("yes");
	  p2.setIsDeliveryMan("no");
	  
	  List<Person> listPerson = new ArrayList<Person>();
	  listPerson.add(p2);
	  listPerson.add(p1);
	  when(personRepository.findAll()).thenReturn(listPerson);
	  
	  assertEquals(personService.getAll(), listPerson);
  }
  
  @Test
  public void testCheckValidRegistrationTrueCase() throws Exception { 
	  Person p1 = new Person();
	  p1.setId(Long.valueOf(1));
	  p1.setName("Ashish");
	  p1.setEmail("asiwal@gmail.com");
	  p1.setRegistrationNumber("123rr");
	  p1.setIsCustomer("yes");
	  p1.setIsDeliveryMan("no");
	  
	  assertEquals(personService.checkValidRegistration(p1), true);
  }
  
  @Test
  public void testCheckValidRegistrationFalseCase() throws Exception { 
	  Person p1 = new Person();
	  p1.setId(Long.valueOf(1));
	  p1.setName("Ashish");
	  p1.setEmail("asiwal@gmail.com");
	  p1.setRegistrationNumber("123rr");
	  p1.setIsCustomer("yes");
	  p1.setIsDeliveryMan("yes");
	  
	  assertEquals(personService.checkValidRegistration(p1), false);
  }

}
