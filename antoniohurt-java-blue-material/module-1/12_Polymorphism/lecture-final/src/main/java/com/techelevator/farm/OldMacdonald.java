package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		Cow cow = new Cow();
		Chicken chicken = new Chicken(25);
		Chicken goldie = new Chicken(2500);
		Tractor tractor = new Tractor();
		Dog dog = new Dog();
		
		Singable[] singers = new Singable[] { cow, chicken, tractor, dog, goldie };

		for (Singable animal : singers) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

	
		
		Sellable[] animals = new Sellable[] { cow, chicken, tractor , new Apple(), goldie };
		
		for (Sellable animal : animals) {
			System.out.println("The " + animal.getName() + " costs $" + animal.getPrice());
		}
		
		List<FarmAnimal> farmAnimals = new ArrayList<FarmAnimal>();
		farmAnimals.add(cow);
		farmAnimals.add(chicken);
		farmAnimals.add(dog);
		
		for (FarmAnimal animal : farmAnimals) {
			if (animal instanceof Sellable) {
				Sellable sellable = (Sellable) animal;
				System.out.println("The " + animal.getName() + " can be sold for " + sellable.getPrice());
			}
			if (animal instanceof Singable) {
				Singable singable = (Singable) animal;
				System.out.println("The " + animal.getName() + " sings " + singable.getSound());
			}
		}
		
		
		
	}
}