package com.techelevator;

public class SPU implements DeliveryDriver {
	String days;

	SPU(String days) {
		this.days = days;
	}

	@Override
	public double calculateRate(int distanceInMiles, double weightInOunces) {
		double rate = 0;
		if (days == "4-Day Ground") {
			rate = (weightInOunces * .0050) * distanceInMiles;
		} else if (days == "2-Day Business") {
			rate = (weightInOunces * .050) * distanceInMiles;
		} else if (days == "Next Day") {
			rate = (weightInOunces * .075) * distanceInMiles;
		}

		return rate;

	}

	@Override
	public String getName() {
		if (days == "4-Day Ground") {
			return "SPU (4-Day Ground)";
		} else if (days == "2-Day Business") {
			return "SPU (2-Day Business)";
		} else if (days == "Next Day") {
			return "SPU (Next Day)";
		}
		return null;

	}

}
