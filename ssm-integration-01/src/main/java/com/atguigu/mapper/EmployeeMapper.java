package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    //查询全部员工信息
    List<Employee> queryList();
}
