package com.techelevator.npgeek;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.dao.SurveyDAO;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyResult;

@Controller
public class SurveyController {

	@Autowired
	private SurveyDAO surveyDao;

	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurveyForm(ModelMap map) {
		map.addAttribute("parkSurvey", new Survey());
		
		return "parkSurvey";

	}
	
	@RequestMapping("/favoriteParks") 
	public String showFavorites(HttpServletRequest req) {
		List<SurveyResult> results = surveyDao.getSurveyResults();
		req.setAttribute("results", results);
		
		return "favoriteParks";
	}

	

	
	

	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String addSurvey(@Valid @ModelAttribute("parkSurvey") Survey survey,
			BindingResult result, 
			RedirectAttributes attr){


		 if(result.hasErrors()) {
		 return "parkSurvey";
		 }
		surveyDao.save(survey);

		return "redirect:/favoriteParks";

	}

}
