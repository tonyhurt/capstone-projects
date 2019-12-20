package com.techelevator.npgeek;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.dao.ParkDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

//instantiate park dao
//create list of all park objects
//request attribute / model map.

@Controller
public class ParkController {

	@Autowired
	private ParkDAO parkDao;

	@RequestMapping("/")
	public String displayHomePage(HttpServletRequest req) {
		List<Park> parks = parkDao.getAllParks();
		req.setAttribute("parks", parks);

		return "homePage";
	}
	
	@RequestMapping("/details")
	public String showParkDetails(HttpServletRequest req) {
		String parkId = req.getParameter("parkcode").toUpperCase();
		Weather weather = parkDao.getWeatherByCode(parkId);
		Park parks = parkDao.getByCode(parkId);
		req.setAttribute("parks", parks);
		req.setAttribute("weather", weather);
		req.setAttribute("listOfWeather", parkDao.getWeatherList(parkId));
		
		return "parkDetails";
	}
}
