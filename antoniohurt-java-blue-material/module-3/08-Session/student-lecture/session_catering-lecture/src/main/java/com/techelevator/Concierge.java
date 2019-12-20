package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.reservation.JDBCReservationDAO;
import com.techelevator.reservation.Reservation;
import com.techelevator.reservation.ReservationDAO;
import com.techelevator.space.JDBCSpaceDAO;
import com.techelevator.space.Space;
import com.techelevator.space.SpaceDAO;
import com.techelevator.venue.JDBCVenueDAO;
import com.techelevator.venue.Venue;
import com.techelevator.venue.VenueDAO;

@Component
public class Concierge {

	@Autowired
	private VenueDAO venueDAO;
	@Autowired
	private SpaceDAO spaceDAO;
	@Autowired
	private ReservationDAO reservationDAO;

	public Concierge(DataSource dataSource) {
//		venueDAO = new JDBCVenueDAO(dataSource);
//		spaceDAO = new JDBCSpaceDAO(dataSource);
//		reservationDAO = new JDBCReservationDAO(dataSource);
	}
	
	public Concierge() {
		
	}

	public List<String> getAllVenueNames() {
		List<String> venueNames = new ArrayList<String>();
		List<Venue> allVenues = venueDAO.getAllVenues();
		for (Venue venue : allVenues) {
			String name = venue.getName();
			venueNames.add(name);
		}
		return venueNames;
	}

	public List<Space> getAllSpacesByVenueName(String venueName) {
		List<Space> spaces = spaceDAO.getAllSpacesByVenueName(venueName);
		return spaces;
	}

	public Venue getVenueByName(String venueName) {
		Venue venue = venueDAO.getVenueByName(venueName);
		return venue;
	}

	public String getCategories(String venueName) {
		String categories = venueDAO.getVenueCategories(venueName);
		return categories;
	}

	public LinkedHashMap<Long, Space> getAvailableSpaces(String venueName, int reservationAttendees, LocalDate endDate, LocalDate startDate) {
		LinkedHashMap<Long, Space> spaces = spaceDAO.getCompatibleSpaces(venueName, reservationAttendees, endDate, startDate);
		List<Reservation> invalidReservations = reservationDAO.getInvalidReservations(venueName, startDate, endDate);
		for (Reservation reservation : invalidReservations) {
			spaces.remove(reservation.getSpaceID());
		}
		LinkedHashMap<Long, Space> limitSpaces = new LinkedHashMap<Long, Space>();
		int count = 0;
		for (Map.Entry<Long, Space> entry : spaces.entrySet()) {
			limitSpaces.put(entry.getKey(), entry.getValue());
			count++;
			if (count == 5) {
				return limitSpaces;
			}
		}
		return limitSpaces;
	}

	public long makeReservation(long spaceID, int reservationAttendees, LocalDate startDate, LocalDate endDate, String reservedFor) {
		Reservation newReservation = new Reservation();
		newReservation.setSpaceID(spaceID);
		newReservation.setReservationAttendees(reservationAttendees);
		newReservation.setStartDate(startDate);
		newReservation.setEndDate(endDate);
		newReservation.setReservedFor(reservedFor);
		return reservationDAO.makeReservation(newReservation);
	}

}
