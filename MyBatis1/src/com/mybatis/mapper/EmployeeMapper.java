package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.Employee;

public interface EmployeeMapper {
	// 根据id获取员工信息
	public Employee getEmployeeById(Integer id);
}
