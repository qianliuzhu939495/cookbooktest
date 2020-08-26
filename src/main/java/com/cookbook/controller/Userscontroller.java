package com.cookbook.controller;

import com.cookbook.entity.Users;
import com.cookbook.service.UserService;
import com.cookbook.util.sms_util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller

public class Userscontroller {
    @Resource
    UserService userService;
    @RequestMapping("SMS")
    @ResponseBody
    public String SMS(String phone){
        int mobile_code = (int)((Math.random()*9+1)*100000);
        String rs = sms_util.SendCode(phone, mobile_code);
        System.out.println(phone+","+rs);
        userService.queryByMsg(phone,rs);
        return rs;
    }
    @RequestMapping("quryByPwd")
    @ResponseBody
    public Users quryByPwd(String phone, String pwd){
        return userService.quryByPwd(phone,pwd);
    }
    @RequestMapping("queryByphone")
    @ResponseBody
    public Users queryByphone(String phone){
        return  userService.queryByphone(phone);
    }
    @RequestMapping("queryAll")
    @ResponseBody
    public List<Users> queryAll(){
        System.out.println("s");
        return userService.queryAll();
    }
    @RequestMapping("queryMsg")
    @ResponseBody
    public Users queryMsg(){
        return userService.queryByMsg("17633603531","OK");
    }

}
