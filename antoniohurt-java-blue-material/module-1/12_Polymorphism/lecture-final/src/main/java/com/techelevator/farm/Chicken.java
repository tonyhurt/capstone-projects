package com.techelevator.farm;

public class Chicken extends FarmAnimal implements Sellable {

	private double price;
	
	public Chicken(double price) {
		super("Chicken", "cluck!");
		this.price = price;
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	
	@Override
	public double getPrice() {
		return price;
	}

}