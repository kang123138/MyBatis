package com.atguigu.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.atguigu.mybatis.entities.Employee;

public interface EmployeeMapper {
	/*@Select("select * from employees where id = #{id}")*/
	public Employee getEmployeeById(Integer id);
	
	// 获取所有对象
	public List<Employee> getEmployees();
	
	// 添加员工
	public void addEmployee(Employee employee);
	
	//更新员工
	public void updateEmployee(Employee employee);
	
	// 删除员工
	public void DeleteEmployee(Integer id);
	
	public Employee getEmployeeByLastNameAndEmail(@Param("lastName") String lastName,@Param("email") String email);
//	public Employee getEmployeeByLas1tNameAndEmail(String lastName,String email);
	
	
	public Employee getEmployeeByMap(Map<String, Object> map);
}
