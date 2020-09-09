package com.cookbook.controller.backstage;

import com.cookbook.service.backstage.LoginMenuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("LoginMenu")
public class LoginMenuController {
    @Resource
    LoginMenuService loginmenuService;
    //@RequestMapping("getLoginMenu")
    public String getLoginMenu(Integer cid){
        return loginmenuService.getLoginMenu(cid);
    }
    @RequestMapping("getLoginMenu")
    public String queryOneMenu(Integer rid,Integer cid){
        return loginmenuService.queryOneMenu(rid,cid);
    }
    @RequestMapping("getAllMenu")
    public String queryMenoOne(){
        return loginmenuService.queryMenoOne();
    }
    @RequestMapping("getAllMenuTwo")
    public String queryMenoTwo(){
        System.out.println(loginmenuService.queryMenoTwo());
        return loginmenuService.queryMenoTwo();
    }
    @RequestMapping("changeRole")
    public Integer changeRole(String arr){
        int i = loginmenuService.changeRole(arr);
        return i;
    }
}
