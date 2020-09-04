package com.cookbook.controller;

import com.cookbook.dao.WorksDao;
import com.cookbook.entity.Works;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("WorksController")
public class WorksController {
    @Resource
    WorksDao worksDao;

    @RequestMapping("saveWorks")
    public Integer saveWorks(@RequestBody Works works){
        return worksDao.saveWorks(works);
    }
}
