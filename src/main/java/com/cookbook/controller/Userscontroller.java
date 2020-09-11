package com.cookbook.controller;

import com.cookbook.dao.StudioDao;
import com.cookbook.dao.UserDao;
import com.cookbook.entity.*;
import com.cookbook.service.UserService;

import com.cookbook.util.Sms_util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class Userscontroller {
    int mobile_code=1024;
    @Resource
    UserService userService;
    @Resource
    UserDao userDao;
    @Resource
    StudioDao studioDao;
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
        System.out.println(users);
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
    @RequestMapping("queryusercollectedmenu")
    @ResponseBody
    public List<Menu> queryusercollectedmenu(String uid){
        return userService.queryusercollectedmenu(Integer.valueOf(uid));
    }

    @RequestMapping("updateInfo")
    @ResponseBody
    void updateInfo(@RequestBody Users users){
        userDao.updateInfo(users);
    }

    @RequestMapping("MsgUpdatePwd")
    @ResponseBody
    public String MsgUpdatePwd(@RequestBody Map<String,String> map){
        System.out.println(map.get("phone")+","+map.get("msg")+","+map.get("pwd"));
        if(!String.valueOf(mobile_code).equals(map.get("msg"))){
            return null;
        }
        try {
            Users users = userService.queryByphone(map.get("phone"));
           userDao.msgUpdatePwd(map.get("pwd"), String.valueOf(users.getUid()));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return "ok";
        }
    }
    @RequestMapping("studioQueryuser")
    @ResponseBody //查询课程作者
    public Users studioQueryuser(String uid) throws Exception{
        System.out.println(uid);
        Users querybyid = userDao.querybyid(Integer.valueOf(uid));
        System.out.println(querybyid);
        return querybyid;
    }



    @RequestMapping("queryguanzhu")
    @ResponseBody
    public List<Users>  queryguanzhu(String uid){
        return userDao.queryguanzhu(Integer.valueOf(uid));
    }
    @RequestMapping("querybeiguanzhu")
    @ResponseBody
    public List<Users>  querybeiguanzhu(String uid){
        return userDao.querybeiguanzhu(Integer.valueOf(uid));
    }
    @RequestMapping("queryIsFollow")
    @ResponseBody
    public Integer queryIsFollow(String uid,String followid){
        System.out.println(uid +followid);
        return userDao.queryIsFollow(uid,followid);
    }
    @RequestMapping("Isfollows")
    @ResponseBody
    public Integer Isfollows(String uid,String followid){
        return userDao.Isfollows(uid,followid);
    }

    @RequestMapping("saveIsfollows")
    @ResponseBody
    public Integer saveIsfollows(String uid,String followid){
        return userDao.saveIsfollows(uid,followid);
    }
    @RequestMapping("queryUserById")
    @ResponseBody
    public Users queryUserById(String uid){
        return userDao.querybyid(Integer.valueOf(uid));
    }
}
