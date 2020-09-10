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
    public List<LeavMessage> querymessagereplyNonull(Integer mid){
        List<LeavMessage> leavMessages = leavlMessageDao.querymessagereplyNonull(mid);
        for (LeavMessage leavMessage:leavMessages){
            Users querybyid = userDao.querybyid(leavMessage.getUid());
            leavMessage.setLeavUsers(querybyid);
        }
        return leavMessages;
    }
    public List<LeavMessage> querymessageNull(Integer mid){
        List<LeavMessage> leavMessages = leavlMessageDao.querymessageNull(mid);
        for (LeavMessage leavMessage:leavMessages){
            Users querybyid = userDao.querybyid(leavMessage.getUid());
            leavMessage.setLeavUsers(querybyid);
        }
        return leavMessages;
    }
    public int add(LeavMessage leavMessage){
        return leavlMessageDao.add(leavMessage);
    }
    public int reply(LeavMessage leavMessage){
        return leavlMessageDao.reply(leavMessage);
    }
    public int delBylid(Integer lid){
        return leavlMessageDao.delBylid(lid);
    }
    public int updatestate(Integer lid){
        return leavlMessageDao.updatestate(lid);
    }
}
