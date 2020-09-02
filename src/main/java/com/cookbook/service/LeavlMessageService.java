package com.cookbook.service;

import com.cookbook.dao.LeavlMessageDao;
import com.cookbook.dao.UserDao;
import com.cookbook.entity.LeavMessage;
import com.cookbook.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeavlMessageService {
    @Resource
    LeavlMessageDao leavlMessageDao;
    @Resource
    UserDao userDao;
    public List<LeavMessage> querymessageBymid(Integer mid){
        List<LeavMessage> leavMessages = leavlMessageDao.querymessageBymid(mid);
        for (LeavMessage leavMessage:leavMessages){
            Users querybyid = userDao.querybyid(leavMessage.getUid());
            leavMessage.setLeavUsers(querybyid);
        }
        return leavMessages;
    }
}
