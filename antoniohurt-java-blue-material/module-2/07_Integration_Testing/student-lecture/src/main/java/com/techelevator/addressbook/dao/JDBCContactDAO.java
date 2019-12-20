package com.techelevator.addressbook.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCContactDAO implements ContactDAO {

	private final static String SELECT_CONTACT_SQL = "select contact_id, first_name, last_name, date_added, last_updated from contact";
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCContactDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public void save(Contact contact) {
		String insertSql = "INSERT INTO contact (contact_id, first_name, last_name, date_added, last_updated) VALUES (DEFAULT, ?, ?, ?, ?) RETURNING contact_id";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(insertSql,contact.getFirstName(), contact.getLastName(), contact.getDateAdded(), contact.getLastUpdated() );
		rows.next();
		long contactId = rows.getLong("contact_id");
		
		contact.setContactId(contactId);
	}
	
	@Override
	public Contact getContactById(long id) {
		
		String selectSql = SELECT_CONTACT_SQL + " WHERE contact_id = ?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(selectSql, id);
		
		Contact contact = null;
		if (rows.next()) {
			contact = mapRowToContact(rows);
		}
		
		return contact;
	}
	
	@Override
	public List<Contact> getAllContacts() {
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_CONTACT_SQL);
		
		while (rows.next()) {
			Contact contact = mapRowToContact(rows);
			contacts.add(contact);
		}
		return contacts;
	}
	
	@Override
	public void update(Contact contact) {
		String updateSql = "UPDATE contact SET first_name = ?, last_name = ?, last_updated = NOW() WHERE contact_id = ?";
		jdbcTemplate.update(updateSql, contact.getFirstName(), contact.getLastName(), contact.getContactId());
	}
	
	@Override
	public void delete(long id) {
		String deleteSql = "DELETE FROM contact WHERE contact_id = ?";
		jdbcTemplate.update(deleteSql, id);
	}
	
	private Contact mapRowToContact(SqlRowSet row) {
		Contact contact = new Contact();
		
		contact.setContactId(row.getLong("contact_id"));
		contact.setFirstName(row.getString("first_name"));
		contact.setLastName(row.getString("last_name"));
		if (row.getDate("date_added") != null) {
			contact.setDateAdded(row.getDate("date_added").toLocalDate());
		}
		if (row.getDate("last_updated") != null) {
			contact.setLastUpdated(row.getDate("last_updated").toLocalDate());
		}

		return contact;
	}
	
}
