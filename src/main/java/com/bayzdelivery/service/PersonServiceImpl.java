package com.bayzdelivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bayzdelivery.repositories.PersonRepository;
import com.bayzdelivery.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

  @Autowired
  PersonRepository personRepository;

  @Override
  public List<Person> getAll() {
    List<Person> personList = new ArrayList<>();
    personRepository.findAll().forEach(personList::add);
    return personList;
  }

  public Person save(Person p) {
    return personRepository.save(p);
  }

  @Override
  public Person findById(Long personId) {
    Optional<Person> dbPerson = personRepository.findById(personId);
    return dbPerson.orElse(null);
  }

  /**
   * checking User can not be both customer and 
   * delivery man at the same time and Only one must be chosen at registration
   */ 
  @Override
  public boolean checkValidRegistration(Person p) {
	  
	if(((p.getIsCustomer()).toLowerCase()).equals("yes") && (p.getIsDeliveryMan().toLowerCase()).equals("yes")) {
		return false;
	}
	
	else {
		return true;
	}
  }
}