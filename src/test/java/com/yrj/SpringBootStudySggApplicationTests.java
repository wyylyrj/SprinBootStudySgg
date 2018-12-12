package com.yrj;

import com.yrj.bean.Employee;
import com.yrj.entity.Emp;
import com.yrj.mapper.EmployeeMapper;
import com.yrj.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootStudySggApplicationTests {

//    @Autowired
//    DataSource dataSource;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmpService empService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object,Emp> empRedisTemplate;

//    @Autowired
//    RedisTemplate<String, String> myRedisTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void test01(){
        //stringRedisTemplate.opsForValue().append("msg","hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    public void test02(){
        Emp empById = empService.getEmpById(1);
        //empRedisTemplate.opsForValue().set("emp01",empById);
        empRedisTemplate.opsForValue().set("emp01",empById);
    }

    @Test
    public void sendMsg(){
        Map<String,Object> map= new HashMap<>();
        map.put("msg","这是第一条消息");
        map.put("date", Arrays.asList("helloworld",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","yrj.news",map);
        rabbitTemplate.convertAndSend("exchange.direct","yrj.emps",new Emp(1,"aaa","aaa",1,1));
    }

    @Test
    public void receiveMsg(){
        Object o = rabbitTemplate.receiveAndConvert("yrj.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    public void createExchange(){
        //amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        //amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.heihei",null));
        System.out.println("创建完成");
    }

    @Test
    public void contextLoads() {
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
//        System.out.println(dataSource.getClass());
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//        connection.close();

        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);

    }

}
