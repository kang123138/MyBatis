package com.atguigu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.ssm.entities.Department;
import com.atguigu.ssm.entities.Employee;
import com.atguigu.ssm.mapper.DepartmentMapper;
import com.atguigu.ssm.mapper.EmployeeMapper;
import com.atguigu.ssm.service.EmployeeService;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	// 获取所有员工
	@Override
	public List<Employee> getEmployees() {
		List<Employee> emps = employeeMapper.getAllEmloyees();
		return emps;
	}
	
	// 删除运功
	@Override
	public void deleteEmp(Integer id) {
		employeeMapper.deleteEmployee(id);
	}

	// 更新员工
	@Override
	public void updateEmployee(Employee employee) {
		employeeMapper.updateEmployee(employee);
	}

	// 根据id获取某个员工的信息
	@Override
	public Employee getEmployeeById(Integer id) {
		Employee employeeById = employeeMapper.getEmployeeById(id);
		return employeeById;
	}

	// 添加员工
	@Override
	public void AddEmployee(Employee employee) {
		employeeMapper.AddEmployee(employee);
	}

	// 获取所有部门
	@Override
	public Department getAllDepartments() {
		Department depts = departmentMapper.getAllDept();
		return depts;
	}

}
