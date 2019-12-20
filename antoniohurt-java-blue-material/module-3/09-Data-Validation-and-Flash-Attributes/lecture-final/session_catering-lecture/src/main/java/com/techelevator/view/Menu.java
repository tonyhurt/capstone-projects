package com.techelevator.view;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.space.Space;
import com.techelevator.utility.TypeConverter;
import com.techelevator.venue.Venue;

public class Menu {

	private Scanner in = new Scanner(System.in);
	private final static String LOCATION = "Location: ";
	private final static String CATEGORIES = "Categories: ";
	private TypeConverter tc;

	public Menu(TypeConverter tc) {
		this.tc = tc;
	}

	public TypeConverter getTypeConverter() {
		return tc;
	}

	public void displayUserMessage(String message) {
		System.out.println(message);
	}

	public void displayUserPrompt(String prompt) {
		System.out.println(prompt);
	}

	public String getSelectionFromUser(String[] options, String[] menuOptions) {

		String selectedOption = null;

		while (selectedOption == null || selectedOption.equals("")) {

			String userChoice = "";

			try {
				userChoice = in.nextLine();
				System.out.println();
			} catch (StringIndexOutOfBoundsException e1) {
				displayInvalidOption();
				in.nextLine();
			}

			if (isValidIntegerInput(userChoice, options)) {
				selectedOption = options[Integer.parseInt(userChoice) - 1];
			} else if (isValidCharacterInput(userChoice, menuOptions)) {
				if (userChoice.length() > 1) {
					displayInvalidOption();
				} else {
					selectedOption = matchCharacterSelectionToOption(userChoice.charAt(0), menuOptions);
				}
			} else {
				displayInvalidOption();
			}
		}
		return selectedOption;
	}

	public void displayVenueDetails(Venue venue, String categories) {

		System.out.println(venue.getName());
		System.out.println(LOCATION + venue.getLocation());
		System.out.println(CATEGORIES + categories + "\n");
		System.out.println(venue.getDescription() + "\n");
	}

	public void displayVenueSpaces(String venueName, List<Space> spaces) {

		System.out.println(venueName + "\n");
		System.out.printf("%-6s %-37s %-6s %-8s %-13s %-20s%n", "", "Name", "Open", "Close", "Daily Rate",
				"Max Occupancy");
		for (Space space : spaces) {
			System.out.printf("#%-5s %-37s %-6s %-8s $%-12.2f %-20d%n", space.getSpaceID(), space.getSpaceName(),
					tc.intMonthToString(space.getOpenFrom()), tc.intMonthToString(space.getOpenTo()),
					space.getDailyRate(), space.getMaxOccupancy());
		}
	}

	public void displayAvailableSpaces(Map<Long, Space> spaces, int reservationDays) {
		System.out.println("The following spaces are available based on your needs: \n");
		System.out.printf("%-10s %-37s $%-12s %-20s %-20s %-12s%n", "Space #", "Name", "Daily Rate", "Max Occupancy",
				"Accessible?", "Total Cost");
		for (Space space : spaces.values()) {
			String accessibleString = "No";
			if (space.isAccessible()) {
				accessibleString = "Yes";
			}
			System.out.printf("%-10s %-37s $%-12.2f %-20s %-20s $%-12.2f%n", space.getSpaceID(), space.getSpaceName(),
					space.getDailyRate(), space.getMaxOccupancy(), accessibleString,
					(space.getDailyRate().multiply(new BigDecimal(reservationDays))));
		}
	}

	public void displayNoAvailableSpaces() {
		System.out.println();
		System.out.println("Sorry, there's nothing at this venue available for you.");
		System.out.println("Would you like to try a different search? (Y/*) ");
	}

	public void displayConfirmationDetails(long reservationID, String venueName, String spaceName, String reservedFor,
			int reservationAttendees, LocalDate startDate, LocalDate endDate, BigDecimal dailyRate) {
		System.out.println();
		System.out.println("Thanks for submitting your reservation! The details for your event are listed below: \n\n");
		System.out.printf("%17s %-15d%n", "Confirmation #: ", reservationID);
		System.out.printf("%17s %-15s%n", "Venue: ", venueName);
		System.out.printf("%17s %-15s%n", "Space: ", spaceName);
		System.out.printf("%17s %-15s%n", "Reserved for: ", reservedFor);
		System.out.printf("%17s %-15d%n", "Attendees: ", reservationAttendees);
		System.out.printf("%17s %-15s%n", "Arrival Date: ", tc.dateToString(startDate));
		System.out.printf("%17s %-15s%n", "Depart Date: ", tc.dateToString(endDate));
		System.out.printf("%17s $%-15.2f%n%n%n", "Total cost: ", dailyRate.multiply(new BigDecimal(Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay()).toDays())));
	}

	private String matchCharacterSelectionToOption(char userChoice, String[] menuOptions) {
		for (String option : menuOptions) {
			if (Character.toUpperCase(userChoice) == option.charAt(0)) {
				return option;
			}
		}
		return null;
	}

	private boolean isValidIntegerInput(String userChoice, String[] options) {
		if (userChoice != null && !userChoice.equals("")) {
			if (isNumeric(userChoice)) {
				int digitUserChoice = Integer.parseInt(userChoice);
				if ((digitUserChoice - 1 < options.length && digitUserChoice > 0)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

	protected boolean isNumeric(String str) {

		if (str == null || str.length() == 0) {
			return false;
		}

		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		return true;

	}

	private boolean isValidCharacterInput(String userChoice, String[] menuOptions) {
		if (userChoice != null && !userChoice.equals("")) {
			char c = userChoice.charAt(0);
			if (Character.isLetter(c)) {
				for (int i = 0; i < menuOptions.length; i++) {
					if (menuOptions[i].charAt(0) == Character.toUpperCase(c)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private void displayInvalidOption() {
		displayUserMessage("Please select a valid option!");
		displayUserMessage("choice >>>");
	}

	public void displayUserOptions(String[] options, String[] menuOptions) {

		System.out.println();

		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ") " + options[i]);
		}
		for (int j = 0; j < menuOptions.length; j++) {
			System.out.println(menuOptions[j].charAt(0) + ") " + menuOptions[j]);
		}
		System.out.print("choice >>> ");
	}
}
