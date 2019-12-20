package com.techelevator.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.City;
import com.techelevator.model.Country;

@Component
public class JDBCCityDao implements CityDAO {

	private JdbcTemplate db;
	
	public JDBCCityDao(DataSource dataSource) {
		db = new JdbcTemplate(dataSource);
	}

	@Override
	public List<City> getAllCitiesByCountryCode(String countryCode) {
		String sql = "SELECT name FROM city WHERE countryCode = ?";
		SqlRowSet rows = db.queryForRowSet(sql, countryCode);
		List<City> cities = new ArrayList<City>();
		while (rows.next()) {
			cities.add(new City(rows.getString("name")));
		}
		return cities;
	}

	@Override
	public List<Country> getAllCountries() {
		String sql = "SELECT code, name FROM country ORDER BY name ASC";
		SqlRowSet rows = db.queryForRowSet(sql);
		List<Country> countries = new ArrayList<Country>();
		while (rows.next()) {
			countries.add(new Country(rows.getString("name"), rows.getString("code")));
		}
		return countries;
	}
	
}
