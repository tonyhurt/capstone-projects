package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDao;
import com.techelevator.npgeek.model.survey.SurveyResult;

@RestController
@RequestMapping("/api/survey")
@CrossOrigin
public class SurveyRestController {

	@Autowired 
	private SurveyDao surveyDao;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Survey save(@RequestBody Survey survey) {
		surveyDao.insertSurvey(survey);
		return survey;
	}
	
	@GetMapping
	public List<SurveyResult> list() {
		return surveyDao.getSurveyResults();
	}
}
