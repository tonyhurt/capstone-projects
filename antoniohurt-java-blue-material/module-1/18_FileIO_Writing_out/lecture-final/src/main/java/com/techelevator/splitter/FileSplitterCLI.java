package com.techelevator.splitter;

import java.io.File;
import java.io.FileNotFoundException;

public class FileSplitterCLI {

	private Menu menu = new Menu();
	private static final String[] MENU_OPTIONS = { "100", "500", "1000", "1500" };
	public void run() {
		
		// Get the File
		File file = getFile();
		
		// Get Number of Lines to Split
		int lineCount = getLinesToSplit();
		
		// Split the file
		FileSplitter splitter = new FileSplitter();
		
		try {
			splitter.split(file, lineCount);
		} catch (Exception e) {
			menu.displayUserMessage("An unexpected error has occurred: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	private int getLinesToSplit() {
		String userSelection = menu.getSelectionFromUser(MENU_OPTIONS);
		return Integer.parseInt(userSelection);
	}
	
	private File getFile() {
		File file = null;
		
		while (file == null) {
			
			String fileName = menu.getFileNameFromUser();
			file = new File(fileName);
			
			if ( !file.exists() || !file.isFile() ) {
				menu.displayUserMessage(fileName + " is not a valid file!");
				file = null;
			}
			
		}
		
		return file;
	}
	
	public static void main(String[] args) {
		FileSplitterCLI cli = new FileSplitterCLI();
		cli.run();
	}
}
