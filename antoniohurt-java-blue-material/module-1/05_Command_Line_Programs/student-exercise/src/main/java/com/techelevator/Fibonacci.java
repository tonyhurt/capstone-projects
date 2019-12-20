package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		int a = 0;
		int b = 1;  
		int c = 0;
 
		Scanner in = new Scanner(System.in);

		System.out.print("Enter a number: ");

		int numOne = in.nextInt();
		in.nextLine();

		System.out.println(0 + " ");

		for (int numTwo = 1; numTwo <= numOne;) {

			System.out.print(numTwo + " ");

			b = a;
			a = numTwo;
			numTwo = numTwo + b;
		}
	}
}
