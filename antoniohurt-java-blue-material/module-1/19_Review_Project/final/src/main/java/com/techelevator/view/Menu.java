package com.techelevator.view;

import java.util.Map;
import java.util.Scanner;

import com.techelevator.items.Item;
import com.techelevator.items.Slot;

public class Menu {

	private Scanner in = new Scanner(System.in);
	
	public String getFileNameFromUser() {
		System.out.println();
		System.out.print("Path to the inventory file >>>");
		String fileName = in.nextLine();
		return fileName;
	}
	
	public void displayUserMessage(String message) {
		System.out.println(message);
		System.out.flush();
	}
	
	public void displayAllItems(Map<String, Slot> slots) {
		
		for (String key : slots.keySet()) {
			
			Slot slot = slots.get(key);
			Item item = slot.getItem();
			
			System.out.printf("%2s  %-20s  $%.2f  %-12s%n", key, item.getName(), item.getPrice(), slot.getStock());
			
		}
		System.out.println();
		System.out.flush();
		
	}
	
	public String getSelectionFromUser(String[] options) {
		
		String selectedOption = null;
		
		while (selectedOption == null) {
			
			displayUserOptions(options);
			int userChoice = in.nextInt();
			in.nextLine();
			
			if (userChoice - 1 >= options.length || userChoice < 1) {
				displayUserMessage("Please select a valid option!");
			} else {
				selectedOption = options[userChoice - 1];
			}
		}
		
		return selectedOption;
		
	}
	
	private void displayUserOptions(String[] options) {
	
		for (int i = 0; i < options.length; i++) {
			System.out.println( (i + 1) + ") " + options[i] );
		}
		System.out.print("choice >>>");
		System.out.flush();
	}
}
