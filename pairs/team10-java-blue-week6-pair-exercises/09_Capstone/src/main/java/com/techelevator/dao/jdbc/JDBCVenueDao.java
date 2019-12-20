package com.techelevator.dao.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.dao.VenueDAO;
import com.techelevator.objects.Space;
import com.techelevator.objects.Venue;

public class JDBCVenueDao implements VenueDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCVenueDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Venue> findAllVenues() {
		String selectSql = "SELECT venue.id, venue.name, description, STRING_AGG(category.name, ', ') as categories, city.name as cityname, city.state_abbreviation as state FROM venue LEFT JOIN city ON city_id = city.id LEFT JOIN category_venue ON venue_id = venue.id LEFT JOIN category ON category.id = category_id GROUP BY venue.id, cityname, state ORDER BY name ";

		SqlRowSet rows = jdbcTemplate.queryForRowSet(selectSql);
		List<Venue> foundVenues = new ArrayList<Venue>();

		while (rows.next()) {
			Venue venue = mapRowToVenue(rows);
			foundVenues.add(venue);
		}

		return foundVenues;
	}

	@Override
	public Venue getSpecificVenue(long venueId) {
		String selectSql = "SELECT venue.id, venue.name, description, STRING_AGG(category.name, ', ') as categories, city.name as cityname, city.state_abbreviation as state FROM venue LEFT JOIN city ON city_id = city.id LEFT JOIN category_venue ON venue_id = venue.id LEFT JOIN category ON category.id = category_id WHERE venue.id = ? GROUP BY venue.id, cityname, state";

		SqlRowSet rows = jdbcTemplate.queryForRowSet(selectSql, venueId);
		Venue venue = new Venue();
		while (rows.next()) {
			venue = mapRowToVenue(rows);

		}
		return venue;
	}

	@Override
	public List<Space> getVenueSpaces(long venueId) {
		String selectSql = "SELECT id, venue_id, name, is_accessible, open_from, open_to, max_occupancy, daily_rate::decimal FROM space WHERE venue_id = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(selectSql, venueId);
		List<Space> spaces = new ArrayList<Space>();

		while (row.next()) {
			Space space = new Space();

			space.setId(row.getLong("id"));
			space.setVenueId(row.getLong("venue_id"));
			space.setName(row.getString("name"));
			space.setAccessible(row.getBoolean("is_accessible"));
			space.setOpenFrom(row.getLong("open_from"));
			space.setOpenTo(row.getLong("open_to"));
			space.setDailyCost(row.getBigDecimal("daily_rate"));
			space.setMaxOccupancy(row.getLong("max_occupancy"));

			spaces.add(space);
		}

		return spaces;
	}

	@Override
	public Space viewSpecificSpace(long spaceId) {
		String selectSql = "SELECT space.id, venue.name As venue_name, space.name, is_accessible, open_from, open_to, max_occupancy, daily_rate::decimal " + 
				"FROM space " + 
				"JOIN venue ON space.venue_id = venue.id " + 
				"WHERE space.id = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(selectSql, spaceId);
		Space space = new Space();
		while (row.next()) {
			space.setId(row.getLong("id"));
			space.setName(row.getString("name"));
			space.setAccessible(row.getBoolean("is_accessible"));
			space.setOpenFrom(row.getLong("open_from"));
			space.setOpenTo(row.getLong("open_to"));
			space.setDailyCost(row.getBigDecimal("daily_rate"));
			space.setMaxOccupancy(row.getLong("max_occupancy"));
			space.setVenueName(row.getString("venue_name"));
		}
		return space;
	}

	public List<Space> availableSpaces(long daysStaying, long venueId, long numberOfPeople, long monthStart,
			long monthEnd, LocalDate startDate, LocalDate endDate){
		String selectSql = "SELECT space.id as space_number, name, daily_rate::decimal, max_occupancy, is_accessible "
		+ "FROM space " 
		+ "JOIN reservation ON space.id = space_id " 
		+ "WHERE venue_id = ? AND max_occupancy > ? AND (open_from <= ? OR open_from IS null) " 
		+ "AND (open_to >= ? OR open_from IS null) " 
		+ "AND NOT (? >= reservation.start_date AND end_date >= ?) "
		+ "GROUP BY space_number "
		+ "LIMIT 5";
		
		SqlRowSet row = jdbcTemplate.queryForRowSet(selectSql, venueId, numberOfPeople, monthStart,
				 monthEnd, startDate, endDate);
		List<Space> availableSpaces = new ArrayList<Space>();

		while (row.next()) {
			Space space = new Space();
			space.setId(row.getLong("space_number"));
			space.setName(row.getString("name"));
			space.setAccessible(row.getBoolean("is_accessible"));
			space.setDailyCost(row.getBigDecimal("daily_rate"));
			space.setMaxOccupancy(row.getLong("max_occupancy"));  
			
			availableSpaces.add(space);
		}
		
		return availableSpaces;
		
	}

	@Override
	public long makeReservation(long spaceId, long numberOfAttendees, LocalDate startDate, LocalDate endDate,
			String reservedFor) {

		String reservationSql = "INSERT INTO reservation (space_id, number_of_attendees, start_date, end_date, reserved_for) VALUES (?, ?, ?, ?, ?) RETURNING reservation_id";
		SqlRowSet row = jdbcTemplate.queryForRowSet(reservationSql, spaceId, numberOfAttendees, startDate, endDate,
				reservedFor);
		row.next();
		long reservationId = row.getLong("reservation_id");
		return reservationId;
	}

	private Venue mapRowToVenue(SqlRowSet row) {
		Venue venue = new Venue();

		venue.setId(row.getLong("id"));
		venue.setName(row.getString("name"));
		venue.setDescription(row.getString("description"));
		venue.setCityName(row.getString("cityname"));
		venue.setState(row.getString("state"));
		if (row.getString("categories") == null) {
			venue.setCategorieNames("");
		} else {
			venue.setCategorieNames(row.getString("categories"));
		}

		return venue;
	}

}
