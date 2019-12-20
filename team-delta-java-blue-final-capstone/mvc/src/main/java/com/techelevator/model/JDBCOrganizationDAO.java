package com.techelevator.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JDBCOrganizationDAO implements OrganizationDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCOrganizationDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrganization(Organization organization) {
		String insertSql = "INSERT INTO organization (organization_id, name) "
				+ "values (DEFAULT, ?) returning organization_id";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(insertSql, organization.getName());
		rows.next();
		
		int orgId = rows.getInt("organization_id");
		organization.setOrgId(orgId);		
	}
}
