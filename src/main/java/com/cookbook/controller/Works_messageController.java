package com.cookbook.controller;

import com.cookbook.dao.Works_messageDao;
import com.cookbook.entity.Works_message;
import com.cookbook.service.Works_messageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Works_messageController")
public class Works_messageController {
    @Resource
    Works_messageService works_messageService;
    @Resource
    Works_messageDao works_messageDao;
    @RequestMapping("querybywid")
    public List<Works_message> querybywid(Integer wid){
        return works_messageService.querybywid(wid);
    }
    @RequestMapping("add")
    public int add(@RequestBody Works_message wm){
        return works_messageService.add(wm);
    }
    @RequestMapping("del")
    public int del(Integer wmid){
        return works_messageService.delete(wmid);
    }
    @RequestMapping("updateworkstate")
    public int updateworkstate(String wmid){
        return works_messageDao.updateworkstate(wmid);
    }
}
