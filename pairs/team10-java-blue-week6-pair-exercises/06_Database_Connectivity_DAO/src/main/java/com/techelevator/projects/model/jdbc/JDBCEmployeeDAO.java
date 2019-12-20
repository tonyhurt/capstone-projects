package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		SqlRowSet rows = jdbcTemplate.queryForRowSet(
				"select employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM employee");

		while (rows.next()) {
			Employee employee = mapRowToEmployee(rows);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<Employee>();

		SqlRowSet rows = jdbcTemplate.queryForRowSet(
				"select employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM "
				+ "employee WHERE first_name = ? AND last_name = ?", firstNameSearch, lastNameSearch);

		while (rows.next()) {
			Employee employee = mapRowToEmployee(rows);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List<Employee> employees = new ArrayList<Employee>();

		SqlRowSet rows = jdbcTemplate.queryForRowSet(
				"select employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM "
				+ "employee WHERE department_id = ?", id);

		while (rows.next()) {
			Employee employee = mapRowToEmployee(rows);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<Employee>();
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(
		"select employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM "
		+ "employee WHERE employee_id NOT IN (select employee_id from project_employee)");
		
		while (rows.next()) {
			Employee employee = mapRowToEmployee(rows);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employees = new ArrayList<Employee>();
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(
		"select employee.employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM "
		+ "employee JOIN project_employee ON project_employee.employee_id = employee.employee_id "
		+ "WHERE project_id = ?", projectId);
		
		while (rows.next()) {
			Employee employee = mapRowToEmployee(rows);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String updateSql = "UPDATE employee set department_id = ? WHERE employee_id = ?";
		jdbcTemplate.update(updateSql, departmentId, employeeId);
	}

	private Employee mapRowToEmployee(SqlRowSet row) {
		Employee employee = new Employee();

		employee.setId(row.getLong("employee_id"));
		employee.setDepartmentId(row.getLong("department_id"));
		employee.setFirstName(row.getString("first_name"));
		employee.setLastName(row.getString("last_name"));
		employee.setBirthDay(row.getDate("birth_date").toLocalDate());
		employee.setGender(row.getString("gender").charAt(0));
		employee.setHireDate(row.getDate("hire_date").toLocalDate());

		return employee;
	}

}
