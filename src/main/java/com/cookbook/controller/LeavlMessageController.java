package com.cookbook.controller;

import com.cookbook.dao.LeavlMessageDao;
import com.cookbook.entity.LeavMessage;
import com.cookbook.service.LeavlMessageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<LeavMessage> querymessageBymid(Integer mid)  throws Exception {
        return leavlMessageService.querymessageBymid(mid);
    }
    @RequestMapping("querymessagereplyNonull")
    public List<LeavMessage> querymessagereplyNonull(Integer mid) throws Exception {
        return leavlMessageService.querymessagereplyNonull(mid);
    }
    @RequestMapping("querymessageNull")
    public List<LeavMessage> querymessageNull(Integer mid) throws Exception {
        return leavlMessageService.querymessageNull(mid);
    }
    @RequestMapping("add")
    public int add(@RequestBody LeavMessage leavMessage) throws Exception {
        return leavlMessageService.add(leavMessage);
    }
    @RequestMapping("reply")
    public int reply(@RequestBody LeavMessage leavMessage) throws Exception {
        return leavlMessageService.reply(leavMessage);
    }
    @RequestMapping("delBylid")
    public int delBylid(Integer lid) throws Exception {
        return leavlMessageService.delBylid(lid);
    }
    @RequestMapping("updatestate")
    public int updatestate(Integer lid) throws Exception {
        return leavlMessageService.updatestate(lid);
    }
}
