package com.atguigu.ssm.mapper;

import java.util.List;

import com.atguigu.ssm.entities.Employee;

public interface EmployeeMapper {
	//获取所有员工信息
	public List<Employee> getAllEmloyees();
	
	// 添加员工
	public void AddEmployee(Employee employee);
	
	// 删除员工信息
	void deleteEmployee(Integer id);
	
	// 更新员工
	void updateEmployee(Employee employee);
	
	// 获取某个员工信息
	Employee getEmployeeById(Integer id);
}
