package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		

			Scanner in = new Scanner(System.in);

			System.out.print("Enter a length: ");

			int length = in.nextInt();
			in.nextLine();

			System.out.print("Is the length in meters, or feet? ");

			String lengthMOrF = in.nextLine();

			System.out.println(
					length + lengthMOrF + " is " + convert(length, lengthMOrF) + (lengthMOrF.toUpperCase().startsWith("M") ? "F" : "M"));
		}

		public static int convert(int length, String lengthMOrF) {

			if (lengthMOrF.toUpperCase().startsWith("M")) {
				int lengthInM = (int) (length * 3.2808399);
				return lengthInM;
			} else {
				int lengthInF = (int) (length * 0.3048);
				return lengthInF;
			}
		}
	}