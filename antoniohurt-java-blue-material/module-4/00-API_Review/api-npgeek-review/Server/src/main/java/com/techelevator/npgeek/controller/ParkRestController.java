package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.npgeek.ParkNotFoundException;
import com.techelevator.npgeek.model.TemperatureScale;
import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.weather.ParkWeather;
import com.techelevator.npgeek.model.weather.ParkWeatherDao;

@RestController
@RequestMapping("/api/park")
@CrossOrigin
public class ParkRestController {

	@Autowired
	private ParkDao parkDao;
	
	@Autowired
	private ParkWeatherDao weatherDao;
	
	@GetMapping
	public List<Park> list() {
		return parkDao.getAllParks();
	}
	
	@GetMapping("/{parkCode}")
	public Park get(@PathVariable String parkCode) {
		Park park = parkDao.getParkByParkCode(parkCode);
		if (park == null) {
			throw new ParkNotFoundException(parkCode, "Park not Found");
		}
		return park;
	}
	
	@GetMapping("/{parkCode}/weather/{scale}")
	public ParkWeather getWeather(@PathVariable String parkCode, @PathVariable String scale) {
		
		if (parkDao.getParkByParkCode(parkCode) == null) {
			throw new ParkNotFoundException(parkCode, "Park not Found");
		}
		
		TemperatureScale tempScale = new TemperatureScale();
		if (scale.equalsIgnoreCase("C")) {
			tempScale.setCelsius(true);
		}
		
		return weatherDao.getParkWeatherByParkCode(new ParkWeather(parkCode, tempScale));
	}
	
	
	
	
}
