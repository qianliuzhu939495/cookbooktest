package com.cookbook.controller.backstage;

import com.cookbook.entity.MenuTypes;
import com.cookbook.service.backstage.backmenuTypesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("backMenuTypes")
public class backmenuTypesContruller {
    @Resource
    backmenuTypesService backmenuTypesService;
    @RequestMapping("queryMenuTypes")
    public List<MenuTypes> queryMenuTyeps(){
        return backmenuTypesService.queryMenuTyeps();
    }
    @RequestMapping("queryMenuTypesTwo")
    public List<MenuTypes> queryMenuTypesTwo(Integer mLevel){
        return  backmenuTypesService.queryMenuTypes(mLevel);
    }
    @RequestMapping("queryMenuOne")
    public List<MenuTypes> queryMenuOne(){
        return backmenuTypesService.queryMenuOne();
    }
    @RequestMapping("queryMenuTwo")
    public List<MenuTypes> queryMenuTwo(Integer mtid){
        return backmenuTypesService.queryMenuTwo(mtid);
    }//根据一级菜谱查询所有二级菜谱
    @RequestMapping("insertMenuTypesTwo")
    public int insertMenuTypesTwo(String Mtname,Integer mLevel){
        return backmenuTypesService.insertMenuTypesTwo(Mtname,mLevel);
    }
    @RequestMapping("updateMenuTypesTwo")
    public int updateMenuTypesTwo(Integer mLevel,String mtname,Integer mtid){
        return backmenuTypesService.updateMenuTypesTwo(mLevel,mtname, mtid);
    }
}
