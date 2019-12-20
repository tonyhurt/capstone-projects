package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.city.City;

@Controller
public class CityController {

	@RequestMapping("/city")
	public String showCitySearch() {
		return "city/citySearch";

	}

	@RequestMapping("/searchResults")
	public String searchForCityBYCountryCode(HttpServletRequest req) {

		String countryCode = req.getParameter("countryCode");
		
		List<City> cities = cityDao.findCityByCountryCode(countryCode);
		
		req.setAttribute("cityList", cities);

		return "city/cityResults";

	}

}
