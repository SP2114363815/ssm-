package com.atguigu.controller;

import com.atguigu.pojo.Employee;
import com.atguigu.servicer.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("find")
    public List<Employee> find(){
        List<Employee> all=employeeService.findAll();
        return all;
    }
}
