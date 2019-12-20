package com.techelevator.objects;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reservation {

	private long confirmationNumber;
	private String venue;
	private String space;
	private String reservedFor;
	private long attendees;
	private LocalDate arrivalDate;
	private LocalDate departDate;
	private BigDecimal totalCost;

	public long getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(long confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public String getReservedFor() {
		return reservedFor;
	}

	public void setReservedFor(String reservedFor) {
		this.reservedFor = reservedFor;
	}

	public long getAttendees() {
		return attendees;
	}

	public void setAttendees(long attendees) {
		this.attendees = attendees;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartDate() {
		return departDate;
	}

	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

}
