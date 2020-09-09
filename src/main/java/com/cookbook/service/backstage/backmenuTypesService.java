package com.cookbook.service.backstage;

import com.cookbook.dao.backstageDao.backmenuTypes;
import com.cookbook.entity.MenuTypes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class backmenuTypesService {
    @Resource
    com.cookbook.dao.backstageDao.backmenuTypes backmenuTypes;
    public List<MenuTypes> queryMenuTyeps(){
        return backmenuTypes.queryMenuType();
    }
    public List<MenuTypes> queryMenuTypes(Integer mLevel){
        return  backmenuTypes.queryMenuTypeTwo(mLevel);
    }
    public List<MenuTypes> queryMenuOne(){
        return backmenuTypes.queryMenuOne();
    }
    public List<MenuTypes> queryMenuTwo(Integer mtid){
        return backmenuTypes.queryMenuTwo(mtid);
    }//根据一级菜谱查询所有二级菜谱
    public int insertMenuTypesTwo(String Mtname,Integer mtid){
        return backmenuTypes.insertMenuTypesTwo(Mtname,mtid);
    }
    public int updateMenuTypesTwo(Integer mLevel,String mtname,Integer mtid){
        return backmenuTypes.updateMenuTypesTwo(mLevel,mtname, mtid);
    }
}
