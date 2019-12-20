package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {

		List<Department> departments = new ArrayList<Department>();

		SqlRowSet rows = jdbcTemplate.queryForRowSet("select department_id, name FROM department");

		while (rows.next()) {
			Department department = mapRowToDepartment(rows);
			departments.add(department);
		}
		return departments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String name) {
		
		List<Department> departments = new ArrayList<Department>();
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet("SELECT department_id, name FROM department WHERE name = ?", name);
		
		while (rows.next()) {
			Department department = mapRowToDepartment(rows);
			departments.add(department);
		}
		return departments;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String updateSql = "UPDATE department SET name = ? WHERE department_id = ?";
		jdbcTemplate.update(updateSql, updatedDepartment.getName(), updatedDepartment.getId());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String insertSql = "INSERT INTO department (department_id, name) VALUES (DEFAULT, ?) RETURNING department_id";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(insertSql,newDepartment.getName());
		rows.next();
		long departmentId = rows.getLong("department_id");
		
		newDepartment.setId(departmentId);
		
		return newDepartment;
	}
		

	@Override
	public Department getDepartmentById(Long id) {
		String selectSql = "SELECT department_id, name FROM department WHERE department_id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(selectSql, id);
		
		Department department = null;
		if (rows.next()) {
			department = mapRowToDepartment(rows);
		}
		return department;
	}
	

	private Department mapRowToDepartment(SqlRowSet row) {
		Department department = new Department();

		department.setId(row.getLong("department_id"));
		department.setName(row.getString("name"));

		return department;
	}

}
