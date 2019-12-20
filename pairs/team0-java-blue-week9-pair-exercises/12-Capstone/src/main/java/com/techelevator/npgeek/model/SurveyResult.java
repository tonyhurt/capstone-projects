package com.techelevator.npgeek.model;

public class SurveyResult {
	private String parkCode;
	private int parkCount;

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode.toLowerCase();
	}

	public int getParkCount() {
		return parkCount;
	}

	public void setParkCount(int parkCount) {
		this.parkCount = parkCount;
	}

}
