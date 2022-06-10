package com.bayzdelivery.model;

/**
 * 
 * Response body for delivery men whose delivery has the maximum order price in a given time
 *
 */
public class HighestDeliveryPersons {
	  Person person;
	  
	  Long averageComission;

	public HighestDeliveryPersons() {
		super();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getAverageComission() {
		return averageComission;
	}

	public void setAverageComission(Long averageComission) {
		this.averageComission = averageComission;
	}

	public HighestDeliveryPersons(Person person, Long averageComission) {
		super();
		this.person = person;
		this.averageComission = averageComission;
	}
}
