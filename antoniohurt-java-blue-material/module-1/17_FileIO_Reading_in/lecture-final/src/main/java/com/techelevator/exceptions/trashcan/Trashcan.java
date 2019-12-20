package com.techelevator.exceptions.trashcan;


import java.io.IOException;

public class Trashcan {

	private int items;
	
	public boolean addItems(int number) {
		
		if (items + number > 5) {
			return false;
		}
		items += number;
		return true;
	}
	
	public void putItemsOnTop(int number)  {
		throw new ItemFellOffException("Putting Items on top never works!");
	}
	
	public void pushItemsIn(int number) {
		if (items + number > 10) {
			throw new TrashCanFullException("Too many items to push in... items now on top, which never works so one fell off!");
		}
		items += number;
	}
	
	
}