package com.techelevator.space;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSpaceDAO implements SpaceDAO {

	private final static String SELECT_SPACE_SQL = "SELECT v.name AS venue_name, s.venue_id, s.open_to, s.open_from, s.name AS space_name, s.max_occupancy, s.is_accessible, s.id AS space_id, CAST(s.daily_rate AS NUMERIC) " + 
			"FROM space s " + 
			"JOIN venue v ON v.id = s.venue_id " + 
			"WHERE v.name = ? " +
			"ORDER BY space_id";
	
	private final static String SELECT_COMPATIBLE_SPACES_SQL = "SELECT s.id as space_id, s.name as space_name, v.name as venue_name, s.is_accessible, s.open_from, s.open_to, s.max_occupancy, r.start_date, r.end_date, r.reservation_id, r.number_of_attendees, r.reserved_for, CAST(s.daily_rate AS NUMERIC) FROM space s " +
			"JOIN venue v ON v.id = s.venue_id " + 
			"LEFT JOIN reservation r ON r.space_id = s.id " + 
			"WHERE v.name = ? " + 
			"AND max_occupancy >= ? "
			+ "ORDER BY daily_rate, space_id ";
	
	private JdbcTemplate jdbcTemplate;

	public JDBCSpaceDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Space> getAllSpacesByVenueName(String venueName) {
		List<Space> allSpaces = new ArrayList<Space>();
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_SPACE_SQL, venueName); 
		while (rows.next()) {
			Space space = mapRowToSpace(rows);
			allSpaces.add(space);
			
		}
		return allSpaces;
	}

	@Override
	public LinkedHashMap<Long, Space> getCompatibleSpaces(String venueName, int reservationAttendees, LocalDate endDate, LocalDate startDate) {
		LinkedHashMap<Long, Space> spaces = new LinkedHashMap<Long, Space>();
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_COMPATIBLE_SPACES_SQL, venueName, reservationAttendees);
		while (rows.next()) {
			Space space = mapRowToSpace(rows);
			spaces.put(space.getSpaceID(), space);
		}
		return spaces;
	}
	
	private Space mapRowToSpace(SqlRowSet row) {
		Space space = new Space();
		space.setSpaceID(row.getLong("space_id"));
		space.setSpaceName(row.getString("space_name"));
		space.setVenueName(row.getString("venue_name"));
		space.setAccessible(row.getBoolean("is_accessible"));
		space.setOpenFrom(row.getInt("open_from"));
		space.setOpenTo(row.getInt("open_to"));
		space.setDailyRate(row.getBigDecimal("daily_rate"));
		space.setMaxOccupancy(row.getInt("max_occupancy"));
		return space;
	}
	
}
