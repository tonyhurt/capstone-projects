package com.techelevator;

import com.techelevator.npgeek.dao.JDBCParkDAO;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;

public abstract class DAOIntegrationTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	
	private JDBCParkDAO dao;
	private JdbcTemplate jdbcTemplate;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/* This method provides access to the DataSource for subclasses so that
	 * they can instantiate a DAO for testing */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	
	
	@Before
	public void setup() {
		String sqlInsertSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (DEFAULT, ?, ?, ?, ?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertSurvey, 1000, "ENP", "a@a.com", "NC", "Sedentary");
		dao = new JDBCParkDAO(dataSource);
		
	}

	@Test 
	public void get_all_parks() {
		Park parkOne = getNewPark();
		parkOne.setParkName("testNP");
		String sql = "SELECT COUNT (*) AS numberOfRows FROM park";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		rows.next();
		int originalRowCount = rows.getInt("numberOfRows");
		
		createPark("test park");
		
		List<Park> returnedParks = dao.getAllParks();
		Assert.assertNotNull(returnedParks);
		Assert.assertEquals(originalRowCount + 1, returnedParks.size());
	
	}
	
	@Test
	public void get_park_by_code() {
		Park parkOne = getNewPark();
		parkOne.setParkCode("abc");
		parkOne.setParkName("abc park");
		Park savedPark = dao.getByCode("abc");
		
		Assert.assertEquals("abc park", savedPark.getParkName());

	}
	
	@Test
	public void get_weather_list() {
		
	}
	
	private Park getNewPark() {
		Park park = new Park();
		park.setAcreage(100);
		park.setAnnualVisitorCount(100);
		park.setClimate("warm");
		park.setElevation(1000);
		park.setEntryFee(350);
		park.setInspirationalQuote("quote");
		park.setMilesOfTrail(100);
		park.setNumberOfAnimalSpecies(1000);
		park.setNumberOfCampsites(100);
		park.setParkCode("anp");
		park.setParkDescription("description");
		park.setParkName("national park");
		park.setQuoteSource("chuck e. cheese");
		park.setState("NY");
		park.setYearFounded(2020);
		
		return park;
		
	}	
	
	private Survey getNewSurvey() {
		Survey survey = new Survey();
		survey.setActivityLevel("Sedentary");
		survey.setEmail("a@a.com");
		survey.setParkCode("anp");
		survey.setState("OH");
		survey.setSurveyId(1000);
		
		return survey;
	}
	
	private void createPark(String parkName) {
		Park park = new Park();
		String sqlInsert = "INSERT INTO  park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) VALUES (100, ?, 'ohio', 3500, 1000, 125, 10, 'woodland', 2020, 10, 'this is quote', 'john doe', 'description', '1', '100')";
		jdbcTemplate.update(sqlInsert, parkName);
	}
	
}
