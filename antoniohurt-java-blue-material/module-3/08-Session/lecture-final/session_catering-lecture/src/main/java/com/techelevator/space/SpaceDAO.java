package com.techelevator.space;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

public interface SpaceDAO {

	List<Space> getAllSpacesByVenueName(String venueName);
	LinkedHashMap<Long, Space> getCompatibleSpaces(String venueName, int reservationAttendees, LocalDate endDate, LocalDate startDate);
	
}
