package com.cookbook.controller;

import com.cookbook.entity.Users;
import com.cookbook.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("UController")
public class UController {
    @Resource
    UserService userService;
    @RequestMapping("queryuserinfo")
    public List<Users> queryuserinfo(){
        return userService.queryuserinfo();
    }
    @RequestMapping("queryBylikeUname")
    public List<Users> queryBylikeUname(String uname){
        return userService.queryBylikeUname(uname);
    }
    @RequestMapping("querybyid")
    public Users querybyid(Integer uid){
        return userService.querybyuid(uid);
    }
    @RequestMapping("queryUser")
    public Users queryUser(Integer uid){
        return userService.queryUser(uid);
    }
}
