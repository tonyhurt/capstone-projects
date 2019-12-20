package com.techelevator;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.dao.jdbc.JDBCVenueDao;
import com.techelevator.menu.Menu;
import com.techelevator.objects.Reservation;
import com.techelevator.objects.Space;
import com.techelevator.venuemanager.VenueManager;

public class ExcelsiorCLI {

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/excelsior-venues");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		ExcelsiorCLI application = new ExcelsiorCLI(dataSource);
		application.run();
	}

	public ExcelsiorCLI(DataSource datasource) {
		JDBCVenueDao dao = new JDBCVenueDao(datasource);
		VenueManager manager = new VenueManager(dao);
		Menu menu = new Menu();

		long venueId = 0;

		startMenusCorrectWay(menu, manager);

	}

	public void run() {

	}

	private void startMenusCorrectWay(Menu menu, VenueManager manager) {
		while (true) {
			String choice = menu.firstMenu();
			if (choice.equals("1")) {
				menuTwoRight(menu, manager);
			}
			if (choice.equals("Q")) {
				menu.displayMessage("Thank you for your patronage");
				break;
			}
			menu.displayMessage("Invalid input, please try again.");
		}
	}

	private void menuTwoRight(Menu menu, VenueManager manager) {
		while (true) {
			manager.displayAllVenues();
			String choice = menu.secondMenu();
			if (choice.toUpperCase().equals("R")) {
				break;
			}

			try {
				long venueId = Long.parseLong(choice);
				manager.displaySpecificVenue(venueId);
				menuThreeRight(menu, manager, venueId);

			} catch (Exception e) {
				menu.displayMessage("Invalid input. Please try again.");
			}
		}

	}

	private void menuThreeRight(Menu menu, VenueManager manager, long venueId) {
		while (true) {
			String choice = menu.thirdMenu();
			if (choice.toUpperCase().equals("R")) {
				break;
			}
			if (choice.equals("1")) {
				manager.displayAllSpacesFromVenue(venueId);
				reservationMenuRight(menu, manager, venueId);
			} else {
				menu.displayMessage("Invalid inpit. Please try again.");
			}

		}

	}

	private void reservationMenuRight(Menu menu, VenueManager manager, long venueId) {
		while (true) {
			String choice = menu.reservationMenu();
			if (choice.toUpperCase().equals("R")) {
				break;
			}
			if (choice.equals("1")) {
				List<Space> availableSpaces = manager.findAvailableRooms(venueId);
				menu.displayMessage("The following spaces are available based on your needs:");
				menu.displaySpaceOptions("Space #", "Name", "Daily Rate", "Max Occup.", "Accessible?", "Total Cost");
				
				for (Space availableSpace : availableSpaces) {
					menu.displaySpaceOptions(String.valueOf(availableSpace.getId()), availableSpace.getName(),
							"$" + String.valueOf(availableSpace.getDailyCost()), String.valueOf(availableSpace.getMaxOccupancy()),
							availableSpace.isAccessible(),
							"$" + String.valueOf(availableSpace.getDailyCost().multiply(manager.getDaysStaying())));

				}
				menu.displayMessage("Which space would you like to reserve? (enter 0 to cancel");
				String spaceId = menu.getUserInput();

				if (spaceId.equals("0")) {
					break;
				}

				try {
					long chosenSpace = Long.parseLong(spaceId);
					menu.displayMessage("Who is this reservation for?");
					String userInput = menu.getUserInput();
					Reservation madeReservation = manager.makeReservation(userInput, chosenSpace);
					menu.confirmationReservation(madeReservation);
					break;
				} catch (Exception e) {
					menu.displayMessage("Invalid input. Please try again.");
				}

			} else {
				menu.displayMessage("Invalid input. Please try again");
			}

		}
	}

}
