package com.techelevator.exceptions.calc.tax;

import java.util.List;

import com.techelevator.exceptions.calc.Calculator;
import com.techelevator.exceptions.calc.Menu;

public class MainTaxCalc {

	public static void main(String[] args) {
	
		
			Menu menu = new Menu();
			Calculator salesTax = new FranklinCountyTaxCalculator();
			
			List<String> values = menu.getValuesFromUser();
			
			try {
				List<String> results = salesTax.calculate(values);
				
				for (String result : results) {
					menu.displayUserMessage(result);
				}
			} catch (NullPointerException e) {
				System.out.println("Invalid Input was null");
			} catch (NumberFormatException e) {
				System.out.println("Not all input was a number: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("An unknown error ocurred: " + e.getMessage());
			}
			

	
	}

}
