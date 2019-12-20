package com.techelevator.calculator;

public class Calculator {

	private int currentValue;

	int result;

	public int add(int addend) {
		result = addend + result;
		return result;

	}

	public int getResult() {
		return result;
	}

	public int multiply(int multiplier) {
		result = result * multiplier;
		return result;
	}

	public int power(int exponent) {
		return result = (int) Math.pow(result, exponent);
	}

	public void reset() {
		result = 0;
		return;
	}

	public int subtract(int subtrahend) {
		return result = result - subtrahend;

	}

}
