package com.atguigu.ssm.service;

import java.util.List;

import com.atguigu.ssm.entities.Department;
import com.atguigu.ssm.entities.Employee;

public interface EmployeeService {
	
	
	public List<Employee> getEmployees();
	
	// 添加员工
	public void AddEmployee(Employee employee);
	
	public Department getAllDepartments();
	
	public void deleteEmp(Integer id);
	
	public void updateEmployee(Employee employee);
	
	public Employee getEmployeeById(Integer id);
}
