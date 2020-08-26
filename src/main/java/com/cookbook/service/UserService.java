package com.cookbook.service;
import com.cookbook.dao.MenuDao;
import com.cookbook.dao.UserDao;
import com.cookbook.dao.WorksDao;
import com.cookbook.entity.Menu;
import com.cookbook.entity.Users;
import com.cookbook.entity.Works;
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
        Users users = ud.queryByMsg(phone);
        if(null==users){
            ud.sasveone(phone);
        }
        users = ud.queryByMsg(phone);
        return users;
    }
    public Users queryByMsg(String phone){
        return ud.queryByMsg(phone);

    }
    public Integer sasveone(String phone){
        return ud.sasveone(phone);
    }
    public Integer sasveoneRe(String pwd,String phone){
        return ud.sasveoneRe(pwd,phone);
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
