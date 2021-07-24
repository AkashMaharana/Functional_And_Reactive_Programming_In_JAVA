package com.akash.maharana;

import java.sql.Date;

public class Employee implements Comparable<Employee>{

	private String employeeId;
	private String name;
	private String gender;
	private Date dateOfBith;
	private String location;
	private String role;
	private Date dateOfJoing;
	private Double salary;

	public Employee(String employeeId, String name, String gender, Date dateOfBith, String location, String role,
			Date dateOfJoing, Double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.gender = gender;
		this.dateOfBith = dateOfBith;
		this.location = location;
		this.role = role;
		this.dateOfJoing = dateOfJoing;
		this.salary = salary;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBith() {
		return dateOfBith;
	}

	public void setDateOfBith(Date dateOfBith) {
		this.dateOfBith = dateOfBith;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDateOfJoing() {
		return dateOfJoing;
	}

	public void setDateOfJoing(Date dateOfJoing) {
		this.dateOfJoing = dateOfJoing;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", gender=" + gender + ", dateOfBith="
				+ dateOfBith + ", location=" + location + ", role=" + role + ", dateOfJoing=" + dateOfJoing
				+ ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		if(Integer.valueOf(this.employeeId)<Integer.valueOf(o.employeeId)) {
			return -1;
		}
		if(Integer.valueOf(this.employeeId).equals(Integer.valueOf(o.employeeId))) {
			return 0;
		}
		return 1;
	}

}
