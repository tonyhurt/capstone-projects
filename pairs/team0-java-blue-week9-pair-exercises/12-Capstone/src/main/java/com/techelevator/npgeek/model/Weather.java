package com.techelevator.npgeek.model;

public class Weather {
	private String parkCode;
	private int forecastValue;
	private int low;
	private int high;
	private String forecast;

	


	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getForecastValue() {
		return forecastValue;
	}

	public void setForecastValue(int forecastValue) {
		this.forecastValue = forecastValue;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

}
