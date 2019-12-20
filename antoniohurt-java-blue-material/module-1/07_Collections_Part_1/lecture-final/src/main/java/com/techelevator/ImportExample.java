package com.techelevator;

import java.util.*;
import com.techelevator.data.NumberCruncher;

public class ImportExample {
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(java.lang.System.in);
		
		System.out.println("Pick a whole number?");
		
		String userChoice = in.nextLine();
		int number = Integer.parseInt(userChoice);
		
		NumberCruncher numberCruncher = new NumberCruncher();
		Integer newNumber = numberCruncher.multiplyNumberBy10(number);
		
		System.out.println("Your number multiplied by 10 is " + newNumber);

	}
	
//	public static void main(String[] args) {
//		
//		java.util.Scanner in = new java.util.Scanner(java.lang.System.in);
//		
//		java.lang.System.out.println("Pick a whole number?");
//		
//		java.lang.String userChoice = in.nextLine();
//		int number = java.lang.Integer.parseInt(userChoice);
//		
//		com.techelevator.data.NumberCruncher numberCruncher = new com.techelevator.data.NumberCruncher();
//		java.lang.Integer newNumber = numberCruncher.multiplyNumberBy10(number);
//		
//		java.lang.System.out.println("Your number multiplied by 10 is " + newNumber);
//
//	}

}
