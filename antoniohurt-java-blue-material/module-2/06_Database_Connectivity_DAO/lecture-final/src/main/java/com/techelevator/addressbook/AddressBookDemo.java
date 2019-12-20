package com.techelevator.addressbook;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.addressbook.dao.Contact;
import com.techelevator.addressbook.dao.ContactDAO;
import com.techelevator.addressbook.dao.JDBCContactDAO;

public class AddressBookDemo {

	public static void main(String[] args) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		ContactDAO contactDAO = new JDBCContactDAO(dataSource);
		
		Contact contact = new Contact();
		contact.setFirstName("John");
		contact.setLastName("Fulton");
		contact.setDateAdded(LocalDate.now());
		
		contactDAO.save(contact);
		
		System.out.println("Contact after save " + contact);
		
		Contact returnedContact = contactDAO.getContactById(contact.getContactId());
		
		System.out.println("The returned contact: " + returnedContact);
		
		List<Contact> contacts = contactDAO.getAllContacts();
		
		for (Contact c : contacts) {
			System.out.println(c);
		}
		
		returnedContact.setLastName("Matrix");
		contactDAO.update(returnedContact);
		
		System.out.println(contactDAO.getContactById(returnedContact.getContactId()));
		
		contactDAO.delete(returnedContact.getContactId());
		
		contacts = contactDAO.getAllContacts();
		
		for (Contact c : contacts) {
			System.out.println(c);
		}
		
		
	}
}
