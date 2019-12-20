package com.techelevator;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller
public class DummiesController {

	@Autowired
	private ReviewDao reviewDao;

	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayDummiesPage(ModelMap map) {
		
		List<Review> reviews = reviewDao.getAllReviews();
		map.addAttribute("reviews", reviews);
		
		return "showReviews";
	}
	
	
	@RequestMapping(path="/addReview", method=RequestMethod.GET)
	public String displayAddReviewPage(ModelMap map) {	
		return "addReviews";
	}
	
	
	@RequestMapping(path="/saveReview", method=RequestMethod.POST)
	public String saveUserReview(Review review) {
		
		review.setDateSubmitted(LocalDateTime.now());
		reviewDao.save(review);
		
		return "redirect:/";
	}
	
}
