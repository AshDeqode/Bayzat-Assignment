package com.bayzdelivery.controller;

import java.util.List;

import com.bayzdelivery.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bayzdelivery.service.PersonService;

@RestController
public class PersonController {

  @Autowired
  PersonService personService;

  @PostMapping(path = "/api/person")
  public ResponseEntity<Person> register(@RequestBody Person p) {
	  
	//checking User can not be both customer and delivery man at the same time and Only one must be chosen at registration
	boolean isEligible = personService.checkValidRegistration(p);
	if(isEligible) {
		return ResponseEntity.ok(personService.save(p));
	}
	
	else {
		throw new RuntimeException("Hey you can not be both customer and delivery man at the same time "
				+ "and Only one must be chosen at registration, please try again");
	}
  }

  @GetMapping(path = "/api/person")
  public ResponseEntity<List<Person>> getAllPersons() {
    return ResponseEntity.ok(personService.getAll());
  }

  @GetMapping(path = "/api/person/{person-id}")
  public ResponseEntity<Person> getPersonById(@PathVariable(name="person-id", required=true)Long personId) {
    Person person = personService.findById(personId);
    if (person != null) {
      return ResponseEntity.ok(person);
    }
    return ResponseEntity.notFound().build();
  }

}
