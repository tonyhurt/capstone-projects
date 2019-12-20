package com.techelevator.venue;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCVenueDAO implements VenueDAO {

	private final static String SELECT_VENUE_SQL = "SELECT v.id, v.name, (c.name || ', ' || "
			+ "c.state_abbreviation) as city_state, v.description FROM venue v JOIN city c ON "
			+ "v.city_id = c.id ORDER BY v.name ASC";

	private final static String SELECT_CATEGORIES_SQL = "SELECT string_agg(c.name, ', ') AS concategories FROM category c "
			+ "JOIN category_venue cv ON c.id = cv.category_id JOIN venue v ON v.id = cv.venue_id "
			+ "WHERE v.name = ?";

	private final static String SELECT_VENUE_BY_NAME_SQL = "SELECT v.id, v.name, (c.name || ', ' || c.state_abbreviation) "
			+ "as city_state, v.description FROM venue v JOIN city c ON v.city_id = c.id WHERE v.name = ? "
			+ "ORDER BY v.name ASC";
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCVenueDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Venue> getAllVenues() {
		List<Venue> venues = new ArrayList<Venue>();
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_VENUE_SQL);
		while (rows.next()) {
			Venue venue = mapRowToVenue(rows);
			venues.add(venue);
		}
		return venues;
	}
	
	@Override
	public Venue getVenueByName(String venueName) {
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_VENUE_BY_NAME_SQL, venueName);
		rows.next();
		Venue venue = mapRowToVenue(rows);

		return venue;
	}

	private Venue mapRowToVenue(SqlRowSet row) {
		Venue venue = new Venue();
		venue.setVenueID(row.getLong("id"));
		venue.setName(row.getString("name"));
		venue.setLocation(row.getString("city_state"));
		venue.setDescription(row.getString("description"));
		return venue;
	}

	@Override
	public String getVenueCategories(String venueName) {
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_CATEGORIES_SQL, venueName);
		rows.next();
		String categories = rows.getString("concategories");
		return categories;
	}
}
