package com.cookbook.service;

import com.cookbook.dao.*;
import com.cookbook.entity.*;
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
    @Resource
    MaterialsDetailDao materialsDetailDao;
    @Resource
    MenuStepsDao menuStepsDao;
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
            List<MaterialsDetail> materialsDetails = materialsDetailDao.queryBymid(menu.getMid());
            menu.setMaterialsDetails(materialsDetails);
            List<MenuStep> menuSteps = menuStepsDao.queryBymid(menu.getMid());
            menu.setMenuSteps(menuSteps);
            Users querybyid = userDao.querybyid(menu.getUid());
            menu.setUsers(querybyid);
        }
        return menus;
    }

    public List<Menu> querybymtidorderShouhuanying(Integer mtid) {
        List<Menu> menus = menuDao.querybymtidorderShouhuanying(mtid);
        for (Menu menu:menus){
            List<Works> works = worksDao.querybymid(menu.getMid());
            menu.setWorks(works);
            List<MaterialsDetail> materialsDetails = materialsDetailDao.queryBymid(menu.getMid());
            menu.setMaterialsDetails(materialsDetails);
            List<MenuStep> menuSteps = menuStepsDao.queryBymid(menu.getMid());
            menu.setMenuSteps(menuSteps);
            Users querybyid = userDao.querybyid(menu.getUid());
            menu.setUsers(querybyid);
        }
        return menus;
    }
    public Menu savemenu(Menu menu){
        menuDao.savemenu(menu);
        return menuDao.querybypic(menu.getPic());
    }

    public List<Menu> queryAllMenu(){
        List<Menu> menus = menuDao.queryAllMenu();
        for (Menu menu:menus){
            List<Works> works = worksDao.querybymid(menu.getMid());
            menu.setWorks(works);
            List<MaterialsDetail> materialsDetails = materialsDetailDao.queryBymid(menu.getMid());
            menu.setMaterialsDetails(materialsDetails);
            List<MenuStep> menuSteps = menuStepsDao.queryBymid(menu.getMid());
            menu.setMenuSteps(menuSteps);
            Users querybyid = userDao.querybyid(menu.getUid());
            menu.setUsers(querybyid);
        }
        return menus;
    }
    public List<Menu> queryBymname(String mname){
        List<Menu> menus = menuDao.queryBymname(mname);
        for (Menu menu:menus){
            List<Works> works = worksDao.querybymid(menu.getMid());
            menu.setWorks(works);
            List<MaterialsDetail> materialsDetails = materialsDetailDao.queryBymid(menu.getMid());
            menu.setMaterialsDetails(materialsDetails);
            List<MenuStep> menuSteps = menuStepsDao.queryBymid(menu.getMid());
            menu.setMenuSteps(menuSteps);
            Users querybyid = userDao.querybyid(menu.getUid());
            menu.setUsers(querybyid);
        }
        return menus;
    }
}
