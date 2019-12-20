package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private double price;
	private boolean sleeping;

	public FarmAnimal(String name, String sound, double price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public final String getSound() {
		if (sleeping) {
		return "Zzzzzz";
	}
		return sound;
}

	public double getPrice() {
		return this.price;
	}

	public boolean isSleeping() {
		return sleeping;
	}

	public void wake() {
		sleeping = false;
	}

	public void sleep() {
		sleeping = true;
	}
	
	public abstract String eat();
		
	}

}