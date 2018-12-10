package com.yrj.contorller;

import com.yrj.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("hello")
    public String hello(Map<String,String> map, @RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        new HashMap<>();
        map.put("hello","HelloWorld!");
        return "success";
    }
}
