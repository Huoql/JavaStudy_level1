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
import com.study.mp.beans.User;
import com.study.mp.mapper.EmployeeMapper;
import com.study.mp.mapper.UserMapper;

public class TestMP {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	EmployeeMapper employeeMapper = (EmployeeMapper) ctx.getBean("employeeMapper");
	UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
	
	/**
	 * 测试公共字段填充
	 */
	@Test
	public void testMetaObjectHandler() {
		User user = new User();
//		user.setName("Tom");
		
		user.setId(5);
		user.setLogicFlag(1);
		
//		Integer result = userMapper.insert(user);
		Integer result = userMapper.updateById(user);
		System.out.println("result:" + result);
		
	}
	
	/**
	 * 测试逻辑删除
	 */
	@Test
	public void testLogicDelete() {
//		Integer result = userMapper.deleteById(1);
//		System.out.println("result:" + result);
		
		User user = userMapper.selectById(1);
		System.out.println(user);
	}
	
	/**
	 * 测试自定义全局操作
	 */
	@Test
	public void testMySqlInjector() {
		int result = employeeMapper.deleteAll();
		System.out.println("result:" + result);
	}
}
