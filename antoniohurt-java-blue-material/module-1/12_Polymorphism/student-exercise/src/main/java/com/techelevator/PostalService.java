package com.techelevator;

public class PostalService implements DeliveryDriver {
	private int distanceInMiles;
	private int weightInOunces;
	private int mailClass;
	
	public PostalService(int mailClass) {
		this.mailClass = mailClass;
	}

	@Override
	public double calculateRate(int distanceInMiles, double weightInOunces) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Postal Service";
	}
	
	

}