package com.cookbook.service;
import com.cookbook.dao.MenuDao;
import com.cookbook.dao.StudioOrder;
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
    @Resource
    StudioOrder studioOrder;
    public Users quryByPwd(String phone, String pwd){
        Users users = ud.queryByPwd(phone, pwd);
        System.out.println(users);
        if(null!=users) {
            Integer uid = users.getUid();
            users.setUsers(ud.queryguanzhu(uid));
            users.setFollows(ud.querybeiguanzhu(uid));
            users.setUser_menus(ud.queryLikemenu(uid));
            users.setUser_studios(ud.queryLikestudios(uid));
            users.setMunus(menuDao.querybyuid(uid));
            users.setWorks(worksDao.querybyuid(uid));
            users.setMystudio(studioOrder.queryBypay(uid));
            users.setMystudio(studioOrder.queryByincome(uid));
        }
        return users;
    }
    public Users queryByphone(String phone){
        Users users = ud.queryByMsg(phone);
        if(null==users){
            ud.sasveone(phone);
        }
        users = ud.queryByMsg(phone);
        Integer uid = users.getUid();
        users.setUsers(ud.queryguanzhu(uid));
        users.setFollows(ud.querybeiguanzhu(uid));
        users.setUser_menus(ud.queryLikemenu(uid));
        users.setUser_studios(ud.queryLikestudios(uid));
        users.setMunus(menuDao.querybyuid(uid));
        users.setWorks(worksDao.querybyuid(uid));
        users.setMystudio(studioOrder.queryBypay(uid));
        users.setMystudio(studioOrder.queryByincome(uid));
        return users;
    }
    public Users queryByMsg(String phone){
        Users users = ud.queryByMsg(phone);
        Integer uid = users.getUid();
        users.setUsers(ud.queryguanzhu(uid));
        users.setFollows(ud.querybeiguanzhu(uid));
        users.setUser_menus(ud.queryLikemenu(uid));
        users.setUser_studios(ud.queryLikestudios(uid));
        users.setMunus(menuDao.querybyuid(uid));
        users.setWorks(worksDao.querybyuid(uid));
        users.setMystudio(studioOrder.queryBypay(uid));
        users.setMystudio(studioOrder.queryByincome(uid));
        return users;

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
