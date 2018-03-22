package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.atguigu.mybatis.entities.Employee;
import com.atguigu.mybatis.entities.Employee2;
import com.atguigu.mybatis.mapper.EmployeeMapper;
import com.atguigu.mybatis.mapper.EmployeeMapper2;

class MyBatisTest2 {

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

	// 使用自定义结果集
	@Test
	void test2() throws IOException {
		SqlSession session = this.getSqlSession();
		EmployeeMapper2 mapper = session.getMapper(EmployeeMapper2.class);
		Employee2 employee2 = mapper.getEmployeeByIdContainsDept(2);
		System.out.println(employee2);
	}

}
