package com.techelevator.city;

/*
 * The City class creates a data type to use with the DAO.  
 * This will usually be a basic data class, called a Java Bean, that is usually just data with Getters and Setters
 * though derived properties and other methods may exist in the class.
 */
public class City {
	
	private Long id;
	private String name;
	private String countryCode;
	private String district;
	private int population;

	public Long getId() {
		return id;
	}

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

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district
				+ ", population=" + population + "]";
	}
	
}
