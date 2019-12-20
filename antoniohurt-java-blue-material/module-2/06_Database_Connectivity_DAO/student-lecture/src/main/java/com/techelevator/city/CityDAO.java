package com.techelevator.city;

import java.util.List;

/*
 * The CityDAO interface defines the CRUD (Create Read Update Delete) operations that
 * the DAO will support and the data types that each operation will take as an argument
 * and return as a result.  The data types used should be the data class created for the
 * DAO pattern, in this case City, or standard Java data types (int, String, etc.)
 */

public interface CityDAO {

	public void save(City newCity);
	public City findCityById(long id);
	public List<City> findCityByCountryCode(String countryCode);
	public List<City> findCityByDistrict(String district);
	public void update(City city);
	public void delete(long id);
}
