package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		File inputFile = userInput();
		String word = wordSearch();
		searchTool(inputFile, word);

	}

	private static File userInput() {
		Scanner fileInput = new Scanner(System.in);
		System.out.println("What is the file that should be searched?");
		String path = fileInput.nextLine();

		File inputFile = new File(path);
		if (!inputFile.exists()) {
			System.out.println(path + " does not exist.");
		}
		return inputFile;
	}

	public static String wordSearch() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a word to search.");
		String searchWord = userInput.nextLine();

		return searchWord;

	}

	public static String searchTool(File inputFile, String searchWord) {

		Scanner caseSensitiveYOrN = new Scanner(System.in);
		System.out.println("Would you like your search to be case sensitive? Y/N ");
		String yesOrNo = caseSensitiveYOrN.nextLine().toLowerCase().substring(0, 1);

		try (Scanner input = new Scanner(inputFile)) {
			int x = 0;
			int y = 1;

			while (input.hasNextLine()) {
				if (yesOrNo.equals("n")) {
					x++;
					String line = input.nextLine();
					if (line.toLowerCase().contains(searchWord.toLowerCase())) {
						System.out.println(x + ") " + line);
					}
					

				} else {
					String line = input.nextLine();
					if (line.contains(searchWord)) {
						System.out.println(x + ") " + line);
					}
				}  

			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File does not exist!");
		}
		return "";
	}

}
