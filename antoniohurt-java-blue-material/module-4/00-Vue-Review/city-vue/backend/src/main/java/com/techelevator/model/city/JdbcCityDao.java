package com.techelevator.model.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcCityDao implements CityDao {

	private final static String SQL_SELECT_CITY = "select id, name, countrycode, district, population from city";
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcCityDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<City> getAllCities() {
		List<City> cities = new ArrayList<City>();
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SQL_SELECT_CITY);
		
		while(rows.next()) {
			cities.add(mapRowToCity(rows));
		}
		
		return cities;
	}
	
	@Override
	public List<City> getCitiesByCountryCode(String countryCode) {
		List<City> cities = new ArrayList<City>();
		String sql = SQL_SELECT_CITY + " WHERE countrycode = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, countryCode);
		
		while(rows.next()) {
			cities.add(mapRowToCity(rows));
		}
		
		return cities;
	}
	
	@Override
	public List<City> getCitiesByDistrict(String district) {
		List<City> cities = new ArrayList<City>();
		String sql = SQL_SELECT_CITY + " district = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql,district);
		
		while(rows.next()) {
			cities.add(mapRowToCity(rows));
		}
		
		return cities;
	}
	
	@Override
	public City getCitiesById(int cityId) {
		City city = null;
		String sql = SQL_SELECT_CITY + " WHERE id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, cityId);
		
		while(rows.next()) {
			city = mapRowToCity(rows);
		}
		
		return city;
	}
	
	private City mapRowToCity(SqlRowSet row) {
		City city = new City();
		city.setId(row.getInt("id"));
		city.setName(row.getString("name"));
		city.setCountryCode(row.getString("countrycode"));
		city.setDistrict(row.getString("district"));
		city.setPopulation(row.getInt("population"));
		return city;
	}

}
