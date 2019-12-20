package com.techelevator.TollBoothCalculator;

public class Truck implements Vehicle {

	public int getNumberOfAxles() {
		return numberOfAxles;
	}

	@Override
	public double calculateToll(int distance) {
		int axles = getNumberOfAxles();
		if (axles == 4) {
			return (0.040 * distance);
		}
		if (axles == 6) {
			return (0.045 * distance);
		}
		if (axles >= 8) {
			return (0.048 * distance);

		}
		 return (0.040 * distance);  
	}

	public int numberOfAxles;

	public Truck(int numberOfAxles) {
		this.numberOfAxles = numberOfAxles;
	}

	public Truck(int i, int j) {
		// TODO Auto-generated constructor stub
	}

}
