package com.techelevator.dao.jdbc;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.*;
import org.junit.rules.TestName;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.objects.Space;
import com.techelevator.objects.Venue;

public class JDBCVenueDaoIntegrationTest extends DAOIntegrationTest {

	private JDBCVenueDao dao;
	private JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {
		dao = new JDBCVenueDao(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());
	}

	@Test
	public void get_all_venues() {
		String sqlCommand = "truncate venue CASCADE";
		
		jdbcTemplate.update(sqlCommand);

		String insertSql = "INSERT INTO venue (id, name, city_id, description) VALUES (DEFAULT, ?, ?, ?) RETURNING venue.id";
		SqlRowSet row = jdbcTemplate.queryForRowSet(insertSql, "testName", 1l, "testDescription");
		long venueId;
		row.next();
		venueId = row.getLong("id");
		String insertSql2 = "INSERT INTO category_venue (venue_id, category_id) VALUES (?, ?)";
		jdbcTemplate.update(insertSql2, venueId, 1);
		
		List<Venue> returnedVenues = dao.findAllVenues();

		Assert.assertEquals(1, returnedVenues.size());

	}

	@Test
	public void get_specific_venue() {
		String insertSql = "INSERT INTO venue (id, name, city_id, description) VALUES (DEFAULT, ?, ?, ?) RETURNING venue.id";
		SqlRowSet row = jdbcTemplate.queryForRowSet(insertSql, "testName", 1l, "testDescription");
		long venueId;
		row.next();
		venueId = row.getLong("id");
		String insertSql2 = "INSERT INTO category_venue (venue_id, category_id) VALUES (?, ?)";
		jdbcTemplate.update(insertSql2, venueId, 1);

		Venue venue = dao.getSpecificVenue(venueId);
		
		Assert.assertEquals("testName", venue.getName());
	}

	@Test
	public void get_all_spaces_from_venue() {
		String sqlCommand = "truncate space CASCADE";
		jdbcTemplate.update(sqlCommand);
		
		String insertSql = "INSERT INTO space (venue_id, name, is_accessible, daily_rate, max_occupancy) VALUES (1, 'testSpace', true, 1000, 100) RETURNING venue_id";
		SqlRowSet row = jdbcTemplate.queryForRowSet(insertSql);
		row.next();
		long venueId = row.getLong("venue_id");
		List<Space> spaces = dao.getVenueSpaces(venueId);
		Assert.assertEquals(1, spaces.size());
	}
	
	@Test
	public void get_specific_space() {
		String insertSql = "INSERT INTO space (venue_id, name, is_accessible, daily_rate, max_occupancy) VALUES (1, 'testSpace', true, 1000, 100) RETURNING id";
		SqlRowSet row = jdbcTemplate.queryForRowSet(insertSql);
		row.next();
		long spaceId = row.getLong("id");
		
		Space space = dao.viewSpecificSpace(spaceId);
		Assert.assertEquals(spaceId, space.getId());
	}
	
	@Test
	public void make_reservation() {
		long testReservationId = dao.makeReservation(1, 100, LocalDate.of(2020, 01, 01), LocalDate.of(2020, 01, 10), "Test McTestFace");
		
		String selectSql = "SELECT reserved_for FROM reservation WHERE reservation_id = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(selectSql, testReservationId);
		row.next();
		String returnedName = row.getString("reserved_for");
		
		Assert.assertEquals("Test McTestFace", returnedName);
	}
	
}
