package com.techelevator.ssg.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.calculator.Calculator;
import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;

@Controller
public class HomeController {

	private Calculator calculator = new Calculator();

	@Autowired
	private ForumDao forumDao;
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}

	@RequestMapping("/alienAge")
	public String displayAlienAgePage() {

		return "alienAge";
	}

	@RequestMapping("/alienAgeResults")
	public String displayAges(HttpServletRequest req) {

		String planet = req.getParameter("planets");

		String userAge = req.getParameter("userAge");
		Long userAgeLong = Long.parseLong(userAge);

		Map<String, Double> ages = calculator.calculateAlienAge(userAgeLong);
		double newAge = ages.get(planet);

		req.setAttribute("newAge", newAge);

		return "alienAgeResults";
	}

	@RequestMapping("/alienWeightResults")
	public String displayWeights(HttpServletRequest req) {

		String planet = req.getParameter("planets");

		String userWeight = req.getParameter("userWeight");
		int userWeightInt = Integer.parseInt(userWeight);

		Map<String, Double> weights = calculator.calculateAlienWeight(userWeightInt);
		double newWeight = weights.get(planet);

		req.setAttribute("newWeight", newWeight);

		return "alienWeightResults";
	}

	@RequestMapping("/driveTimeResults")
	public String displayDriveTimes(HttpServletRequest req) {

		String planet = req.getParameter("planets");

		String transportation = req.getParameter("transportation");

		Map<String, Long> travelTimes = calculator.calculateDriveTime(transportation, planet);
		long newTravelTime = travelTimes.get(planet);

		req.setAttribute("newTravelTime", newTravelTime);

		String userAge = req.getParameter("userAge");
		int userAgeInt = Integer.parseInt(userAge);

		long newTravelTimePlusAge = (long) (userAgeInt + newTravelTime);
		Map<String, Double> ages = calculator.calculateAlienAge(newTravelTimePlusAge);
		double newAge = ages.get(planet);

		req.setAttribute("newAge", newAge);

		return "driveTimeResults";

	}

	@RequestMapping("/alienWeight")
	public String displayAlienWeightPage() {
		return "alienWeight";
	}

	@RequestMapping("/driveTime")
	public String displayDriveTimePage() {
		return "driveTime";
	}

	@RequestMapping("/spaceForum")
	public String displaySpaceForumPage() {
		return "spaceForum";
	}

	@RequestMapping(path = "/postToSpaceForum", method = RequestMethod.POST)
	public String postToSpaceForum(ForumPost post) {

		post.setDatePosted(LocalDateTime.now());
		forumDao.save(post);

		return "redirect:/spaceForum";
	}
	
	@RequestMapping(path = "/spaceStore")
	public String displaySpaceStore(ModelMap map) {
		List<Product> productList = productDao.getAllProducts();
		map.addAttribute("productList", productList);
		return "spaceStore";
	}
}
