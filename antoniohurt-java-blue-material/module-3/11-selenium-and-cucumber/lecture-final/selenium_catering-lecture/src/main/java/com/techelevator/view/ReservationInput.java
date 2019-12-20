package com.techelevator.view;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import com.techelevator.utility.TypeConverter;

public class ReservationInput extends Menu {

	private Scanner in = new Scanner(System.in);
	private TypeConverter tc;

	public ReservationInput(TypeConverter tc) {
		super(tc);
		this.tc = tc;
	}

	public LocalDate checkDateFromString() {
		String userInput = in.nextLine();
		LocalDate date = tc.stringToDate(userInput);
		if (date == null) {
			System.out.println("Please input a valid date (MM/DD/YYYY). ");
		}
		return date;
	}
	
	public <V> long getKeyFromUser(Map<Long, V> map) {
		long userInput = checkInt();
		if (map.containsKey(userInput)) {
			return userInput;
		} else if (userInput == 0) {
			return 0;
		} else {
			return -1;
		}
	}
	
	public String getStringFromUser() {
		String userString = in.nextLine();
		return userString;
	}

	public int checkInt() {
		String userInput;
		int i = -1;
		userInput = in.nextLine();
		if (super.isNumeric(userInput)) {
			i = Integer.parseInt(userInput);
		}
		
		return i;
	}
	
	public LocalDate getEndDate(LocalDate startDate, int numDays) {
		if (numDays > 0) {
			return tc.getEndDate(startDate, numDays);
		}
		return null;
	}

}
