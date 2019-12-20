package com.techelevator.dao.model;

import org.hibernate.validator.constraints.NotBlank;

public class City {
	
	private Long id;
	
	@NotBlank(message="City Name is Required")
	private String name;
	private String countryCode;
	
	private String district;
	private int population;
	
	
	@NotBlank(message="City Name is Required")
	private String name;
	private String countryCode;
}

	public Long getId() {
		return id;
		

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
}
