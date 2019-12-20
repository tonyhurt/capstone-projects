package com.techelevator.farm;

public class Tractor implements Singable {

	public String getName() {
		return "Tractor";
		
	}
	@Override
	public String getSound() {
		return "rrrrr";
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
