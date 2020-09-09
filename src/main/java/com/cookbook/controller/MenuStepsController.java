package com.cookbook.controller;

import com.cookbook.entity.MenuStep;
import com.cookbook.service.MenuStepsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("MenuStepsController")
public class MenuStepsController {
    @Resource
    MenuStepsService menuStepsService;
    @RequestMapping("queryBymid")
    public List<MenuStep> queryBymid(Integer mid){
        return menuStepsService.queryBymid(mid);
    }
}
