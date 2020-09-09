package com.cookbook.controller.backstage;

import com.cookbook.service.backstage.BackWorkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("BackWork")
public class BackWorkController {
    @Resource
    BackWorkService backWorkService;
    @RequestMapping("queryWork")
    public List<Map<String,Object>> queryWork(){
       return backWorkService.queryWork();
    }
    @RequestMapping("queryLeaveMessage")
    public List<Map<String,Object>> queryLeaveMessage(){
        return backWorkService.queryLeaveMessage();
    }
}
