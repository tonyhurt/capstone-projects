package com.techelevator.farm;

public final class Cat extends FarmAnimal {

	public Cat() {
		super("Cat", "Meow", 0d);
	}
	
	@Override
	public String eat(String food) {
		return "crunch";
	}


}
