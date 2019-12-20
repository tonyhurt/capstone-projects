package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		try (Scanner userInput = new Scanner(System.in)) {
			System.out.println("What is the destination for FizzBuzz.txt?");
			String filePath = userInput.nextLine();
			
			writeFizzBuzz300(filePath);

		}
	}

	private static void writeFizzBuzz300(String filePath) {
		File fizzBuzz = new File("FizzBuzz.txt");

		try (PrintWriter writer = new PrintWriter(fizzBuzz)) {
			for (int i = 1; i <= 300; i++)

				if (i % 3 == 0 && i % 5 == 0) {
					writer.println("FizzBuzz");
				} else if (i % 3 == 0) {
					writer.println("Fizz");
				} else if (i % 5 == 0) {
					writer.println("Buzz");
				} else if ((Integer.toString(i).contains("3")) && (Integer.toString(i).contains("5"))) {
					writer.println("FizzBuzz");
				} else if (Integer.toString(i).contains("3")) {
					writer.println("Fizz");
				} else if (Integer.toString(i).contains("5")) {
					writer.println("Buzz");
				} else {
					writer.println(i);

				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

	}

}
