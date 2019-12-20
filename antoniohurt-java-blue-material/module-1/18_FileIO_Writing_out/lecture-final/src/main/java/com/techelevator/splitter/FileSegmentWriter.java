package com.techelevator.splitter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileSegmentWriter implements SegmentWriter {

	private String fileName;
	
	public FileSegmentWriter(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void write(List<String> lines, int segment) throws SegmentWriteException {
		
		File outputFile = new File(fileName + "-" + segment);
		
		try ( PrintWriter writer = new PrintWriter(outputFile);
				BufferedWriter buffered = new BufferedWriter(writer) ) {
			
			for (String s : lines) {
				buffered.write(s + System.getProperty("line.separator"));
			}
					
		} catch (IOException e) {
			throw new SegmentWriteException(e);
		}
		
	}
}
