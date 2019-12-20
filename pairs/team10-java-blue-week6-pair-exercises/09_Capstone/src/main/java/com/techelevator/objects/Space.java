package com.techelevator.objects;

import java.math.BigDecimal;

public class Space {
	private long id;
	private long venueId;
	private String name;
	private boolean isAccessible;
	private long openFrom;
	private long openTo;
	private BigDecimal dailyCost;
	private long maxOccupancy;
	private String venueName;
	
	public String getVenueName() {
		return venueName;
	}
	
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getVenueId() {
		return venueId;
	}
	public void setVenueId(long venueId) {
		this.venueId = venueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String isAccessible() {
		if (isAccessible) {
			return "Yes";
		}
		return "No";
	}
	public void setAccessible(boolean isAccessible) {
		this.isAccessible = isAccessible;
	}
	public long getOpenFrom() {
		return openFrom;
	}
	public void setOpenFrom(long openFrom) {
		this.openFrom = openFrom;
	}
	public long getOpenTo() {
		return openTo;
	}
	public void setOpenTo(long openTo) {
		this.openTo = openTo;
	}
	public BigDecimal getDailyCost() {
		return dailyCost;
	}
	public void setDailyCost(BigDecimal bigDecimal) {
		this.dailyCost = bigDecimal;
	}
	public long getMaxOccupancy() {
		return maxOccupancy;
	}
	public void setMaxOccupancy(long maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	
	
	
	
	

}
