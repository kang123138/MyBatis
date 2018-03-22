package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.Employee2;

public interface EmployeeMapper2 {
	public Employee2 getEmployeeByIdContainsDept(Integer id);
}
