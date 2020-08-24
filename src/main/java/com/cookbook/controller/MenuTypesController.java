package com.cookbook.controller;

import com.cookbook.entity.MenuTypes;
import com.cookbook.service.MenuTypesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("MenuTypesController")
public class MenuTypesController {
    @Resource
    MenuTypesService menuTypesService;
    @RequestMapping("queryall")
    public List<MenuTypes> queryall(){
        return menuTypesService.queryall();
    }
}
