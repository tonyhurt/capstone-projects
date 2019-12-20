package com.techelevator.splitter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSplitter {

	public void split(File inputFile, int lineCount) throws FileNotFoundException, SegmentWriteException {
		
		SegmentWriter segmentWriter = new FileSegmentWriter(inputFile.getAbsolutePath());
		
		try (Scanner fileScanner = new Scanner(inputFile)) {
			
			int segment = 0;
			
			while(fileScanner.hasNextLine()) {
				
				List<String> lines = new ArrayList<String>();
				int count = lineCount;
				
				while (count > 0 && fileScanner.hasNextLine()) {
					lines.add(fileScanner.nextLine());
					count--;
				}
				segment++;
				segmentWriter.write(lines, segment);
				
			}
			
			
		}
		
	}
}
