package com.atguigu.mybatis.entities;

import java.util.List;

public class Department {

	private String id;
	private String departmentName;
	private List<Employee> emps;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String id, String departmentName, List<Employee> emps) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.emps = emps;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", emps=" + emps + "]";
	}
}
