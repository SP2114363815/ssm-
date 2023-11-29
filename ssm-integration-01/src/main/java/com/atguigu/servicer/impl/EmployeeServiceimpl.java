package com.atguigu.servicer.impl;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.atguigu.servicer.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeMapper.queryList();
        return employees;
    }
}
