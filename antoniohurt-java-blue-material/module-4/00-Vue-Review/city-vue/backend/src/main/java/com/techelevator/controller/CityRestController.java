package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.city.City;
import com.techelevator.model.city.CityDao;

@RestController
@CrossOrigin
@RequestMapping("/api/cities")
public class CityRestController {

	@Autowired
	private CityDao cityDao;
	
	@GetMapping
	public List<City> list() {
		return cityDao.getAllCities();
	}
	
	@GetMapping("/{countryCode}")
	public List<City> getByCountryCode(@PathVariable String countryCode) {
		return cityDao.getCitiesByCountryCode(countryCode.toUpperCase());
	}
	
	@GetMapping("/region/{region}")
	public List<City> getByDistrict(@PathVariable String region) {
		return cityDao.getCitiesByDistrict(region);
	}

	@GetMapping("/city/{id}")
	public City getById(@PathVariable String id) {
		return cityDao.getCitiesById(Integer.parseInt(id));
	}
	
}
