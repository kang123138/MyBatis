package com.atguigu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.entities.Employee;

public interface EmployeeMapper {
	public Employee getEmployeeByIdContainsDept(Integer id);
	public Employee getEmployeeByWithAssociation(Integer id);
	
	public Employee getEmployeeWithAssociationByStep(Integer id);
	
	//根据Employee中的属性值是否为空动态的生产Sql语句
	public Employee getEmployoeeByIf(Employee employee);
	
	public Employee getEmployoeeByChoose(Employee employee);
	
	public void updateEmployeeBySet(Employee employee);
	
	public List<Employee> getEmployeesByForeach(@Param("ids") List<Integer> ids);
}
