package com.cookbook.controller;

import com.cookbook.dao.UserTurnoverDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("UserTurnoverController")
public class UserTurnoverController {
    @Resource
    UserTurnoverDao userTurnoverDao;
    @RequestMapping("querycountBysid")
    public int querycountBysid(Integer sid){
        return userTurnoverDao.querycountBysid(sid);
    }
}
