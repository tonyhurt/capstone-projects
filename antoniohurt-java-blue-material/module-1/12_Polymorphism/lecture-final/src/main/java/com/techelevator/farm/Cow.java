package com.techelevator.farm;

public class Cow extends FarmAnimal implements Sellable {

	public Cow() {
		super("Cow", "moo!");
	}
	
	@Override
	public double getPrice() {
		return 1500d;
	}

}