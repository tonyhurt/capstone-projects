package com.techelevator.objects;

public class Venue {
	
	private long id;
	private String name;
	private long city_id;
	private String description;
	private String cityName;
	private String state;
	private String categorieNames;
	
	public String getCategorieNames() {
		return categorieNames;
	}
	public void setCategorieNames(String categorieNames) {
		this.categorieNames = categorieNames;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity_id(long city_id) {
		this.city_id = city_id;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getCity_id() {
		return city_id;
	}

	public String getDescription() {
		return description;
	}
	
	

}
