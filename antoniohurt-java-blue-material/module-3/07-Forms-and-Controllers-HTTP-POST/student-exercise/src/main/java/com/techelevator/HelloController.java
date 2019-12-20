package com.techelevator;

import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.JdbcReviewDao;
import com.techelevator.model.Review;

@Controller
public class HelloController {
	
	@Autowired
	JdbcReviewDao ReviewDao;

	@RequestMapping("/greeting")
	public String displayGreeting() {

		return "greeting";
	}
	
	@RequestMapping(path="/reviewList", method=RequestMethod.POST)
	public String pressReviews(Review review, HttpServletRequest request) {
		review.setDateSubmitted((LocalDateTime.now()));
		ReviewDao.save(review);
		
		return "redirect:/reviewList";
	}
	
	@RequestMapping(path="/reviewList")
	public String showReviews( HttpServletRequest request) {
		request.setAttribute("reviews", ReviewDao.getAllReviews());
		
		return "reviewList";
	}
}
