package com.techelevator.reservation;

import java.time.LocalDate;

public class Reservation {
	
	private long reservationID;
	private long spaceID;
	private int reservationAttendees;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reservedFor;
	
	public long getReservationID() {
		return reservationID;
	}
	public void setReservationID(long reservationID) {
		this.reservationID = reservationID;
	}
	public long getSpaceID() {
		return spaceID;
	}
	public void setSpaceID(long spaceID) {
		this.spaceID = spaceID;
	}
	public int getReservationAttendees() {
		return reservationAttendees;
	}
	public void setReservationAttendees(int reservationAttendees) {
		this.reservationAttendees = reservationAttendees;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getReservedFor() {
		return reservedFor;
	}
	public void setReservedFor(String reservedFor) {
		this.reservedFor = reservedFor;
	}

}
