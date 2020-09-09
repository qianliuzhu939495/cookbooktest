package com.cookbook.service.backstage;

import com.cookbook.entity.MenuTypes;
import com.cookbook.entity.StudioTypes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BackRadioTypeService {
    @Resource
    com.cookbook.dao.backstageDao.BackRadioTypeDao backRadioTypeDao;
    public List<StudioTypes > queryStudioType(){
        return backRadioTypeDao.queryStudioType();
    }
    public List<StudioTypes > queryStudioTypeTwo(Integer sLevel){
        return  backRadioTypeDao.queryStudioTypeTwo(sLevel);
    }
    public List<StudioTypes > queryStudioOne(){
        return backRadioTypeDao.queryStudioOne();
    }
    public List<StudioTypes > queryStudioTwo(Integer stid){
        return backRadioTypeDao.queryStudioTwo(stid);
    }//根据一级菜谱查询所有二级菜谱
    public int insertStudioTypesTwo(String Stname,Integer stid){
        return backRadioTypeDao.insertStudioTypesTwo(Stname,stid);
    }
    public int updateStudioTypesTwo(Integer sLevel,String stname,Integer stid){
        return backRadioTypeDao.updateStudioTypesTwo(sLevel,stname,stid);
    }
}
