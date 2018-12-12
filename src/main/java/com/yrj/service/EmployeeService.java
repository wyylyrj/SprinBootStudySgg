package com.yrj.service;

import com.yrj.bean.Employee;
import com.yrj.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmp(Integer id){
        System.out.println("查询第" + id + "号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;

    }
}
