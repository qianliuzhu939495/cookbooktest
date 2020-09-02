package com.cookbook.service;
import com.cookbook.dao.*;
import com.cookbook.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Resource
    UserDao ud;
    @Resource
    MenuDao menuDao;
    @Resource
    WorksDao worksDao;
    @Resource
    StudioOrder studioOrder;
    @Resource
    MenuStepsDao menuStepsDao;
    @Resource
    MaterialsDetailDao materialsDetailDao;
    @Resource
    LeavlMessageDao leavlMessageDao;
    @Resource
    StudioDao studioDao;
    public Users quryByPwd(String phone, String pwd){
        Users users = ud.queryByPwd(phone, pwd);
        System.out.println(users);
        if(null!=users) {
            Integer uid = users.getUid();
            users.setUsers(ud.queryguanzhu(uid));
            users.setFollows(ud.querybeiguanzhu(uid));
            List<Menu> menus1 = ud.queryLikemenu(uid);
            System.out.println(menus1);
            users.setUser_menus(menus1);
            users.setUser_studios(ud.queryLikestudios(uid));
            List<Menu> menus = menuDao.querybyuid(uid);
            for(Menu m:menus){
                m.setWorks(worksDao.querybymid(m.getMid()));
                m.setLeavMessages(leavlMessageDao.querymessageBymid(m.getMid()));
            }
            users.setMunus(menus);
            List<Works> works = worksDao.querybyuidtwo(uid);
            for(Works w:works){
                w.setWorks_messages(worksDao.queryworksmessage(w.getWid()));
                w.setStartUsers(worksDao.querystartBywid(w.getWid()));
            }
            users.setWorks(works);
            users.setMystudio(studioOrder.queryBypay(uid));
            users.setMystudio(studioOrder.queryByincome(uid));
        }
        return users;
    }
    public Users queryByphone(String phone){
        Users users = ud.queryByMsg(phone);
        if(null==users){
            ud.sasveone(UUID.randomUUID().toString().replaceAll("-", ""),phone);
        }
        users = ud.queryByMsg(phone);
        Integer uid = users.getUid();
        users.setUsers(ud.queryguanzhu(uid));
        users.setFollows(ud.querybeiguanzhu(uid));
        users.setUser_studios(ud.queryLikestudios(uid));
        List<Menu> menus = menuDao.querybyuid(uid);
        for(Menu m:menus){
            m.setWorks(worksDao.querybymid(m.getMid()));
            m.setLeavMessages(leavlMessageDao.querymessageBymid(m.getMid()));
        }
        users.setMunus(menus);
        List<Works> works = worksDao.querybyuidtwo(uid);
        for(Works w:works){
            w.setWorks_messages(worksDao.queryworksmessage(w.getWid()));
            w.setStartUsers(worksDao.querystartBywid(w.getWid()));
        }
        users.setWorks(works);        users.setMystudio(studioOrder.queryBypay(uid));
        users.setMystudio(studioOrder.queryByincome(uid));
        return users;
    }
    public Users queryByMsg(String phone){
        Users users = ud.queryByMsg(phone);
        Integer uid = users.getUid();
        users.setUsers(ud.queryguanzhu(uid));
        users.setFollows(ud.querybeiguanzhu(uid));
        users.setUser_studios(ud.queryLikestudios(uid));
        List<Menu> menus = menuDao.querybyuid(uid);
        for(Menu m:menus){
            m.setWorks(worksDao.querybymid(m.getMid()));
            m.setLeavMessages(leavlMessageDao.querymessageBymid(m.getMid()));
        }
        users.setMunus(menus);
        List<Works> works = worksDao.querybyuidtwo(uid);
        for(Works w:works){
            w.setWorks_messages(worksDao.queryworksmessage(w.getWid()));
            w.setStartUsers(worksDao.querystartBywid(w.getWid()));
        }
        users.setWorks(works);        users.setMystudio(studioOrder.queryBypay(uid));
        users.setMystudio(studioOrder.queryByincome(uid));
        return users;

    }
    public Integer sasveone(String phone){
        return ud.sasveone(UUID.randomUUID().toString().replaceAll("-", ""),phone);
    }
    public Integer sasveoneRe(String pwd,String phone){
        return ud.sasveoneRe(UUID.randomUUID().toString().replaceAll("-", ""),pwd,phone);
    }
    public List<Users> queryAll(){
        return ud.queryAll();
    }
    public List<Users> queryuserinfo(){
        List<Users> users = ud.queryAll();
        for (Users user:users){
            List<Menu> menus = menuDao.querybyuid(user.getUid());
            user.setMunus(menus);
            List<Works> works = worksDao.querybyuid(user.getUid());
            user.setWorks(works);
            List<Users> guanzhu = ud.queryguanzhu(user.getUid());
            user.setUsers(guanzhu);
        }
        return users;
    }
    public List<Menu> querymenuworklevelmessage(Integer uid){
        List<Menu> menus = menuDao.querybyuid(uid);
        for(Menu m:menus){
            m.setWorks(worksDao.querybymid(m.getMid()));
            m.setLeavMessages(leavlMessageDao.querymessageBymid(m.getMid()));
        }
        return menus;
    }
    public List<Works> queryworkstartmessage(Integer uid){
        List<Works> works = worksDao.querybyuidtwo(uid);
        for(Works w:works){
            w.setWorks_messages(worksDao.queryworksmessage(w.getWid()));
            w.setStartUsers(worksDao.querystartBywid(w.getWid()));
        }
        return works;
    }
    public List<Menu> queryusercollectedmenu(Integer uid){
        return menuDao.queryusercollectedmenu(uid);
    }
    public List<Studio> queryusercollectedstudio(Integer uid){
        return studioDao.queryusercollectedstudio(uid);
    }
    public List<Users> queryBylikeUname(String uname){
        List<Users> users = ud.queryBylikeUname(uname);
        for (Users user:users){
            List<Menu> menus = menuDao.querybyuid(user.getUid());
            user.setMunus(menus);
            List<Works> works = worksDao.querybyuid(user.getUid());
            user.setWorks(works);
            List<Users> guanzhu = ud.queryguanzhu(user.getUid());
            user.setUsers(guanzhu);
        }
        return users;
    }
    public Users querybyuid(Integer uid){
        return ud.querybyid(uid);
    }
}
