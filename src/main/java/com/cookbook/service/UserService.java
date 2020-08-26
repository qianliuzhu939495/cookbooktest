package com.cookbook.service;

import com.cookbook.dao.MenuDao;
import com.cookbook.dao.UserDao;
import com.cookbook.dao.WorksDao;
import com.cookbook.entity.Menu;
import com.cookbook.entity.Users;
import com.cookbook.entity.Works;
import com.cookbook.util.sms_util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserDao ud;
    @Resource
    MenuDao menuDao;
    @Resource
    WorksDao worksDao;
    public Users quryByPwd(String phone, String pwd){
        return ud.queryByPwd(phone,pwd);
    }
    public Users queryByphone(String phone){
        return  ud.queryByMsg(phone);
    }
    public Users queryByMsg(String phone,String rs){
        Users users=null;
        if(rs.indexOf("OK")!=-1){
            users =this.queryByphone(phone);
            if(users==null){
                ud.sasveone(phone);
            }
        }
        users = this.queryByphone(phone);
        System.out.println(users);
        return users;
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
}
