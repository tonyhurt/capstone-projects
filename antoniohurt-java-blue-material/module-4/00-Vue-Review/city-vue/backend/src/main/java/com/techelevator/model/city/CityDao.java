package com.techelevator.model.city;

import java.util.List;

public interface CityDao {

	List<City> getAllCities();
	List<City> getCitiesByCountryCode(String countryCode);
	List<City> getCitiesByDistrict(String district);
	City getCitiesById(int cityId);
}
