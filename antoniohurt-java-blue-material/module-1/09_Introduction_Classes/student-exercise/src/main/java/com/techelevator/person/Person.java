package com.techelevator.person;

public class Person {

	private String firstName;
	private String lastName;
	private int age;

	public String getFullName() {
		return ("John Doe");

	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public boolean isAdult() {
		return age >= 18;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
