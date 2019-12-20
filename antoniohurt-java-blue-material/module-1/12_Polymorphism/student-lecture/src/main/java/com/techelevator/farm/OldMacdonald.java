package com.techelevator.farm;

public class OldMacdonald {
public static void main(String[] args) {

    Singable[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Tractor() }; //made an array of farm animals added tractor

    for (FarmAnimal animal : farmAnimals) {
        String name = animal.getName();
        String sound = animal.getSound();
        System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
        System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
        System.out.println("With a " + sound + " " + sound + " here");
        System.out.println("And a " + sound + " " + sound + " there");
        System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
        System.out.println();
    }
    
    FarmAnimal[] animals = new FarmAnimal[] {new Cow(), new Chicken (), new Dog() };
    
    for (FarmAnimal animal : animals) {
    	System.out.println("The " + animal.getName() + " costs $" + animal.getPrice()):    }
}

	List<FarmAnimal> farmAnimals = new ArrayList<FarmAnimal>();
	farmAnimals.add(cow);
	farmAnimals.add(chicken);
	farmAnimals.add(dog);

for (FarmAnimal animal : farmAnimals) {
	if (animal instanceof Sellable) {
		Sellable sellable = (Sellable) animal;
		System.out.println("The " + animal.getName() + " can be sold for " + sellable.getPrice);
	}
	if (animal instanceof Singable) {
		Singable singable = (Singable) animal;
		System.out.println("The " + singable.getName() + " can be sold for " + sellable.getPrice());
		}
	
	
	}
}