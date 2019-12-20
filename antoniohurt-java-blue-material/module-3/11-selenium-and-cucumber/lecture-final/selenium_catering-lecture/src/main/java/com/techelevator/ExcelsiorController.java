package com.techelevator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.reservation.Reservation;
import com.techelevator.space.Space;
import com.techelevator.utility.TypeConverter;

@Controller
public class ExcelsiorController {
	
	@Autowired
	private Concierge concierge;

	@Autowired
	private TypeConverter tc;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(ModelMap map) {
		
		List<String> venueList = concierge.getAllVenueNames();
		map.addAttribute("venues", venueList);
		
		return "homePage";
	}
	
	
	@RequestMapping(path="/venue", method=RequestMethod.GET)
	public String showVenueSpaces(@RequestParam String venueName, ModelMap map) {
		
		List<Space> venueSpaces = concierge.getAllSpacesByVenueName(venueName);
		map.addAttribute("spaces", venueSpaces);
		
		return "venueSpaces";
	}
	
	@RequestMapping(path="/availableSpaces", method=RequestMethod.GET)
	public String showAvailableSpaces(@RequestParam String venueName, 
			@RequestParam int attendees, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate startDate, 
			@RequestParam int duration, ModelMap map) {
		
		LocalDate endDate = tc.getEndDate(startDate, duration);
		
		Map<Long, Space> spaces = concierge.getAvailableSpaces(venueName, attendees, endDate, startDate);
		map.addAttribute("spaces", spaces);
		map.addAttribute("venueName", venueName);
		
		Reservation reservation = new Reservation();
		reservation.setReservationAttendees(attendees);
		reservation.setStartDate(startDate);
		reservation.setEndDate(endDate);
		
		map.addAttribute("reservation", reservation);
		
		return "availableSpaces";
	}
	
	@RequestMapping(path="/booking", method=RequestMethod.POST)
	public String makeReservation(@RequestParam String reservedFor, @RequestParam Long spaceId, 
			@RequestParam String venueName, @RequestParam int attendees, 
			@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate endDate)
	{
		
		long reservationId = concierge.makeReservation(spaceId, attendees, startDate, endDate, reservedFor);
		
		return "redirect:/thankyou";
	}
	
	@RequestMapping(path="/thankyou", method=RequestMethod.GET)
	public String showThankyou() {
		return "thankYou";
	}
	
	
	
}
