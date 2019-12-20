package com.techelevator;

public class Employee {

	public int employeeId;
	public String firstName;
	public String lastName;
	public String fullName;
	public String department;
	public double annualSalary;

	public Employee(int employeeId, String firstName, String lastName, double Salary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = Salary;
		this.fullName = lastName + ", " + firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		this.fullName = lastName + ", " + firstName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFullName() {
		return fullName;
	}

	public double getAnnualSalary() {
		return annualSalary;

	}

	public void raiseSalary(double percent) {
		annualSalary = annualSalary * ((100 + percent) / 100);
	}

}
