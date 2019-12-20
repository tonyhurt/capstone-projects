package com.techelevator.venuemanager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.techelevator.dao.jdbc.JDBCVenueDao;
import com.techelevator.menu.Menu;
import com.techelevator.objects.Reservation;
import com.techelevator.objects.Space;
import com.techelevator.objects.Venue;

public class VenueManager {
	private JDBCVenueDao dao;
	private Menu menu = new Menu();

	public VenueManager() {

	}

	public VenueManager(JDBCVenueDao dao) {
		this.dao = dao;

	}

	private long numberOfAttendees;
	private LocalDate startDate;
	private LocalDate endDate;
	private long daysStaying = 0;

	public void displayAllVenues() {
		List<Venue> allVenues = dao.findAllVenues();

		for (Venue currentVenue : allVenues) {
			menu.displayMessage(currentVenue.getId() + ") " + currentVenue.getName());
		}

	}

	public void displaySpecificVenue(long venueId) {
		Venue venue = dao.getSpecificVenue(venueId);

		menu.displayMessage(venue.getName());
		menu.displayMessage(venue.getCityName() + ", " + venue.getState());
		menu.displayMessage(venue.getCategorieNames());
		menu.displayMessage(venue.getDescription());
	}

	public void displayAllSpacesFromVenue(long venueId) {
		List<Space> allSpaces = dao.getVenueSpaces(venueId);

		for (Space currentSpace : allSpaces) {
			menu.displayMessage(currentSpace.getId() + ") " + currentSpace.getName());
		}
	}

	// make a reservation
	public List<Space> findAvailableRooms(long venueId) {
		menu.displayMessage("When do you need the space? (Enter as yyyy-mm-dd)");
		startDate = LocalDate.parse(menu.getUserInput());

		menu.displayMessage("How many days will you need the space?");
		daysStaying = Long.parseLong(menu.getUserInput());
		endDate = getLeavingDate(startDate, daysStaying);

		long monthStart = getMonthNumber(startDate);
		long monthEnd = getMonthNumber(endDate);

		menu.displayMessage("How many people will be in attendance?");
		numberOfAttendees = Long.parseLong(menu.getUserInput());

		List<Space> availableSpaces = dao.availableSpaces(daysStaying, venueId, numberOfAttendees, monthStart, monthEnd,
				startDate, endDate);

		return availableSpaces;

	}

	public Reservation makeReservation(String reservedBy, long spaceId) {
		Space reserveSpace = dao.viewSpecificSpace(spaceId);
		Reservation reservation = new Reservation();
		
		reservation.setArrivalDate(startDate);
		reservation.setAttendees(numberOfAttendees);
		reservation.setConfirmationNumber(dao.makeReservation(spaceId, numberOfAttendees, startDate, endDate, reservedBy));
		reservation.setDepartDate(endDate);
		reservation.setReservedFor(reservedBy);
		reservation.setSpace(reserveSpace.getName());
		reservation.setTotalCost(reserveSpace.getDailyCost().multiply(BigDecimal.valueOf(daysStaying)));
		reservation.setVenue(reserveSpace.getVenueName());
		
		return reservation;

	}

	public LocalDate getLeavingDate(LocalDate startDate, long daysToStay) {
		return startDate.plusDays(daysToStay);
	}

	public long getMonthNumber(LocalDate date) {
		return (long) date.getMonthValue();
	}
	public BigDecimal getDaysStaying() {
		return BigDecimal.valueOf(daysStaying);
		
	}
}
