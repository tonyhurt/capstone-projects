package com.techelevator.venue;

public class Venue {
	
	private long venueID;
	private String name;
	private String location;
	private String description;
	
	public long getVenueID() {
		return venueID;
	}
	public void setVenueID(long venueID) {
		this.venueID = venueID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
