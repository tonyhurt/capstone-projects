package com.techelevator;

public class Dog {

	private String name;
	private String breed;
	private int age;
	
	public Dog(String name, String breed, int age) {
		this.name = name;
		this.breed = breed;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Dog)) {
//			return false;
//		}
//		Dog other = (Dog) obj;
//		if (!this.name.equals(other.getName())) {
//			return false;
//		}
//		if (!this.breed.equals(other.getBreed())) {
//			return false;
//		}
//		if (this.age != other.getAge()) {
//			return false;
//		}
//		return true;
//	}
	
	
	
}
