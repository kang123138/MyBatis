package com.atguigu.ssm.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.ssm.entities.Department;
import com.atguigu.ssm.entities.Employee;
import com.atguigu.ssm.service.EmployeeService;

@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeService employeeService;
	
	// 获取所有员工
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String getEmployees(Map<String, Object> map) {
		List<Employee> emps = employeeService.getEmployees();
		map.put("emps", emps);
		return "list";
	}
	
	// 添加员工之页面
	@RequestMapping(value="/addEmp",method=RequestMethod.GET)
	public String AddEmployee(Map<String, Object> map) {
		// 获取所有员工
		Department depts = employeeService.getAllDepartments();
		map.put("depts", depts);
		map.put("command", new Employee());
		return "update";
	}
	
	// 添加员工
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	public String AddEmp(Employee employee) {
		// 调用service中方法添加员工
		employeeService.AddEmployee(employee);
		return "redirect:/emps";
	}
	
	// 删除员工
	@RequestMapping(value="/deleteEmp/{id}",method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id") Integer id) {
		employeeService.deleteEmp(id);
		return "redirect:/emps";
	}
	
	// 去更新的页面
	@RequestMapping(value= "/updateEmp/{id}",method=RequestMethod.GET)
	public String updateEmployee(@PathVariable("id") Integer id,Map<String, Object> map) {
		// 根据id获取员工信息
		Employee employee = employeeService.getEmployeeById(id);
		map.put("command", employee);
		return "update";
	}
	
	// 更新员工
	@RequestMapping(value="/updateEmp/{id}",method=RequestMethod.PUT)
	public String updateEmployeeById(Employee employee) {
		System.out.println("进入该方法");
		employeeService.updateEmployee(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping("/model")
	public String testModel(Model model) {
		String str = "我来测试";
		model.addAttribute("a",str);
		return "aaa";
		
	}
	
	
}	
