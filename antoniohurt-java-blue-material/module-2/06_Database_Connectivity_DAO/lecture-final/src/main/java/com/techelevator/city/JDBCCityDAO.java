package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/*
 * The CityDAO implementation class provides the SQL functionality wrapped in methods using
 * SpringJDBC.   
 */
public class JDBCCityDAO implements CityDAO {

	/*
	 * A SpringJDBC JdbcTemplate to be used by the class.
	 */
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * The constructor should take a DataSource as an argument to decouple the 
	 * actual connection properties from the DAO.   It will then create the JdbcTemplate 
	 * which will establish the connection.  This is done in the constructor so the connections
	 * can be maintained for the life of the class, which is more efficient than reconnecting for
	 * each method call.  
	 */
	public JDBCCityDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(City newCity) {
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		jdbcTemplate.update(sqlInsertCity, newCity.getId(),
										  newCity.getName(),
										  newCity.getCountryCode(),
										  newCity.getDistrict(),
										  newCity.getPopulation());
	}
	
	@Override
	public City findCityById(long id) {
		City theCity = null;
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if(results.next()) {
			theCity = mapRowToCity(results);
		}
		return theCity;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * A private method that uses SELECT nextval() to get the next sequence value for the id.  
	 * This method can be excluded if the RETURNING statement is used. 
	 */
	private long getNextCityId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	/*
	 * Creating a City object from a SqlRowSet will be a common need, so this 
	 * private method eliminates the need to duplicate the code.   
	 * 
	 * IMPORTANT:  Every row being mapped to the object MUST be returned in the Query results.  If
	 *             the query used does not exactly match the expected columns then either the query
	 *             needs to include those values, or another mapper method may be needed.  
	 *             
	 *  		   It is best practice to return all rows being mapped to the object in every query.  This
	 *             reduces the need to keep track of which method returned the data object and know
	 *             which rows it maps.
	 */
	private City mapRowToCity(SqlRowSet results) {
		City theCity;
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}
}
