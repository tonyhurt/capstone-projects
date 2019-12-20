package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.techelevator.model.City;
import com.techelevator.model.dao.CityDAO;

@Controller
public class HomeController {

	@Autowired
	private CityDAO cityDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(ModelMap map, @RequestParam(required=false) String countryCode) {
	
		map.addAttribute("countries", cityDao.getAllCountries());
		
		if (countryCode != null && countryCode.length() > 0) {
			List<City> cityList = cityDao.getAllCitiesByCountryCode(countryCode);
			map.addAttribute("cities", cityList);
			map.addAttribute("selectedCountry", countryCode);
		}

		
		return "homePage";
	}
}
