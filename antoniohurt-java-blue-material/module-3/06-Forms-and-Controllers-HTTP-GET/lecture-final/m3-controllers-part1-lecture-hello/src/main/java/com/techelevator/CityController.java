package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.city.City;
import com.techelevator.model.city.CityDAO;

@Controller
public class CityController {

	@Autowired
	private CityDAO cityDao;
	
	@RequestMapping("/city")
	public String showCitySearch() {
		return "city/citySearch";
	
	}
	
	@RequestMapping("/searchResults")
	public String searchForCitiesByCountryCode(HttpServletRequest req) {
		
		String countryCode = req.getParameter("countryCode");
		
		List<City> cities = cityDao.findCityByCountryCode(countryCode);
		
		req.setAttribute("cityList", cities);
		
		return "city/cityResults";
	}
	
}
