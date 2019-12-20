package com.techelevator.reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCReservationDAO implements ReservationDAO {

	private static final String SELECT_RESERVATIONS_BY_SPACE_ID = "SELECT reservation_id, space_id, number_of_attendees, start_date, end_date, reserved_for "
			+ "FROM reservation WHERE space_id = ? ";

	// venueName, startDate, startDate, endDate, endDate, startDate, endDate
	private static final String SELECT_INVALID_RESERVATIONS_BY_VENUE_NAME = "SELECT reservation_id, space_id, number_of_attendees, start_date, end_date, reserved_for FROM reservation r "
			+ "JOIN space s ON s.id = space_id JOIN venue v ON s.venue_id = v.id WHERE v.name = ? " 
			+ "AND ((? > start_date AND ? < end_date) OR "
			+ " (? > start_date AND ? < end_date ) OR "
			+ " (? <= start_date AND ? >= end_date))"
			+ "GROUP BY reservation_id, space_id, number_of_attendees, start_date, end_date, reserved_for";
	
	// spaceID, reservationAttendees, startDate, endDate, reservedFor
	private static final String INSERT_RESERVATION = "INSERT INTO reservation (reservation_id, space_id, number_of_attendees, start_date, end_date, reserved_for) "
			+ "VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING reservation_id";

	private JdbcTemplate jdbcTemplate;

	public JDBCReservationDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Reservation> getReservationsBySpaceID(long spaceID) {
		List<Reservation> reservations = new ArrayList<Reservation>();
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_RESERVATIONS_BY_SPACE_ID, spaceID);
		while (rows.next()) {
			Reservation reservation = mapRowToReservation(rows);
			reservations.add(reservation);
		}
		return reservations;
	}

	public List<Reservation> getInvalidReservations(String venueName, LocalDate startDate, LocalDate endDate) {
		List<Reservation> invalidReservations = new ArrayList<Reservation>();
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_INVALID_RESERVATIONS_BY_VENUE_NAME, venueName, startDate, startDate, endDate, endDate, startDate, endDate);
		while (rows.next()) {
			Reservation reservation = mapRowToReservation(rows);
			invalidReservations.add(reservation);
		}
		return invalidReservations;
	}

	@Override
	public long makeReservation(Reservation reservation) {
		LocalDate startDate = reservation.getStartDate();
		LocalDate endDate = reservation.getEndDate();
		if (startDate.compareTo(endDate) >= 0) {
			return -1;
		}
		SqlRowSet rows = jdbcTemplate.queryForRowSet(INSERT_RESERVATION, reservation.getSpaceID(), reservation.getReservationAttendees(), reservation.getStartDate(), reservation.getEndDate(), reservation.getReservedFor());
		rows.next();
		long reservationID = rows.getInt("reservation_id");
		return reservationID;
	}

	private Reservation mapRowToReservation(SqlRowSet row) {
		Reservation reservation = new Reservation();
		reservation.setSpaceID(row.getLong("space_id"));
		reservation.setReservationID(row.getLong("reservation_id"));
		reservation.setReservationAttendees(row.getInt("number_of_attendees"));
		reservation.setStartDate(row.getDate("start_date").toLocalDate());
		reservation.setEndDate(row.getDate("end_date").toLocalDate());
		reservation.setReservedFor(row.getString("reserved_for"));
		return reservation;
	}
}
