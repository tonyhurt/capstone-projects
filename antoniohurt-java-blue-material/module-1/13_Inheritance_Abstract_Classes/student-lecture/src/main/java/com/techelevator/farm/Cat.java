package com.techelevator.farm;

public class Cat extends FarmAnimal{

	public Cat() {
		super("Cat", "Meow", 0d);
	}
	
	@Override
	public String eat(String food) {
		return "crunch";
	}

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
