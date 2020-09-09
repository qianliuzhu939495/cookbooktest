package com.cookbook.service;

import com.cookbook.dao.UserDao;
import com.cookbook.dao.Works_messageDao;
import com.cookbook.entity.Users;
import com.cookbook.entity.Works_message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Works_messageService {
    @Resource
    Works_messageDao works_messageDao;
    @Resource
    UserDao userDao;
    public List<Works_message> querybywid(Integer wid){
        List<Works_message> worksMessages = works_messageDao.querybywid(wid, 0);
        for (Works_message worksMessage:worksMessages){
            Users user = userDao.querybyid(worksMessage.getUid());
            worksMessage.setUsers(user);
            List<Works_message> worksMessages1 = works_messageDao.querybywid(wid, worksMessage.getWmid());
            for (Works_message w:worksMessages1){
                Users querybyid = userDao.querybyid(w.getUid());
                w.setUsers(querybyid);
            }
            worksMessage.setWorks_messages(worksMessages1);
        }
        return worksMessages;
    }
    public int add(Works_message wm){
        return works_messageDao.add(wm);
    }
    public int delete(Integer wmid){
        works_messageDao.delBywmid(wmid);
        works_messageDao.delByupid(wmid);
        return 1;
    }
}
