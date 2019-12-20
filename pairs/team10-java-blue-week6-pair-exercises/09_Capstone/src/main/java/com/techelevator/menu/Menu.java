package com.techelevator.menu;

import java.util.Scanner;

import com.techelevator.objects.Reservation;

public class Menu {
	Scanner in = new Scanner(System.in);

	public String firstMenu() {
		displayMessage("Select option:");
		displayMessage("1) See all venues.");
		displayMessage("Q) Quit");

		return in.nextLine();
	}

	public String secondMenu() {
		displayMessage("Which venue would you like to view?");
		displayMessage("R) Return to previous screen.");
		return in.nextLine();
	}

	public String thirdMenu() {
		displayMessage("What would you like to do next?");
		displayMessage("1) View spaces.");
		displayMessage("R) Return to Previous Screen.");

		return in.nextLine();
	}

	public String reservationMenu() {
		displayMessage("What would you like to do next?");
		displayMessage("1) Reserve a Space");
		displayMessage("R) Return to Previous Screen");

		return in.nextLine();
	}

	
	public void confirmationReservation(Reservation reservation) {
		displayMessage("Confirmation #:" + (reservation.getConfirmationNumber()));
		displayMessage("Venue:" + (reservation.getVenue()));
		displayMessage("Space:" + (reservation.getSpace()));
		displayMessage("Reserved For:" + (reservation.getReservedFor()));
		displayMessage("Attendees:" + (reservation.getAttendees()));
		displayMessage("Arrival Date:" + (reservation.getArrivalDate()));
		displayMessage("Depart Date:" + (reservation.getDepartDate()));
		displayMessage("Total Cost:" + (reservation.getTotalCost()));

	}

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void displaySpaceOptions(String spaceID, String name, String rate, String occupancy, String accessible, String cost) {
		System.out.printf("%2s  %-15s  %-15s  %-15s %-15s %-15s %n", spaceID, name, rate, occupancy, accessible, cost);

	}
	
	public String getUserInput() {
		return in.nextLine();
	}
}
