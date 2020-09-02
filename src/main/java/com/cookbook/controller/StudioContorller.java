package com.cookbook.controller;

import com.cookbook.dao.StudioDao;
import com.cookbook.entity.StudioTypes;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("StudioContorller")
public class StudioContorller {
    @Resource
    StudioDao studioDao;

    @RequestMapping("queryTypes")
    public List<StudioTypes> queryTypes(){
        return studioDao.queryTypes();
    }
    @RequestMapping("queryChildrenTypes")
    public List<StudioTypes> queryChildrenTypes(String slevel){
        List<StudioTypes> st=null;
        try {
            st = studioDao.queryChildrenTypes(slevel);
        }catch (Exception e){
            e.printStackTrace();
        }
        return st;
    }
}
