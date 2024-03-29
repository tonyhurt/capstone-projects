package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.model.Trip;

@Component
public class JDBCTripDAO implements TripDAO
{
	private JdbcTemplate db;
	
	@Autowired
	public JDBCTripDAO(DataSource dataSource) {
		this.db = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Trip> getAllTrips() {
		String sql = "SELECT id, name, description, start_date, end_date, miles, type FROM trips";
		SqlRowSet rows = db.queryForRowSet(sql);
		
		List<Trip> trips = new ArrayList<Trip>();
		while(rows.next()) {
			trips.add(mapRowToTrip(rows));
		}
		
		return trips;
	}

	@Override
	public void save(Trip trip) {
		String sql =  "INSERT INTO trips (id, name, description, start_date, end_date, miles, type) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING id";
		Integer id = db.queryForObject(sql, Integer.class, trip.getName(), trip.getDescription(), trip.getStartDate(), trip.getEndDate(), trip.getMiles(), trip.getType());
		trip.setId(id);
	}
	
	private Trip mapRowToTrip(SqlRowSet row) {
		Trip trip = new Trip();
		
		trip.setId(row.getInt("id"));
		trip.setName(row.getString("name"));
		trip.setDescription(row.getString("description"));
		
		if (row.getDate("start_date") != null) {
			trip.setStartDate(row.getDate("start_date").toLocalDate());
		}
		
		if (row.getDate("end_date") != null) {
			trip.setEndDate(row.getDate("end_date").toLocalDate());
		}
		trip.setMiles(row.getInt("miles"));
		trip.setType(row.getString("type"));
		
		return trip;
	}

}
