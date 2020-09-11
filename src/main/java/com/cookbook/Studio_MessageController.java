package com.cookbook;

import com.cookbook.entity.Studio_message;
import com.cookbook.service.Studio_MessageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Studio_MessageController")
public class Studio_MessageController {
    @Resource
    Studio_MessageService studio_messageService;
    @RequestMapping("queryBysid")
    public List<Studio_message> queryBysid(Integer sid){
        System.out.println("sid"+sid);
        return studio_messageService.queryBysid(sid);
    }
    @RequestMapping("add")
    public int add(@RequestBody Studio_message studio_message){
        return studio_messageService.add(studio_message);
    }
}

