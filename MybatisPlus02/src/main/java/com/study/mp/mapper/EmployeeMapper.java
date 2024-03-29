package com.study.mp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.study.mp.beans.Employee;

/**
 * Mapper接口：
 * 基于 Mybatis：
 * 		在Mapper接口中手动编写 CRUD方法，需要提供Mapper接口所对应的sql映射文件以及方法对应的 sql语句.
 * 基于 MP：
 * 		只需要创建XxxMapper 接口, 并继承 BaseMapper 接口.
 * 		BaseMapper<T>: 泛型指定的就是当前Mapper接口所操作的实体类类型
 * @author Administrator
 *
 */
public interface EmployeeMapper extends BaseMapper<Employee>{

}
