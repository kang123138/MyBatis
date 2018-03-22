package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.atguigu.mybatis.entities.Employee;
import com.atguigu.mybatis.mapper.EmployeeMapper;

class MyBatisTest {

	// 获取SqlSession方法
	public SqlSession getSqlSession() throws IOException {
		// 1.创建SqlSessionFactory对象
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2.获取SqlSession，相当于JDBC中的Connection
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}

	// 使用session.selectOne()获取对象
	@Test
	void test2() throws IOException {
		SqlSession session = this.getSqlSession();
		Employee employee = session.selectOne("getEmployeeById11", 1);
		System.out.println(employee);
	}

	// 联合查询
	@Test
	void test3() throws IOException {
		SqlSession session = this.getSqlSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee employee = mapper.getEmployeeByWithAssociation(8);
		System.out.println(employee);
	}

	@Test
	void getEmployeeWithAssociationByStep1() throws IOException {
		SqlSession session = this.getSqlSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee employee = mapper.getEmployeeWithAssociationByStep(1);
		System.out.println(employee);
	}

	@Test
	void getEmployeeWithAssociationByStep() throws IOException {
		SqlSession session = this.getSqlSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee employee = mapper.getEmployeeWithAssociationByStep(2);
		System.out.println(employee);
	}

	// 测试if
	@Test
	void getEmployoeeByIf() throws IOException {
		SqlSession session = this.getSqlSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee employee = mapper.getEmployoeeByIf(new Employee(null, null, "hybing@atguigu.com", 0, null));
		System.out.println(employee);
	}

	// 测试if
	@Test
	void getEmployoeeByChoose() throws IOException {
		SqlSession session = this.getSqlSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee employee = mapper.getEmployoeeByChoose(new Employee(5, null, "hybing@atguigu.com", 0, null));
		System.out.println(employee);
	}

	@Test
	void updateEmployeeBySet() throws IOException {
		SqlSession session = this.getSqlSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		mapper.updateEmployeeBySet(new Employee(9, null, "hybing@atguigu.com", 3333, null));
		session.commit();
	}

	@Test
	void getEmployeesByForeach() throws IOException {
		SqlSession session = this.getSqlSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		// 4.调用employeeMapper中获取Employees的方法
		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(9);
		list.add(10);
		List<Employee> employeesByForeach = mapper.getEmployeesByForeach(list);
		for (Employee employee : employeesByForeach) {
			System.out.println(employee);
		}
	}

}
