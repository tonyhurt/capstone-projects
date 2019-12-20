package com.techelevator.TollBoothCalculator;

public class Car implements Vehicle {
	
	public boolean hasTrailer;

	public boolean isHasTrailer() {
		return hasTrailer;
	}

	public Car(int i, boolean hasTrailer)	{
		this.hasTrailer = hasTrailer;
		
	}

	@Override
	public double calculateToll(int distance) {
		
		if (isHasTrailer() == true) {
			return ((distance * 0.020) + 1.00);
			
		}
		return (distance * 0.020);
	}
	
	
	
}
