package com.techelevator.splitter;

import java.util.Scanner;

public class Menu {

	private Scanner in = new Scanner(System.in);
	
	public String getFileNameFromUser() {
		System.out.println();
		System.out.print("Path to file to be split >>>");
		String fileName = in.nextLine();
		return fileName;
	}
	
	public void displayUserMessage(String message) {
		System.out.println(message);
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
		System.out.println("Please select from the following");
		for (int i = 0; i < options.length; i++) {
			System.out.println( (i + 1) + ") " + options[i] );
		}
		System.out.print("choice >>>");
		System.out.flush();
	}
}
