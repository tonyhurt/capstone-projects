package com.techelevator;

public class TriangleClassifier {

	private final static String IVALID_TRIANGLE = "invalid";
	private final static String EQUILATERAL_TRIANGLE = "equilateral";
	private final static String ISOSCELES_TRIANGLE = "isosceles";
	private final static String SCALENE_TRIANGLE = "scalene";
	private final static String UNKNOWN_SHAPE = "unknown";
	

	public String classify(int side1, int side2, int side3) {
		if (side1 == side2 && side1 == side3) {
			return "equilateral";
		}

		if ((side1 == side2 && side1 != side3) || (side1 == side3 && side2 != side1)
				|| (side2 == side3 && side2 != side1)) {
			return "isosceles";

		}

		if (side1 != side2 && side1 != side3 && side2 != side3) {
			return "scalene";
		}

		if (side1 + side2 <= side3) {
			return "invalid";
		}
		if (side1 + side3 <= side2) {
			return "invalid";
		}

		if (side2 + side3 <= side1) {
			return "invalid";
		}

		return "unknown";
	}

	private boolean isValidTriangle(int side1, int side2, int side3) {
		if ((side1 == side2 && side1 != side3) || (side1 == side3 && side2 != side1)
				|| (side2 == side3 && side2 != side1)) {
			return false;
		}
		return true;
	}

	private boolean isEquilateralTriangle(int side1, int side2, int side3) {
		return (side1 == side2 && side1 == side3);
	}
	
	private boolean isScaleneTriangle (int side1, int side2, int side3) {
		return side1 != side2 && side1 != side3 && side2 != side3;
	}
}
