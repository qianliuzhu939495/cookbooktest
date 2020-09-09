package com.cookbook.controller;

import com.cookbook.entity.StudioTypes;
import com.cookbook.service.StudioTypeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("StudioTypeController")
public class StudioTypeController {
    @Resource
    StudioTypeService studioTypeService;
    @RequestMapping("queryall")
    public List<StudioTypes> queryall(){
        return studioTypeService.queryall();
    }
}
