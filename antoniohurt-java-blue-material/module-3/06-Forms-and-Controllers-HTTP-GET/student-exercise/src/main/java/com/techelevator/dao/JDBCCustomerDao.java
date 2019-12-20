package com.techelevator.dao;

import com.techelevator.dao.model.Customer;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * JDBCCustomerDao
 */
@Component
public class JDBCCustomerDao implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCustomerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    
	}

	@Override
	public List<Customer> getCustomers(String search, String sort) {
		List<Customer> listOfCustomers = new ArrayList<>();
		String customerSearchSql = "SELECT first_name, last_name FROM customer WHERE last_name ILIKE ? order by last_name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(customerSearchSql, "%" + search + "%");
        while (results.next()) {
        	listOfCustomers.add(mapRowToCustomer(results));
        }

		return listOfCustomers;
	}

	private Customer mapRowToCustomer(SqlRowSet results) {
		// TODO Auto-generated method stub
		return null;
	}

}