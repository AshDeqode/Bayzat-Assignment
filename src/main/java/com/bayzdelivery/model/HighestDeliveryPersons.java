package com.bayzdelivery.model;

public class HighestDeliveryPersons {
	  Person person;
	  
	  //Long maximumOrderPrice;
	  
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
//
//	public Long getMaximumOrderPrice() {
//		return maximumOrderPrice;
//	}
//
//	public void setMaximumOrderPrice(Long maximumOrderPrice) {
//		this.maximumOrderPrice = maximumOrderPrice;
//	}

	public Long getAverageComission() {
		return averageComission;
	}

	public void setAverageComission(Long averageComission) {
		this.averageComission = averageComission;
	}

	public HighestDeliveryPersons(Person person, Long averageComission) {
		super();
		this.person = person;
		//this.maximumOrderPrice = maximumOrderPrice;
		this.averageComission = averageComission;
	}
}
