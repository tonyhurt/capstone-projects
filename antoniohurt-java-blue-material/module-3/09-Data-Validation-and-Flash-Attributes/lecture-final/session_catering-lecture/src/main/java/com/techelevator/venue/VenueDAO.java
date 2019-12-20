package com.techelevator.venue;

import java.util.List;

public interface VenueDAO {

	List<Venue> getAllVenues();
	String getVenueCategories(String venueName);
	Venue getVenueByName(String venueName);
}
