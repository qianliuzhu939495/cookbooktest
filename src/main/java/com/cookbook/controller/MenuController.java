package com.cookbook.controller;

import com.cookbook.dao.MaterialsDetailDao;
import com.cookbook.dao.MenuDao;
import com.cookbook.dao.MenuStepsDao;
import com.cookbook.entity.Menu;
import com.cookbook.service.MenuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("MenuController")
public class MenuController {
    @Resource
    MenuService menuService;
    @Resource
    MenuDao menuDao;
    @Resource
    MenuStepsDao menuStepsDao;
    @Resource
    MaterialsDetailDao materialsDetailDao;
    @RequestMapping("queryThisMonth")
    public List<Menu> queryThisMonth(){
        return menuService.queryThisMonth();
    }
    @RequestMapping("queryupMonth")
    public List<Menu> queryupMonth(){
        return menuService.queryupMonth();
    }
    @RequestMapping("queryNewMenu")
    public List<Menu> queryNewMenu(){
        return menuService.queryNewMenu();
    }
    @RequestMapping("querybymtidorderliuxing")
    public List<Menu> querybymtidorderliuxing(Integer mtid){

        return menuService.querybymtidorderliuxing(mtid);
    }
    @RequestMapping("querybymtidorderShouhuanying")
    public List<Menu> querybymtidorderShouhuanying(Integer mtid){

        return menuService.querybymtidorderShouhuanying(mtid);
    }
    @RequestMapping("queryAllMenu")
    public List<Menu> queryAllMenu(){

        return menuService.queryAllMenu();
    }
    @RequestMapping("queryBymname")
    public List<Menu> queryBymname(String mname){
        return menuService.queryBymname(mname);
    }
    @RequestMapping("querybymid")
    public Menu querybymid(Integer mid){
        return menuService.querybymid(mid);
    }
    @RequestMapping("queryAllByuid")
    public List<Menu> queryAllByuid(Integer uid){
        return menuDao.queryThreieMenus(uid);
    }
    //查询菜谱详情+步骤+用料
    @RequestMapping("queryMenudetailBymid")
    public Menu queryMenudetailBymid(Integer mid){
        Menu querybymid = menuDao.querybymid(mid);
        querybymid.setMenuSteps(menuStepsDao.queryBymid(mid));
        querybymid.setMaterialsDetails(materialsDetailDao.queryBymid(mid));
        return querybymid;
    }
    @RequestMapping("updateMenus")
    public Integer updateMenus(@RequestBody Menu menu){
        System.out.println(menu);
       return menuService.updateMenus(menu);
    }
    @RequestMapping("deleteMenu")
    public Integer deleteMenu(String mid){
        System.out.println(mid);
        return menuService.deleteMenu(mid);
    }
    @RequestMapping("queryusercollect")
    public Integer queryusercollect(String mid,String uid){
        return menuDao.queryusercollect(mid,uid);
    }
    @RequestMapping("updateCollection")
    public Integer updateCollection(String mid,String uid){
       try {
           int queryusercollect = menuDao.queryusercollect(mid, uid);
           if(queryusercollect>0){
               menuDao.deleteCollection(mid,uid);
               return 0;
           }else{
               menuDao.saveCollection(uid,mid);
               return 1;
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return 1;
    }

}
