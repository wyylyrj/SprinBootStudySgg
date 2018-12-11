package com.yrj.contorller;

import com.yrj.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("hello")
    public String hello(Map<String,String> map, @RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        new HashMap<>();
        map.put("hello","HelloWorld!");
        return "success";
    }
    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object> map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        return list.get(0);
    }
}
