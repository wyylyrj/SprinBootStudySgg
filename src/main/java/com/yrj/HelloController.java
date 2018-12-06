package com.yrj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("hello")
    public String hello(Map<String,String> map){
        new HashMap<>();
        map.put("hello","HelloWorld!");
        return "success";
    }
}
