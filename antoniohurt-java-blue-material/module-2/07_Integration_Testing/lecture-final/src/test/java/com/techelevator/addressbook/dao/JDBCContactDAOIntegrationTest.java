package com.techelevator.addressbook.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCContactDAOIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private ContactDAO dao;
	private JdbcTemplate jdbcTemplate;
	
	@BeforeClass
	public static void setupDataSource() {
		// Create the DataSource
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		// Set auto-commit to false
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void destroyDataSource() {
		dataSource.destroy();
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Before
	public void setup() {
		dao = new JDBCContactDAO(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// TESTING AN INSERT
	@Test
	public void save_contact() {
		// Arrange 
		Contact contact = new Contact();
		contact.setFirstName("testFirstName");
		contact.setLastName("testLastName");
		contact.setDateAdded(LocalDate.now());
		
		// Act
		dao.save(contact);
		
		// Assert
		Assert.assertNotEquals(0, contact.getContactId());
		Contact returnedContact = dao.getContactById(contact.getContactId());
		Assert.assertEquals(contact, returnedContact);
		
	}
	
	
	// TESTING A SELECT WITH A SINGLE VALUE RETURNED
	@Test
	public void get_contacts_by_contact_id() {
		// Arrange
		Contact contact = getNewContact();
		String insertSql = "INSERT INTO contact (contact_id, first_name, last_name, date_added, last_updated) VALUES (DEFAULT, ?, ?, ?, null) RETURNING contact_id";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(insertSql, contact.getFirstName(), contact.getLastName(), contact.getDateAdded());
		rows.next();
		contact.setContactId(rows.getLong("contact_id"));
		
		// Act
		Contact returnedContact = dao.getContactById(contact.getContactId());
		
		// Assert
		Assert.assertNotNull(returnedContact);
		Assert.assertEquals(contact, returnedContact);
		
	}
	
	// TESTING UPDATE
	@Test
	public void update_contact() {
		
		// Arrange
		Contact contact = getNewContact();
		dao.save(contact);
		
		contact.setFirstName("updatedFirstName");
		contact.setLastName("updatedLastName");
		
		// Act
		dao.update(contact);
		
		// Assert
		Contact retrievedContact = dao.getContactById(contact.getContactId());
		Assert.assertEquals(contact.getContactId(), retrievedContact.getContactId());
		Assert.assertEquals(contact.getFirstName(), retrievedContact.getFirstName());
		Assert.assertEquals(contact.getLastName(), retrievedContact.getLastName());
		
	}
	
	// TESTING DELETE
	@Test
	public void delete_contact()  {
		
		// Arrange
		Contact contact = getNewContact();
		dao.save(contact);
		
		// Act
		dao.delete(contact.getContactId());
		
		// Assert
		Contact retrieved = dao.getContactById(contact.getContactId());
		Assert.assertNull(retrieved);
	}
	
	// TESTING SELECT WITH MULTIPLE ROWS RETURNED - ASSERTING COUNTS
	@Test
	public void get_all_contacts() {
		// Arrange
		// Get the original number of rows
		String sql = "SELECT COUNT(*) AS numberOfRows FROM Contact";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		rows.next();
		int originalRowCount = rows.getInt("numberOfRows");
		
		Contact contactOne = getNewContact();
		Contact contactTwo = getNewContact();
		contactTwo.setFirstName("contactTwo");
		
		dao.save(contactOne);
		dao.save(contactTwo);
		
		// Act
		List<Contact> contactsReturned = dao.getAllContacts();
		
		// Assert
		Assert.assertNotNull(contactsReturned);
		Assert.assertEquals(originalRowCount + 2, contactsReturned.size());
		
	}
	
	
	// TESTING SELECT WITH MULTIPLE ROWS RETURNED - TRUNCATING THE TABLE(S)
	@Test
	public void get_all_contacts_again() {
		// Arrange
		// Truncate the table
		String truncateContactSql = "TRUNCATE contact CASCADE";
		jdbcTemplate.update(truncateContactSql);
		
		Contact contactOne = getNewContact();
		Contact contactTwo = getNewContact();
		contactTwo.setFirstName("contactTwo");
		
		dao.save(contactOne);
		dao.save(contactTwo);
		
		// Act
		List<Contact> contactsReturned = dao.getAllContacts();
	
		// Assert
		Assert.assertNotNull(contactsReturned);
		Assert.assertEquals(2, contactsReturned.size());
	}
	
	
	
	
	
	private Contact getNewContact() {
		Contact contact = new Contact();
		contact.setFirstName("testFirstName");
		contact.setLastName("testLastName");
		contact.setDateAdded(LocalDate.now());
		return contact;
	}
	
}
