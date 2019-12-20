package com.techelevator.farm;

public class Tractor implements Singable, Sellable {


	@Override
	public String getName() {
		return "Tractor";
	}
	
	@Override
	public String getSound() {
		return "rrrrrr";
	}
	
	@Override
	public double getPrice() {
		return 500d;
	}

	public void pressBreak() {
		
	}
	
	public void pressGasPedal() {
		
	}
	
}
