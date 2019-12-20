package com.techelevator;

public interface DeliveryDriver {
	
	public double calculateRate(int distanceInMiles, double weightInOunces);
	
	public String getName();

}
