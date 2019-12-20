package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Singable[] farmAnimals = new Singable[] { new Cow(), new Chicken(), new Sheep(), new Tractor(), new Dog() };

		Cow cow = new Cow();
		cow.sleep();

		Cat cat = new Cat();
		cat.sleep();

		FarmAnimal farmAnimal = new Cow();

		for (Singable animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] { new Apple(), new Cow(), new Chicken(), new Sheep() };

		for (Sellable item : sellables) {
			System.out.println("The " + item.getName() + " costs $" + item.getPrice());
		}

	}
}