package com.techelevator.paintshop;

public class OilPaint implements Paint {

	private boolean interior;
	
	public OilPaint(boolean interior) {
		this.interior = interior;
	}
	
	@Override
	public String getName() {
		if (interior) {
			return "Interior Oil";
		}
		return "External Oil";
	}

	@Override
	public double calculateCost(int area) {
		if (interior) {
			return (area / 600) * 30;
		}
		return (area / 600) * 50;
	}

	
	
}
