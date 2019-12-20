package com.techelevator;

public class TriangleClassifier {

	private final static String INVALID_TRIANGLE = "invalid";
	private final static String EQUILATERAL_TRIANGLE = "equilateral";
	private final static String ISOSCELES_TRIANGLE = "isosceles";
	private final static String SCALENE_TRIANGLE = "scalene";
	private final static String UNKNOWN_SHAPE = "unknown";
	
	public String classify(int side1, int side2, int side3) {
		
		if ( !isValidTriangle(side1, side2, side3) ) {
			return INVALID_TRIANGLE;
		}

		
		if (isEquilateralTriangle(side1, side2, side3)) {
			return EQUILATERAL_TRIANGLE;
		}
		
		if ( isIsoscelesTriangle(side1, side2, side3)) {
			return ISOSCELES_TRIANGLE;
		}
		
		
		if ( isScaleneTriangle(side1, side2, side3 )) {
			return SCALENE_TRIANGLE;
		}
		
	
		return UNKNOWN_SHAPE;
	}
	
	private boolean isValidTriangle(int side1, int side2, int side3) {
		if ( (side1 + side2 <= side3) || 
				(side1 + side3 <= side2) || 
				(side2 + side3 <= side1) ) {
			return false;
		}
		return true;
	}
	
	private boolean isEquilateralTriangle(int side1, int side2, int side3) {
		return side1 == side2 && side1 == side3;
	}
	
	private boolean isIsoscelesTriangle(int side1, int side2, int side3) {
		if ( (side1 == side2 && side1 != side3) ||
				(side1 == side3 && side1 != side2) ||
				(side2 == side3 && side2 != side1) ) {
			return true;
		}
		return false;
	}
	
	private boolean isScaleneTriangle(int side1, int side2, int side3) {
		return side1 != side2 && side1 != side3 && side2 != side3;
	}
	
}
