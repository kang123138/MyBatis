package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
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
	// 测试获取所有员工
	@Test
	void GetEmployeeTest() throws IOException {
		// 获取创建SqlSessionFactory对象
		SqlSession sqlSession = this.getSqlSession();
		// 3.获取Mapper对象
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		// 4.调用employeeMapper中获取所有对象的方法
		List<Employee> employees = mapper.getEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	// 测试添加员工
	@Test
	void AddEmployeeTest() throws IOException {
		// 获取创建SqlSessionFactory对象
		SqlSession sqlSession = this.getSqlSession();
		// 3.获取Mapper对象
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		// 4.调用employeeMapper中添加员工的方法
		Employee employee = new Employee(null, "收到了11", "aaa@qq.com", 333.00, 3);
		mapper.addEmployee(employee);
		System.out.println(employee);
		sqlSession.commit();
	}
	
	// 测试更新员工
	@Test
	void UpdateEmployeeTest() throws IOException {
		// 获取创建SqlSessionFactory对象
		SqlSession sqlSession = this.getSqlSession();
		// 3.获取Mapper对象
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		// 4.调用employeeMapper中添加员工的方法
		mapper.updateEmployee(new Employee(5, "ddd", "", 333, 2));
		sqlSession.commit();
	}
	
	// 删除更新员工
	@Test
	void DeleteEmployeeTest() throws IOException {
		// 获取创建SqlSessionFactory对象
		SqlSession sqlSession = this.getSqlSession();
		// 3.获取Mapper对象
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		// 4.调用employeeMapper中添加员工的方法
		mapper.DeleteEmployee(5);
		sqlSession.commit();
	}
	
	
	// 根据名称和邮箱获取员工
	@Test
	void getEmployeeByLastNameAndEmailTest() throws IOException {
		// 获取创建SqlSessionFactory对象
		SqlSession sqlSession = this.getSqlSession();
		// 3.获取Mapper对象
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		// 4.调用employeeMapper中添加员工的方法
		Employee employee = mapper.getEmployeeByLastNameAndEmail("'aaa'", "'aaa@qq.com'");
		System.out.println(employee);
		// sqlSession.commit();
	}
	
	// 参数是Map获取员工
	@Test
	void getEmployeeByMapTest() throws IOException {
		// 获取创建SqlSessionFactory对象
		SqlSession sqlSession = this.getSqlSession();
		// 3.获取Mapper对象
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		// 4.调用employeeMapper中添加员工的方法
		Map<String, Object> map = new HashMap<>();
		map.put("ln", "aaa");
		map.put("el", "aaa@qq.com");
		map.put("sy", 333);
		Employee employee = mapper.getEmployeeByMap(map);
		System.out.println(employee);
//		 sqlSession.commit();
	}

}
