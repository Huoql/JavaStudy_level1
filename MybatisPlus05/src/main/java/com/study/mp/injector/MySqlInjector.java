package com.study.mp.injector;

import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;

/**
 * 自定义全局操作
 * @author Administrator
 *
 */
public class MySqlInjector extends AutoSqlInjector{

	/**
	 * 扩展inject操作，完成全局自定义操作
	 */
	@Override
	public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass,
			Class<?> modelClass, TableInfo table) {
		//将EmployeeMapper中定义的deleteAll，处理成对应的MappedStatement对象，加入到configuration对象中
		
		//注入的sql语句
		String sql = "delete from "+table.getTableName();
		//注入的方法名  一定要与EmployeeMapper接口中的方法名一致
		String method = "deleteAll";
		
		//构造SqlSource对象
		SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
		
		//构造一个删除的mappedStatement
		this.addDeleteMappedStatement(mapperClass, method, sqlSource);
	}
}
