package com.cookbook.controller;

import com.cookbook.dao.MenuDao;
import com.cookbook.entity.LeavMessage;
import com.cookbook.dao.MenuStepsDao;
import com.cookbook.entity.MaterialsDetail;
import com.cookbook.entity.Menu;
import com.cookbook.entity.MenuStep;
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
    @RequestMapping("queryThisMonth")
    public List<Menu> queryThisMonth(){
        return menuService.queryThisMonth();
    }

    @RequestMapping("deletemenuBymid")
    public Integer deletemenuBymid(String mid){
        return menuDao.deletemenuBymid(mid);
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
        System.out.println(mid);
        return menuService.querybymid(mid);
    }
    @RequestMapping("queryAllByuid")
    public List<Menu> queryAllByuid(Integer uid){
        return menuDao.queryThreieMenus(uid);
    }
    @RequestMapping("queryMyMenuMessage")
    public List<LeavMessage> queryMyMenuMessage(Integer uid){
        return menuService.queryLeavMessage(uid);
    }
    @RequestMapping("querybymtid")
    public List<Menu> querybymtid(Integer mtid){
        return menuService.querybymtid(mtid);
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
    @RequestMapping("queryMenudetailBymid")
    public Menu queryMenudetailBymid(Integer mid){

        return menuService.queryMenudetailBymid(mid);
    }
    @RequestMapping("updateMenus")
    public int updateMenus(@RequestBody Menu menu){
        //添加菜谱 详情 步骤
        return menuService.updateMenus(menu);

    }
    @RequestMapping("deleteMenu")
    public int deleteMenu(String mid){
        //添加菜谱 详情 步骤
        return menuService.deleteMenu(mid);

    }

}
