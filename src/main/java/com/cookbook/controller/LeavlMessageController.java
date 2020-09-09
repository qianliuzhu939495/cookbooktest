package com.cookbook.controller;

import com.cookbook.dao.LeavlMessageDao;
import com.cookbook.entity.LeavMessage;
import com.cookbook.service.LeavlMessageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("LeavlMessageController")
public class LeavlMessageController {
    @Resource
    LeavlMessageService leavlMessageService;
    @RequestMapping("querymessageBymid")
    public List<LeavMessage> querymessageBymid(Integer mid){
        return leavlMessageService.querymessageBymid(mid);
    }
    @RequestMapping("querymessagereplyNonull")
    public List<LeavMessage> querymessagereplyNonull(Integer mid){
        return leavlMessageService.querymessagereplyNonull(mid);
    }
    @RequestMapping("querymessageNull")
    public List<LeavMessage> querymessageNull(Integer mid){
        return leavlMessageService.querymessageNull(mid);
    }
}
