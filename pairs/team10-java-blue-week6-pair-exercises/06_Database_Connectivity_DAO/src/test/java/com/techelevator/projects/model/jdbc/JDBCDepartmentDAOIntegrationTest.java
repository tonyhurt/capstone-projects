package com.techelevator.projects.model.jdbc;


import java.sql.SQLException;
import java.util.List;

import org.junit.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;


public class JDBCDepartmentDAOIntegrationTest {
	private static SingleConnectionDataSource datasource;
	private JDBCDepartmentDAO dao;
	private JdbcTemplate jdbcTemplate;
	
	@BeforeClass
	public static void setupDatasource() {
		datasource = new SingleConnectionDataSource();
		datasource.setUrl("jdbc:postgresql://localhost:5432/projects");
		datasource.setUsername("postgres");
		datasource.setPassword("postgres1");
		datasource.setAutoCommit(false);
	}
	@Before
	public void setup() {
		dao = new JDBCDepartmentDAO(datasource); 
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@AfterClass
	public static void destroyDatasource() {
		datasource.destroy();
	}
	
	@After
	public void rollback() throws SQLException {
		datasource.getConnection().rollback();
	}
	

	
	@Test
	public void get_all_departments() {
		String selectSql = "SELECT COUNT(*) as row_count FROM department";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectSql);
		rowSet.next();
		Integer countOfDepts = rowSet.getInt("row_count");
		Assert.assertNotNull(countOfDepts);
	}
	
	@Test
	public void search_departments_by_name() {
		Department department = new Department();
		department.setName("testDepartment");
		dao.createDepartment(department);
		
		List<Department> returnedDepartments = dao.searchDepartmentsByName("testDepartment");
		
		Assert.assertNotNull(returnedDepartments);
		Assert.assertNotEquals(0, returnedDepartments.size());
		
	}
	
	@Test 
	public void create_department() {
		Department department = new Department();
		department.setName("testDepartment");
		
		dao.createDepartment(department);
		
		Assert.assertNotNull(department.getId());
		Department returnedDepartment = dao.getDepartmentById(department.getId());
		Assert.assertEquals(department, returnedDepartment);
		
	}
	@Test
	public void save_department() {
		Department department = new Department();
		department.setName("testDepartment");
		dao.createDepartment(department);
		
		department.setName("newDepartmentName");
		
		dao.saveDepartment(department);
		
		Department returnedDepartment = dao.getDepartmentById(department.getId());
		Assert.assertEquals(department, returnedDepartment);
		
	}
	
	@Test
	public void get_department_by_id() {
		Department department = new Department();
		department.setName("testDepartment");
		dao.createDepartment(department);
		String searchSql = "SELECT * FROM department WHERE name = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(searchSql, "testDepartment");
		rows.next();
		department.setId(rows.getLong("department_id"));
		
		Department returnedDepartment = dao.getDepartmentById(department.getId());
		
		Assert.assertNotNull(returnedDepartment);
		Assert.assertEquals(department, returnedDepartment);
		
	}
	
}
