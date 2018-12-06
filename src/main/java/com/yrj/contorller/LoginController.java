package com.yrj.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名密码错误！");
            return "login";
        }
    }
}