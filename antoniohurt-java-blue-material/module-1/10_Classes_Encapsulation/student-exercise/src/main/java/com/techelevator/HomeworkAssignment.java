package com.techelevator;

public class HomeworkAssignment {

	public int totalMarks;

	public int possibleMarks;

	public String submitterName;
	
	public HomeworkAssignment (int possibleMarks) {
		this.possibleMarks = possibleMarks;
	}  

	public String letterGrade() {
		if (((1.0 * totalMarks / possibleMarks) * 100) >= 90) {
			return "A";
		} else if ((((double) 1.0 * totalMarks / possibleMarks) * 100) >= 80) {
			return "B";
		} else if (((1.0 * totalMarks / possibleMarks) * 100) >= 70) {
			return "C";
		} else if ((1.0 * totalMarks / possibleMarks) * 100 >= 60) {
			return "D";
		} else
			return "F";  
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public int getPossibleMarks() {
		return possibleMarks;
	}

	public String getSubmitterName() {
		return submitterName;
	}

	public String getLetterGrade() {
		return letterGrade();
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}

}
