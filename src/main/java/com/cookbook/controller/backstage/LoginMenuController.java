package com.cookbook.controller.backstage;

import com.cookbook.service.backstage.LoginMenuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public String queryOneMenu(Integer cid){
        return loginmenuService.queryOneMenu(cid);
    }
}
