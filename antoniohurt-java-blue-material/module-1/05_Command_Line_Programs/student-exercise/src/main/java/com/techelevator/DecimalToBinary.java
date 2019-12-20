package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter in a series of decimal values (separated by spaces): ");
		int number = in.nextInt();
 
		if (number < 0) {
			System.out.println("Enter a positive integer!");
		} else {

			System.out.print(" converted to binary is:");
			printBinaryForm(number);
		}
	}

	public static void printBinaryForm(int number) {
		int remainder;

		if (number <= 1) {
			System.out.print(number);
			return; 
		}

		remainder = number % 2;
		printBinaryForm(number >> 1);
		System.out.print(remainder);
	}
}