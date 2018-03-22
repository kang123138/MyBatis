package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.Employee;

public interface EmployeeMapper {
	public Employee getEmployeeByIdContainsDept(Integer id);
	public Employee getEmployeeByWithAssociation(Integer id);
	
	public Employee getEmployeeWithAssociationByStep(Integer id);
}
