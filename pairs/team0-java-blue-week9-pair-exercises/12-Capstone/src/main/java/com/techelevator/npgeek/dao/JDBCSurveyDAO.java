package com.techelevator.npgeek.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyResult;

@Component
public class JDBCSurveyDAO implements SurveyDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void JDBCReviewDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Survey post) {
		// int id = getNextId();

		String sqlInsertResult = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (DEFAULT, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertResult, post.getParkCode(), post.getEmail(), post.getState(),
				post.getActivityLevel());
		// post.setSurveyId(id);

	}

	private SurveyResult mapRowSetToSurveyResult(SqlRowSet results) {
		SurveyResult surveyResult = new SurveyResult();
		surveyResult.setParkCode(results.getString("park_code"));
		surveyResult.setParkCount(results.getInt("park_count"));

		return surveyResult;
	}

	@Override
	public List<SurveyResult> getSurveyResults() {
		List<SurveyResult> results = new ArrayList<SurveyResult>();
		String sqlSelectSurveyResults = "SELECT survey_result.parkcode AS park_code, COUNT(park.parkcode) AS park_count FROM survey_result"
				+ " JOIN park ON survey_result.parkcode = park.parkcode" + " GROUP BY survey_result.parkcode"
						+ " ORDER BY park_code, park_count";
		SqlRowSet query = jdbcTemplate.queryForRowSet(sqlSelectSurveyResults);

		while (query.next()) {
			SurveyResult surveyResult = mapRowSetToSurveyResult(query);
			results.add(surveyResult);
		}
		return results;
	}

}
