package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Project> getAllActiveProjects() {
		List<Project> projects = new ArrayList<Project>();
		SqlRowSet rows = jdbcTemplate.queryForRowSet("SELECT project_id, name, from_date, to_date from project");

		while (rows.next()) {
			Project project = mapRowToProject(rows);
			projects.add(project);
		}
		LocalDate today = LocalDate.now(ZoneId.of("America/Montreal"));
		List<Project> activeProjects = new ArrayList<Project>();
		for (Project p : projects) {

			if ((p.getStartDate() != null && today.isAfter(p.getStartDate()))
					&& (p.getEndDate() == null || today.isBefore(p.getEndDate()))) {
				activeProjects.add(p);
			}
		}
		return activeProjects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String deleteSql = "DELETE FROM project_employee WHERE employee_id = ? AND project_id = ?";
		jdbcTemplate.update(deleteSql, employeeId, projectId);

		
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		
		try {
			String insertSql = "INSERT INTO project_employee (project_id, employee_id ) VALUES (?, ?)";
			jdbcTemplate.update(insertSql, projectId, employeeId);
		}
		catch(DuplicateKeyException e) {
			System.out.println("Employee " + employeeId + " is already assigned to that project");
		}

	}

	private Project mapRowToProject(SqlRowSet row) {
		Project project = new Project();

		project.setId(row.getLong("project_id"));
		project.setName(row.getString("name"));
		if (row.getDate("from_date") != null) {
			project.setStartDate(row.getDate("from_date").toLocalDate());
		}
		if (row.getDate("to_date") != null) {
			project.setEndDate(row.getDate("to_date").toLocalDate());
		}

		return project;
	}
}
