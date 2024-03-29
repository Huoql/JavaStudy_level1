package com.study.mp.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.study.mp.beans.Employee;
import com.study.mp.mapper.EmployeeMapper;

public class TestMP {

	private ApplicationContext ioc = new 
			ClassPathXmlApplicationContext("applicationContext.xml");	
	
	/**
	 * AR 分页复杂操作
	 */
	@Test
	public void testARPage() {
		Employee employee = new Employee();
		Page<Employee> page = employee.selectPage(new Page<Employee>(1,3),
				new EntityWrapper<Employee>()
				.eq("last_name", "a")
				);
		List<Employee> emps = page.getRecords();
		for (Employee emp : emps) {
			System.out.println(emp);
			
		}
	}
	
	/**
	 * AR 删除操作
	 * 注意：删除不存在的数据在逻辑上也属于成功
	 */
	@Test
	public void testARDelete() {
		Employee employee = new Employee();
		
//		boolean result = employee.deleteById(7);
		
//		employee.setId(7);
//		boolean result = employee.deleteById();
		
		boolean result = employee.delete(new EntityWrapper<Employee>().eq("age", 28));
		System.out.println("result:" + result);
	}
	
	/**
	 * AR 查询操作
	 */
	@Test
	public void testARSelect() {
		Employee employee = new Employee();
//		Employee result = employee.selectById(4);
		
//		employee.setId(4);
//		Employee result = employee.selectById();
//		System.out.println("result:" + result);
		
//		List<Employee> emps = employee.selectAll();
//		for (Employee emp : emps) {
//			System.out.println(emp);
//		}
		
//		List<Employee> emps = employee.selectList(new EntityWrapper<Employee>().like("last_name", "a"));
//		for (Employee emp : emps) {
//			System.out.println(emp);
//		}
		
//		int count = employee.selectCount(null);
		int count = employee.selectCount(new EntityWrapper<Employee>().eq("gender", 0));
		System.out.println(count);
	}
	
	/**
	 * AR 更新操作
	 */
	@Test
	public void testARUpdate() {
		Employee employee = new Employee();
		employee.setId(4);
		employee.setLastName("Black");
		employee.setEmail("black@qq.com");
		
		boolean result = employee.updateById();
		System.out.println("result:" + result);
	}
	
	/**
	 * AR 插入操作
	 */
	@Test
	public void testARInsert() {
		Employee employee = new Employee();
		employee.setLastName("Mike");
		employee.setEmail("mike@qq.com");
		employee.setGender(1);
		employee.setAge(18);
		
		boolean result = employee.insert();
		System.out.println("result:" + result);
	}
}
