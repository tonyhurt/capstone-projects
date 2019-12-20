package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.model.City;
import com.techelevator.model.Country;

public interface CityDAO {

	List<City> getAllCitiesByCountryCode(String countryCode);
	
	List<Country> getAllCountries();
}
