package com.cookbook.service;

import com.cookbook.dao.UserDao;
import com.cookbook.dao.WorksDao;
import com.cookbook.entity.Users;
import com.cookbook.entity.Works;
import com.cookbook.entity.Works_message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorksService {
    @Resource
    WorksDao worksDao;
    @Resource
    UserDao userDao;
    public List<Works> querybymid(Integer mid){
        List<Works> works = worksDao.queryBystartcount(mid);
        for (Works work:works){
            Users user = userDao.querybyid(work.getUid());
            work.setUser(user);
            List<Users> users = worksDao.querystartBywid(work.getWid());
            work.setStartUsers(users);
            List<Works_message> messages = worksDao.queryworksmessage(work.getWid());
            work.setWorks_messages(messages);
        }
        return works;
    }
    public List<Works> queryOrderBytime(Integer mid){
        List<Works> works = worksDao.queryOrderBytime(mid);
        for (Works work:works){
            Users user = userDao.querybyid(work.getUid());
            work.setUser(user);
            List<Users> users = worksDao.querystartBywid(work.getWid());
            work.setStartUsers(users);
            List<Works_message> messages = worksDao.queryworksmessage(work.getWid());
            work.setWorks_messages(messages);
        }
        return works;
    }
    public List<Works_message> queryMyWorksMessage(String uid){
        List<Works_message> works_messages = worksDao.queryMyWorksMessage(uid);
        for(Works_message w:works_messages){
            w.setUsers(userDao.querybyid(Integer.valueOf(w.getUid())));
        }
        return works_messages;
    }
    public Works queryByWid(Integer wid){
        Works work = worksDao.queryByWid(wid);
            Users user = userDao.querybyid(work.getUid());
            work.setUser(user);
        List<Users> users = worksDao.querystartBywid(work.getWid());
        work.setStartUsers(users);
        List<Works_message> messages = worksDao.queryworksmessage(work.getWid());
        work.setWorks_messages(messages);
        return work;
    }
    public List<Works> queryGuanzhuWorks(Integer uid){
        List<Works> works = worksDao.queryGuanzhuWorks(uid);
        for (Works work:works){
            Users user = userDao.querybyid(work.getUid());
            work.setUser(user);
            List<Users> users = worksDao.querystartBywid(work.getWid());
            work.setStartUsers(users);
            List<Works_message> messages = worksDao.queryworksmessage(work.getWid());
            work.setWorks_messages(messages);
        }
        return works;
    }
    public List<Works> queryAllWorks(){
        List<Works> works = worksDao.queryAllWorks();
        for (Works work:works){
            Users user = userDao.querybyid(work.getUid());
            work.setUser(user);
            List<Users> users = worksDao.querystartBywid(work.getWid());
            work.setStartUsers(users);
            List<Works_message> messages = worksDao.queryworksmessage(work.getWid());
            work.setWorks_messages(messages);
        }
        return works;
    }
}
