package com.techelevator.exceptions.calc.str;

import java.util.List;

import com.techelevator.exceptions.calc.Calculator;
import com.techelevator.exceptions.calc.Menu;

public class MainStringCalc {

	public static void main(String[] args) {

		Menu menu = new Menu();
		Calculator strCalc = new StringCalculator();

		List<String> values = menu.getValuesFromUser();

		try {
			List<String> results = strCalc.calculate(values);

			for (String result : results) {
				menu.displayUserMessage(result);
			}

		} catch (NullPointerException ex) {
			System.out.println("List was null");
		} catch (InvalidStringExpcetion e) {
			System.out.println("Not all input was a number: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An unknown error occurred: " + e.getMessage());

		}

	}

}
