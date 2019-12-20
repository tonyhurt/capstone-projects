package com.techelevator.reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO {
	
	List<Reservation> getReservationsBySpaceID(long spaceID);
	long makeReservation(Reservation reservation);
	List<Reservation> getInvalidReservations(String venueName, LocalDate startDate, LocalDate endDate);

}
