package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a temperature: ");
		
		int temp = in.nextInt();
		in.nextLine();
		
		System.out.print("Is the temperature in Celcius, or Fahrenheit? ");
		
		String degFOrC = in.nextLine();
		
		System.out.println(temp + degFOrC + " is " + convert(temp, degFOrC) + (degFOrC.toUpperCase().startsWith("F") ? "C" : "F"));
	}
	
	public static int convert(int temp, String degFOrC) {
		
		
		if(degFOrC.toUpperCase().startsWith("F")) {
			int resultTempC = (int)(( temp - 32) / 1.8);
			return resultTempC;
		} else {
			int resultTempF = ((int)(temp * 1.8 + 32));
			return resultTempF;
		}
	}
}