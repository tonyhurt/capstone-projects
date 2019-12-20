package com.techelevator.npgeek.dao;

import java.util.List;

import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyResult;

public interface SurveyDAO {
	
	public void save(Survey post);

	List<SurveyResult> getSurveyResults();

}
