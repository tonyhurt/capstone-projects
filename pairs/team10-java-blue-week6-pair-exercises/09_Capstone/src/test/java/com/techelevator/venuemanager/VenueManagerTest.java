package com.techelevator.venuemanager;

import java.time.LocalDate;

import org.junit.*;


public class VenueManagerTest {
	private VenueManager manager;
	
	@Before
	public void setup() {
	manager = new VenueManager();
	}
	
	@Test
	public void get_leaving_date() {
		LocalDate correctDate = LocalDate.of(2019, 11, 01);
		LocalDate leavingOn = manager.getLeavingDate(LocalDate.of(2019, 10, 31), 1);
		Assert.assertEquals(correctDate, leavingOn);
	}
	@Test
	public void get_month_as_long() {
		LocalDate date = LocalDate.of(2019, 11, 01);
		long monthAsLong = manager.getMonthNumber(date);
		Assert.assertEquals(11l, monthAsLong);
		
	}
}
