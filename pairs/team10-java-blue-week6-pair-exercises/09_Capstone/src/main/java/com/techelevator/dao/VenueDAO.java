package com.techelevator.dao;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.objects.Space;
import com.techelevator.objects.Venue;

public interface VenueDAO {
	//methods needed
	
	public List<Venue> findAllVenues();
	
	public Venue getSpecificVenue(long venueId);
	
	public List<Space> getVenueSpaces(long venueId);
	
	public Space viewSpecificSpace(long spaceId);
	
	public long makeReservation(long spaceId, long numberOfAttendees, LocalDate startDate, LocalDate endDate, String reservedFor);
	
	
	
	
	
	
}
