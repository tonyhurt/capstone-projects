package com.techelevator;

public class KataFizzBuzz {
	
	public String FizzBuzzResult(int i) {
		
		
		if (i < 1 || i > 100){
			return " ";
		
		} else if (i % 3 == 0 ) {
			return "Fizz";
		} else if (i % 5 == 0 ) {
			return "Buzz";
		} else if (i % 15 == 0 ) {
			return "FizzBuzz";
		} else if ((Integer.toString(i).contains("3")) && (Integer.toString(i).contains("5"))){
			return "FizzBuzz";
		} else if (Integer.toString(i).contains("3")) {
			return "Fizz";
		} else if (Integer.toString(i).contains("5")) {
			return "Buzz";	
		} else {
			return Integer.toString(i);  
		}
	}

}