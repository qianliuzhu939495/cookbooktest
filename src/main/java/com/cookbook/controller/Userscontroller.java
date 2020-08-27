package com.cookbook.controller;

import com.cookbook.entity.Menu;
import com.cookbook.entity.Users;
import com.cookbook.entity.Works;
import com.cookbook.service.UserService;
import com.cookbook.util.Sms_util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
public class Userscontroller {
    int mobile_code=1024;
    @Resource
    UserService userService;
    @RequestMapping("SMS")
    @ResponseBody
    public String SMS(String phone){
        mobile_code = (int)((Math.random()*9+1)*100000);
        String rs = Sms_util.SendCode(phone,mobile_code);
        return rs;
    }
    @RequestMapping("quryByPwd")
    @ResponseBody
    public Users quryByPwd(@RequestBody Users users){
        return userService.quryByPwd(users.getPhone(),users.getPwd());
    }
    @RequestMapping("queryByphone")
    @ResponseBody
    public Users queryByMsg(String phone,String Msg){
        System.out.println(phone+","+Msg);
        if(!String.valueOf(mobile_code).equals(Msg)){
            return null;
        }
        Users users = userService.queryByphone(phone);
        System.out.println(users);
        if(users==null){
            userService.sasveone(phone);
        }
        users = userService.queryByphone(phone);
        return  users;
    }
    @RequestMapping("register")
    @ResponseBody
    public Users register(String pwd,String phone){
        System.out.println(phone+","+pwd);
        userService.sasveoneRe(pwd,phone);
        Users users = userService.queryByphone(phone);
        return  users;
    }
    @RequestMapping("queryphone")
    @ResponseBody
    public Users queryphone(String phone){
        return  userService.queryByMsg(phone);
    }
    @RequestMapping("queryAll")
    @ResponseBody
    public List<Users> queryAll(){
        System.out.println("s");
        return userService.queryAll();
    }
    @RequestMapping("querymenuworklevelmessage")
    @ResponseBody
    public List<Menu> querymenuworklevelmessage(String uid){
        return userService.querymenuworklevelmessage(Integer.valueOf(uid));
    }
    @RequestMapping("queryworkstartmessage")
    @ResponseBody
    public List<Works> queryworkstartmessage(String uid){
        return userService.queryworkstartmessage(Integer.valueOf(uid));
    }
}
