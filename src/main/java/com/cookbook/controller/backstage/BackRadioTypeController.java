package com.cookbook.controller.backstage;

import com.cookbook.entity.MenuTypes;
import com.cookbook.entity.StudioTypes;
import com.cookbook.service.backstage.BackRadioTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("BackRadioTypeController")
public class BackRadioTypeController {
    @Resource
    BackRadioTypeService  backRadioTypeService;
    @RequestMapping("queryStudioType")
    public List<StudioTypes > queryStudioType(){
        return backRadioTypeService.queryStudioType();
    }
    @RequestMapping("queryStudioTypeTwo")
    public List<StudioTypes > queryStudioTypeTwo(Integer sLevel){
        return  backRadioTypeService.queryStudioTypeTwo(sLevel);
    }
    @RequestMapping("queryStudioOne")
    public List<StudioTypes > queryStudioOne(){
        return backRadioTypeService.queryStudioOne();
    }
    @RequestMapping("queryStudioTwo")
    public List<StudioTypes > queryStudioTwo(Integer stid){
        return backRadioTypeService.queryStudioTwo(stid);
    }//根据一级菜谱查询所有二级菜谱
    @RequestMapping("insertStudioTypesTwo")
    public int insertStudioTypesTwo(String Stname,Integer sLevel){
        return backRadioTypeService.insertStudioTypesTwo(Stname,sLevel);
    }
    @RequestMapping("updateStudioTypesTwo")
    public int updateStudioTypesTwo(Integer sLevel,String stname,Integer stid){
        return backRadioTypeService.updateStudioTypesTwo(sLevel,stname, stid);
    }
}
