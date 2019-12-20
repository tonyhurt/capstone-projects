package com.techelevator;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;


@Controller 
public class ReviewController {
	
	@Autowired
	ReviewDao reviewDao;

	@RequestMapping(path = "/ReviewList", method = RequestMethod.GET)
	public String showReviewList(ModelMap modelMap) {
		modelMap.put("ReviewList", reviewDao.getAllReviews());

		return "ReviewList";
	}
	
	@RequestMapping(path = "/reviewPost", method = RequestMethod.GET)
	public String showReviewPost() {
		return "reviewPost";
	}
	@RequestMapping(path = "/reviewPost", method = RequestMethod.POST)
	public String showReviewPost(@ModelAttribute ("username") String username, @ModelAttribute("rating") Integer rating,
			@ModelAttribute ("title") String title, @ModelAttribute ("text") String text) {
		LocalDateTime datePosted = LocalDateTime.now();
		Review review = new Review();
		review.setUsername(username);
		review.setRating(rating);
		review.setTitle(title);
		review.setText(text);
		review.setDateSubmitted(datePosted);
		reviewDao.save(review);

		return "redirect:/ReviewList";
	}



}