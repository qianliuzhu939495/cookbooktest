package com.cookbook.service;

import com.cookbook.dao.Studio_MessageDao;
import com.cookbook.dao.UserDao;
import com.cookbook.entity.Studio_message;
import com.cookbook.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Studio_MessageService {
    @Resource
    Studio_MessageDao studio_messageDao;
    @Resource
    UserDao userDao;
    public List<Studio_message> queryBysid(Integer sid){
        List<Studio_message> studio_messages = studio_messageDao.queryBysid(sid);
        for (Studio_message studioMessage:studio_messages){
            Users user = userDao.querybyid(studioMessage.getUid());
            studioMessage.setLeveluser(user);
        }
        return studio_messages;
    }
    public int add(Studio_message studio_message){
        return studio_messageDao.add(studio_message);
    }
}
