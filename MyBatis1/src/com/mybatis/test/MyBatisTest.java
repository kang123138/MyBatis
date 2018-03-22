package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

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

	@Test
	void test() throws IOException {
		SqlSession session = this.getSqlSession();
		try {
			// 3.获取Mapper对象
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

			// 4.调用employeeMapper中获取一个对象的方法
			Employee employeeById = employeeMapper.getEmployeeById(1);
			System.out.println(employeeById);
		} finally {
			session.close();
		}
	}

	// 使用session.selectOne()获取对象
	@Test
	void test2() throws IOException {
		SqlSession session = this.getSqlSession();
		Employee employee = session.selectOne("getEmployeeById11", 1);
		System.out.println(employee);
	}

	@Test
	void test1() {
		SqlSession session = null;
		try {
			session = this.getSqlSession();

			// 3.获取Mapper对象
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

			// 4.调用employeeMapper中获取一个对象的方法
			Employee employeeById = employeeMapper.getEmployeeById(1);
			System.out.println(employeeById);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
