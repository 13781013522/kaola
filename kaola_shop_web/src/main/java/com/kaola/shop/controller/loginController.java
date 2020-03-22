package com.kaola.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class loginController {

    @RequestMapping("/name")
    public Map name(){
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();//获取到当前登录用户
        Map map = new HashMap();
        map.put("loginName",loginName);
        return map;
    }
    @RequestMapping("aa")
    public void aa(){
        System.out.println("aaaaa");
    }
}
