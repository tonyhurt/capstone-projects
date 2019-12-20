package com.techelevator.farm;

public class Chicken extends FarmAnimal implements Sellable {

	public Chicken() {
		super("Chicken", "cluck!", 20);
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public String eat(String food) {
		// TODO Auto-generated method stub
		return null;
	}

}