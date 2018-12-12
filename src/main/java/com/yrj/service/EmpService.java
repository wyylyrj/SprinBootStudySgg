package com.yrj.service;

import com.yrj.entity.Emp;
import com.yrj.repository.EmpRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;
    @Cacheable(cacheNames = {"emp"},key = "#id")
    public Emp getEmpById(Integer id){
        System.out.println("查询" + id + "号员工");
        Optional<Emp> byId = empRepository.findById(id);
        Emp emp = byId.get();
        return emp;
    }
    public List<Emp> getEmpAll(){
        System.out.println("查询所有员工");
        List<Emp> all = empRepository.findAll();
        return all;
    }
    @RabbitListener(queues = "yrj.emps")
    public void receive(Emp emp){
        System.out.println("收到消息：" + emp);

    }
    @RabbitListener(queues = "test.news")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());

    }
}
