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

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.study.mp.beans.Employee;
import com.study.mp.mapper.EmployeeMapper;

public class TestMP {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	EmployeeMapper employeeMapper = (EmployeeMapper) ctx.getBean("employeeMapper");
	
	/**
	 * 测试分页插件
	 */
	@Test
	public void testPage() {
		Page<Employee> page = new Page<Employee>(1,1);
		
		List<Employee> emps = employeeMapper.selectPage(page, null);
	
		for (Employee emp : emps) {
			System.out.println(emp);
		}
		System.out.println("============================获取分页相关的一些信息==============================");
		System.out.println("总条数：" + page.getTotal());
		System.out.println("当前页码：" + page.getCurrent());
		System.out.println("总页码：" + page.getPages());
		System.out.println("每页显示的条数：" + page.getSize());
		System.out.println("是否有上一页：" + page.hasPrevious());
		System.out.println("是否有下一页：" + page.hasNext());
		
		//将查询的结果直接封装到page对象中
		page.setRecords(emps);
	}
	
	/**
	 * 测试SQL执行分析插件
	 */
	@Test
	public void testSQLExplain() {
		Integer result = employeeMapper.delete(null);  //全表删除
		System.out.println(result);
	}
	
	/**
	 * 测试性能分析插件
	 */
	@Test
	public void testPerformance() {
		Employee employee = new Employee();
		employee.setLastName("Performance");
		employee.setEmail("performance@qq.com");
		employee.setGender("0");
		employee.setAge(19);
		
		Integer result = employeeMapper.insert(employee);
		System.out.println("result:" + result);
	}
	
	/**
	 * 测试乐观锁插件
	 */
	@Test
	public void testOptimisticLocker() {
		//更新操作
		Employee employee = new Employee();
		employee.setId(13);
		employee.setLastName("Locker");
		employee.setEmail("optimisticLocker@qq.com");
		employee.setGender("1");
		employee.setAge(30);
		employee.setVersion(1);
		
		Integer result = employeeMapper.updateById(employee);
		System.out.println("result:" + result);
	}
}
