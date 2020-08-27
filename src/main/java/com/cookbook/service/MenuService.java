package com.cookbook.service;

import com.cookbook.dao.MenuDao;
import com.cookbook.dao.UserDao;
import com.cookbook.dao.WorksDao;
import com.cookbook.entity.Menu;
import com.cookbook.entity.Users;
import com.cookbook.entity.Works;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService {
    @Resource
    MenuDao menuDao;
    @Resource
    WorksDao worksDao;
    @Resource
    UserDao userDao;
    public List<Menu> queryThisMonth(){
        List<Menu> menus = menuDao.queryThisMonth();
        for (Menu menu:menus){
            List<Works> works = worksDao.querybymid(menu.getMid());
            menu.setWorks(works);
            Users users = userDao.querybyid(menu.getUid());
            menu.setUsers(users);
        }
        return menus;
    }
    public List<Menu> queryupMonth(){
        List<Menu> menus = menuDao.queryupMonth();
        for (Menu menu:menus){
            List<Works> works = worksDao.querybymid(menu.getMid());
            menu.setWorks(works);
            Users users = userDao.querybyid(menu.getUid());
            menu.setUsers(users);
        }
        return menus;
    }
    public List<Menu> queryNewMenu(){
        return menuDao.queryNewMenu();
    }

    public List<Menu> querybymtidorderliuxing(Integer mtid) {
        List<Menu> menus = menuDao.querybymtidorderliuxing(mtid);
        for (Menu menu:menus){
            List<Works> works = worksDao.querySevenWork(menu.getMid());
            menu.setWorks(works);
        }
        return menus;
    }
}
