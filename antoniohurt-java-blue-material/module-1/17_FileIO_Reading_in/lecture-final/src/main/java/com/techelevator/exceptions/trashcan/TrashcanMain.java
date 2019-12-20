package com.techelevator.exceptions.trashcan;

import java.io.IOException;
import java.util.Scanner;

public class TrashcanMain {
	
	private static Scanner in;
	
	public void run() {
		
		boolean running = true;
		Trashcan trashcan = new Trashcan();

		while (running) {
			
			int numberOfItems = getNumberOfItemsToAdd();

			if (numberOfItems == 0) {
				break;
			}
			
			if (trashcan.addItems(numberOfItems)) {
				System.out.println("Items added Successfully");
			} else {
				try {
					handleErrorMenu(trashcan, numberOfItems);
				} catch (ItemFellOffException e) {
					System.out.println("The items fell off " + e.getMessage());
				} catch (TrashCanFullException e) {
					System.out.println("Trash can full");
				} finally {
					// do some clean up here
				}
			}
		}

	}
	
	private void handleErrorMenu(Trashcan trashcan, int numberOfItems)  {
		while (true) {

			int selection = getUserErrorSelection();
			if (selection == 1) {
				trashcan.putItemsOnTop(numberOfItems);
			} else if (selection == 2) {
				trashcan.pushItemsIn(numberOfItems);
				System.out.println("Items added successfully!");
				break;
			} else if (selection == 3) {
				break;
			} else {
				System.out.println("Invalid selection.  Please select again!");
				continue;
			}
		}

	}
	
	
	private int getNumberOfItemsToAdd() {
		System.out.print("How many items would you like to add (0 to exit)?");

		int numberOfItems = in.nextInt();
		in.nextLine();
		return numberOfItems;
	}
	
	private int getUserErrorSelection() {
		System.out.println("There are too many items, do you want to ");
		System.out.println("(1) Add your items on top");
		System.out.println("(2) Push them in");
		System.out.println("(3) Do not add them");

		int selection = in.nextInt();
		in.nextLine();
		return selection;
	}
	
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		TrashcanMain main = new TrashcanMain();
		try {
			main.run();
		} finally {
			in.close();
		}
	}
	
	
}
