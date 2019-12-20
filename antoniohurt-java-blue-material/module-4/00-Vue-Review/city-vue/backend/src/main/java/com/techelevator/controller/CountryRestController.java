package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.country.Country;
import com.techelevator.model.country.CountryDao;
import com.techelevator.model.country.SelectListItem;

@RestController
@CrossOrigin
@RequestMapping("/api/countries")
public class CountryRestController {


	@Autowired
	private CountryDao countryDao;
	
	@GetMapping
	public List<Country> list() {
		return countryDao.getAllCountries();
	}
	
	@GetMapping("/codes") 
	public List<SelectListItem> getCountryCodesForSelect() {
		return countryDao.getAllCountryCodeForSelection();
	}
	
	@GetMapping("/codes/{countryCode") 
	public List<SelectListItem> getCountryCodesForSelect(@PathVariable String countryCode) {
		return countryDao.getAllRegionsForCountryCode(countryCode);
	}

}
