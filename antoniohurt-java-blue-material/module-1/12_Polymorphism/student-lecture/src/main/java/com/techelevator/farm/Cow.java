package com.techelevator.farm;

public class Cow extends FarmAnimal implements Sellable {

	public Cow() {
		super("Cow", "moo!", 1500d);
	}
	
	@Override
	public double getPrice() {
		System.out.println("")
	}

}