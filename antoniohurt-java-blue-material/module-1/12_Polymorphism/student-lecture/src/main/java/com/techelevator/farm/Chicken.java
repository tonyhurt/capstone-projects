package com.techelevator.farm;

public class Chicken extends FarmAnimal implements Sellable {

	public Chicken() {
		super("Chicken", "cluck!", 25d);
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	
	@Override
	public double getPrice() {

}