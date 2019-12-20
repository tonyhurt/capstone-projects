package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderMain {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the file path >>>");
		String fileName = in.nextLine();
		
		System.out.println("Number of lines to read >>>");
		int lineCount = in.nextInt();
		in.nextLine();
		
		
		// Create a java.io.File object
		File inputFile = new File(fileName);	
		
		try ( Scanner fileScanner = new Scanner(inputFile) ) {
			
			while (fileScanner.hasNextLine() && lineCount > 0) {
				String lineFromFile = fileScanner.nextLine();
				System.out.println(lineFromFile);
				lineCount--;
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File " + inputFile.getAbsolutePath() + " not found");
		}
	}

}
