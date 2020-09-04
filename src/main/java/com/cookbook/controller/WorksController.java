package com.cookbook.controller;

import com.cookbook.dao.WorksDao;
import com.cookbook.entity.Works;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import com.cookbook.entity.Works;
import com.cookbook.service.WorksService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("WorksController")
public class WorksController {
    @Resource
    WorksDao worksDao;
    @Resource
    WorksService worksService;
    @RequestMapping("saveWorks")
    public Integer saveWorks(@RequestBody Works works) {
        return worksDao.saveWorks(works);
    }
    @RequestMapping("querybymid")
    public List<Works> querybymid(Integer mid){
        return worksService.querybymid(mid);
    }
    @RequestMapping("queryOrderBytime")
    public List<Works> queryOrderBytime(Integer mid){
        return worksService.queryOrderBytime(mid);
    }
}
