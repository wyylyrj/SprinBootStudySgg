package com.yrj.contorller;

import com.yrj.entity.Emp;
import com.yrj.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;
    @GetMapping("/epl/{id}")
    public Emp getEmpById(@PathVariable("id") Integer id){
        Emp empById = empService.getEmpById(id);
        return empById;
    }
    @GetMapping("/epl")
    public List<Emp> getEmpAll(){
        List<Emp> empAll = empService.getEmpAll();
        return empAll;
    }
}
