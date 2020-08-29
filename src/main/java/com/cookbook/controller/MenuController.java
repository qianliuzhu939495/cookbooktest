package com.cookbook.controller;

import com.cookbook.entity.Menu;
import com.cookbook.service.MenuService;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
