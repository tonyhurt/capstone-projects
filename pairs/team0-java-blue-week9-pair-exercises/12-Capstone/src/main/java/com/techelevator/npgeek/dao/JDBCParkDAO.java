package com.techelevator.npgeek.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

@Component
public class JDBCParkDAO implements ParkDAO {
	private static final String SELECT_PARKS_SQL = "SELECT park.parkcode, park.parkname, park.state, park.acreage, park.elevationinfeet, park.milesoftrail, park.numberofcampsites, park.climate, park.yearfounded, park.annualvisitorcount, park.inspirationalquote, park.inspirationalquotesource, park.parkdescription, park.entryfee, park.numberofanimalspecies FROM park";
	private static final String SELECT_WEATHER_SQL = "SELECT weather.parkcode, weather.fivedayforecastvalue, weather.low, weather.high, weather.forecast FROM weather";
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public Park getByCode(String code) {
		SqlRowSet result = jdbcTemplate.queryForRowSet(SELECT_PARKS_SQL + " WHERE" + " parkcode = ?", code);

		if (result.next()) {
			return mapRowSetToPark(result);
		}
		return null;
	}

	private Weather mapRowSetToWeather(SqlRowSet results) {
		Weather weather = new Weather();
		weather.setParkCode(results.getString("parkcode"));
		weather.setForecastValue(results.getInt("fivedayforecastvalue"));
		weather.setLow(results.getInt("low"));
		weather.setHigh(results.getInt("high"));
		weather.setForecast(results.getString("forecast"));

		return weather;
	}

	private Park mapRowSetToPark(SqlRowSet results) {
		Park park = new Park();
		park.setParkName(results.getString("parkname"));
		park.setParkCode(results.getString("parkcode"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevation(results.getInt("elevationinfeet"));
		park.setMilesOfTrail((results.getDouble("milesoftrail")));
		park.setNumberOfCampsites(results.getInt("numberofcampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearfounded"));
		park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		park.setInspirationalQuote(results.getString("inspirationalquote"));
		park.setQuoteSource(results.getString("inspirationalquotesource"));
		park.setParkDescription(results.getString("parkdescription"));
		park.setEntryFee(results.getInt("entryfee"));
		park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));

		return park;
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> parks = new ArrayList<Park>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);

		while (results.next()) {
			Park park = mapRowSetToPark(results);
			parks.add(park);

		}
		return parks;

	}

	@Override
	public Weather getWeatherByCode(String code) {
		SqlRowSet result = jdbcTemplate.queryForRowSet(SELECT_WEATHER_SQL + " WHERE" + " parkcode = ?", code);

		if (result.next()) {
			return mapRowSetToWeather(result);
		}
		return null;
	}
	
	@Override
	public List<Weather> getWeatherList(String code) {
		List<Weather> matchingWeather = new ArrayList<>();
		String weatherSearchSql = SELECT_WEATHER_SQL + " WHERE" + " parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(weatherSearchSql, code);
		while (results.next()) {
			matchingWeather.add(mapRowSetToWeather(results));
		}
		
		return matchingWeather;
	}
	
				
}
