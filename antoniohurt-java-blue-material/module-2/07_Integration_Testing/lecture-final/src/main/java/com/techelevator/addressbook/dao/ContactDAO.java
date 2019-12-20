package com.techelevator.addressbook.dao;

import java.util.List;

public interface ContactDAO {

	void save(Contact contact);
	Contact getContactById(long id);
	List<Contact> getAllContacts();
	void update(Contact contact);
	void delete(long id);
	
}
