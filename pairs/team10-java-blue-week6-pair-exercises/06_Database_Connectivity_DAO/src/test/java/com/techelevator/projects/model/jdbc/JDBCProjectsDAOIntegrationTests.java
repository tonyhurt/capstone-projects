package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import com.techelevator.projects.model.Project;

public class JDBCProjectsDAOIntegrationTests {

	private static SingleConnectionDataSource datasource;
	private JDBCEmployeeDAO dao;
	private JdbcTemplate jdbcTemplate;
	private JDBCDepartmentDAO departmentDao;
	private JDBCProjectDAO projectDao;

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
		dao = new JDBCEmployeeDAO(datasource);
		jdbcTemplate = new JdbcTemplate(datasource);
		departmentDao = new JDBCDepartmentDAO(datasource);
		projectDao = new JDBCProjectDAO(datasource);
	}

	@Test
	public void get_all_active_projects() {
		String sqlCommand = "truncate project CASCADE";
		jdbcTemplate.update(sqlCommand);

		String insertSql = "INSERT INTO project (name, from_date, to_date) VALUES (?, ?, ?)";
		jdbcTemplate.update(insertSql, "testName", LocalDate.of(2000, 01, 01), LocalDate.of(2020, 01, 01));

		List<Project> activeProjects = projectDao.getAllActiveProjects();

		Assert.assertEquals(1, activeProjects.size());

	}

	@Test
	public void remove_employee_from_project() {
		String insertSql2 = "INSERT INTO project (name) VALUES (?)";
		jdbcTemplate.update(insertSql2, "testProject");
		String searchSql = "SELECT * FROM project WHERE name = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(searchSql, "testProject");
		rows.next();

		long projectId = rows.getLong("project_id");
		projectDao.addEmployeeToProject(projectId, 1l);
		projectDao.removeEmployeeFromProject(projectId, 1l);
		List<Employee> employeesInProject = dao.getEmployeesByProjectId(projectId);

		Assert.assertEquals(0, employeesInProject.size());

	}

	@Test
	public void add_employee_from_project() {
		String insertSql2 = "INSERT INTO project (name) VALUES (?)";
		jdbcTemplate.update(insertSql2, "testProject");
		String searchSql = "SELECT * FROM project WHERE name = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(searchSql, "testProject");
		rows.next();

		long projectId = rows.getLong("project_id");
		projectDao.addEmployeeToProject(projectId, 1l);

		List<Employee> employeesInProject = dao.getEmployeesByProjectId(projectId);

		Assert.assertEquals(1, employeesInProject.size());

	}

	@AfterClass
	public static void destroyDatasource() {
		datasource.destroy();
	}

	@After
	public void rollback() throws SQLException {
		datasource.getConnection().rollback();
	}

	private void truncate_employees() {
		jdbcTemplate.update("TRUNCATE employee CASCADE");
	}
}
