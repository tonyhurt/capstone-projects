package com.techelevator.addressbook.dao;

import java.time.LocalDate;

public class Contact {

	private long contactId;
	private String firstName;
	private String lastName;
	private LocalDate dateAdded;
	private LocalDate lastUpdated;
	
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public LocalDate getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateAdded=" + dateAdded + ", lastUpdated=" + lastUpdated + "]";
	}
	
}
