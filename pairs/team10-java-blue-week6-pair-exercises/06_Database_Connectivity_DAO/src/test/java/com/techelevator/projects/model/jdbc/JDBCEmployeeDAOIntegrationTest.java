package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import com.techelevator.projects.model.Employee;

public class JDBCEmployeeDAOIntegrationTest {
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
	public void get_all_employees() {
		String selectSql = "SELECT COUNT(*) as row_count FROM employee";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectSql);
		rowSet.next();
		Integer countOfEmployees = rowSet.getInt("row_count");
		Assert.assertNotNull(countOfEmployees);
	}

	@Test
	public void search_employees_by_name() {
		Employee employee = new Employee();
		employee.setFirstName("testFirstName");
		employee.setLastName("testLastName");
		employee.setHireDate(LocalDate.now());
		employee.setBirthDay(LocalDate.of(2000, 01, 01));
		String Gender = "M";
		employee.setGender(Gender.charAt(0));
		String insertSql = "INSERT into employee (first_name, last_name, hire_date, birth_date, gender) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertSql, employee.getFirstName(), employee.getLastName(), employee.getHireDate(),
				employee.getBirthDay(), employee.getGender());

		List<Employee> returnedEmployees = dao.searchEmployeesByName("testFirstName", "testLastName");

		Assert.assertNotNull(returnedEmployees);
		Assert.assertNotEquals(0, returnedEmployees.size());

	}

	@Test
	public void get_employees_by_department_id() {

		Department department = new Department();
		department.setName("testDepartment");
		departmentDao.createDepartment(department);
		String searchSql = "SELECT * FROM department WHERE name = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(searchSql, "testDepartment");
		rows.next();
		department.setId(rows.getLong("department_id"));

		long employee = insertEmployee("firstName", "lastName", department.getId());

		List<Employee> employees = dao.getEmployeesByDepartmentId(department.getId());

		long returnedEmployeeId = employees.get(0).getId();

		Assert.assertNotNull(employees);
		Assert.assertEquals(employee, returnedEmployeeId);

	}

	@Test
	public void get_employees_without_projects() {

		truncate_employees();

		long employee = insertEmployee("firstName", "lastName", 1);
		long employee2 = insertEmployee("firstName2", "lastName2", 1);

		projectDao.addEmployeeToProject((long) 1, employee2);

		List<Employee> benchEmployees = dao.getEmployeesWithoutProjects();

		Assert.assertNotNull(benchEmployees);
		Assert.assertEquals(1, benchEmployees.size());

	}

	@Test
	public void get_employee_by_project_id() {

		String insertSql = "INSERT INTO project (name) VALUES (?)";
		jdbcTemplate.update(insertSql, "testProject");

		String searchSql = "SELECT * FROM project WHERE name = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(searchSql, "testProject");
		rows.next();

		long projectId = rows.getLong("project_id");

		long employee = insertEmployee("firstName", "lastName", 1);

		projectDao.addEmployeeToProject(projectId, employee);

		List<Employee> employees = dao.getEmployeesByProjectId(projectId);

		long returnedEmployeeId = employees.get(0).getId();

		Assert.assertNotNull(employees);
		Assert.assertEquals(employee, returnedEmployeeId);
	}

	@Test
	public void update_employee_department() {
		
		Department department = new Department();
		department.setName("testDepartment");
		departmentDao.createDepartment(department);
		String searchSql = "SELECT * FROM department WHERE name = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(searchSql, "testDepartment");
		rows.next();
		department.setId(rows.getLong("department_id"));

		long employee = insertEmployee("firstName", "lastName", department.getId());

		dao.changeEmployeeDepartment(employee, (long) 1);

		List<Employee> employees = dao.getEmployeesByDepartmentId(department.getId());

		Assert.assertNotNull(employees);
		Assert.assertEquals(0, employees.size());

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

	private int insertEmployee(String firstName, String lastName, long departmentId) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setHireDate(LocalDate.now());
		employee.setBirthDay(LocalDate.of(2000, 01, 01));
		String Gender = "M";
		employee.setGender(Gender.charAt(0));

		String insertSql = "INSERT into employee (first_name, last_name, hire_date, birth_date, gender, department_id) VALUES (?, ?, ?, ?, ?, ?) RETURNING employee_id";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(insertSql, employee.getFirstName(), employee.getLastName(),
				employee.getHireDate(), employee.getBirthDay(), employee.getGender(), departmentId);
		rowSet.next();
		return rowSet.getInt("employee_id");
	}
}
