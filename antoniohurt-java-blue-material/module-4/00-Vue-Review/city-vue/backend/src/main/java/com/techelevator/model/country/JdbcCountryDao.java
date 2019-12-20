package com.techelevator.model.country;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcCountryDao implements CountryDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcCountryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>();
		String sql = "select code, name, continent, region from country "
				+ "ORDER BY continent, region, name";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		
		while(rows.next()) {
			countries.add(mapRowToCountry(rows));
		}
		
		return countries;
	}
	
	@Override
	public List<SelectListItem> getAllCountryCodeForSelection() {
		List<SelectListItem> countries = new ArrayList<SelectListItem>();
		String sql = "select code, name from country "
				+ "ORDER BY name";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		
		while(rows.next()) {
			countries.add(new SelectListItem(rows.getString("code"), rows.getString("name")));
		}
		
		return countries;
	}
	
	@Override
	public List<SelectListItem> getAllRegionsForCountryCode(String CountryCode) {
		List<SelectListItem> countries = new ArrayList<SelectListItem>();
		String sql = "select region from country "
				+ "ORDER BY region";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		
		while(rows.next()) {
			countries.add(new SelectListItem(rows.getString("region"), rows.getString("region")));
		}
		
		return countries;
	}
	
	private Country mapRowToCountry(SqlRowSet row) {
		Country country = new Country();
		country.setCountryCode(row.getString("code"));
		country.setName(row.getString("name"));
		country.setContinent(row.getString("continent"));
		country.setRegion(row.getString("region"));
		return country;
	}

}
