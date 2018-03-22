package com.atguigu.mybatis.entities;

public class Employee2 {

	private Integer id;
	private String lastName;
	private String email;
	private double salary;
	private Department deptId;
	public Employee2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee2(Integer id, String lastName, String email, double salary, Department deptId) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.deptId = deptId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDeptId() {
		return deptId;
	}
	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "Employee2 [id=" + id + ", lastName=" + lastName + ", email=" + email + ", salary=" + salary
				+ ", deptId=" + deptId + "]";
	}
}
