package com.techelevator.splitter;

import java.util.List;

public interface SegmentWriter {
	
	void write(List<String> lines, int segment) throws SegmentWriteException;

}
