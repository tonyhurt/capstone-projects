package com.techelevator.npgeek.dao;

import java.util.List;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

public interface ParkDAO {
	
	Park getByCode(String code);

	List<Park> getAllParks();

	Weather getWeatherByCode(String code);

	List<Weather> getWeatherList(String code);
	

}
