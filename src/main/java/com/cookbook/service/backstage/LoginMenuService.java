package com.cookbook.service.backstage;

import com.alibaba.fastjson.JSON;
import com.cookbook.dao.backstageDao.LoginMenu;
import com.cookbook.entity.Functions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class LoginMenuService {
    @Resource
    LoginMenu loginMenu;
    public String getLoginMenu(Integer cid){
        List<Map<String,Object>> mapList =  loginMenu.queryLoginMenu(cid);
        List<Map<String,Object>> newList = new ArrayList<>(); // 存放封装完整数据的总对象
        //int curMenuId = 0;//当前模块编号
        Map<String,Object> curMap = null;  // 对应最外层的键值对
        Map<String,Object> curMap2 = null;  // 对应一级的menu的键值对
        List<Map<String,Object>> curChildList = null; // 对应一级的childList的集合对象
        for (int i = 0;i < mapList.size();i++){
            Map<String,Object> map1 = mapList.get(i);
            int mparent = Integer.parseInt(map1.get("parentMenu").toString());//父级目录id  0
            int mMenuId = Integer.parseInt(map1.get("parentFid").toString());//二级菜单的父级id
            if (mparent==0){ // 是否是目录
                curMap = new HashMap<>();
                curChildList = new ArrayList<>();
                curMap.put("childList",curChildList);
                curMap.put("parentFid",mapList.get(i).get("parentFid"));
                curMap2 = new HashMap<>();
                curMap2.put("parentUrl",mapList.get(i).get("parentUrl"));
                curMap2.put("parentMenu",mapList.get(i).get("parentMenu"));
                curMap2.put("parentName",mapList.get(i).get("parentName"));
                curMap.put("parentMenus",curMap2);
                newList.add(curMap);
                /*for (int j = 0;j < mapList.size();j++){*/
                    /*Map<String,Object> map2 = mapList.get(j);*/
                    Map<String, Object> functions = (Map<String, Object>) map1.get("functions");
                    int jparent = Integer.parseInt(map1.get("parentMenu").toString());//0
                    int jMenuId = Integer.parseInt(map1.get("parentFid").toString());
                    if (mMenuId==jMenuId && jparent-mparent == 0 && jparent-mparent < 10){
                        Map<String,Object> childMap = new HashMap<>(); // 二级的外层map
                        Map<String,Object> childMenu = new HashMap<>();// 二级的menu对象
                        childMenu.put("Fid",functions.get("Fid"));
                        childMenu.put("Fname",functions.get("Fname"));
                        childMenu.put("URL",functions.get("URL"));
                        childMap.put("childList",new ArrayList<>());
                        childMap.put("menu",childMenu);
                        curChildList.add(childMap);
                    }
                /*}*/
            }
        }
        return JSON.toJSONString(newList);
    }
    public String queryOneMenu(Integer rid,Integer cid){
        List<Map<String,Object>> functions = loginMenu.queryOneMenu(cid);//一级
        List<Map<String,Object>> mapAll = new ArrayList<>();
        //二级菜单数据
        for (int i= 0;i<functions.size();i++){
            Integer fid = (Integer) functions.get(i).get("parentFid");
            Integer rids = (Integer) functions.get(i).get("Rid");
            Integer parentMenu = (Integer) functions.get(i).get("parentMenu");
            Integer parentFlevel = (Integer) functions.get(i).get("parentFlevel");
            if(parentMenu == parentFlevel){
                Map<String,Object> map = new HashMap<>();
                List<Functions> functions1 = loginMenu.queryTwoMenu(rids,fid);
                map.put("childList",functions1);
                mapAll.add(map);
            }
        }
        Map<String,Object> rs = new HashMap<>();
        rs.put("childList",functions);
        rs.put("menu",mapAll);
        return JSON.toJSONString(rs);
    }
    public String queryMenoOne(){
        List<Map<String, Object>> maps = loginMenu.queryMenuOne();
        return JSON.toJSONString(maps);
    }
    public String queryMenoTwo(){
        List<Map<String, Object>> maps = loginMenu.queryMenuOne();
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i= 0;i<maps.size();i++){
            Map<String,Object> mapp = new HashMap<>();
            Integer fid = (Integer) maps.get(i).get("parentFid");
                List<Map<String,Object>> functions = loginMenu.queryMenuTwo(fid);
                mapp.put("childList",functions);
                list.add(mapp);
        }
        return JSON.toJSONString(list);
    }
    public int changeRole(String arr){
        /*String[] split = arr.split(",");*/
        loginMenu.deleteMenuUser();
        String substring = arr.substring(1, arr.length() - 1);
        String[] split = substring.split(",");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            int Fid = Integer.parseInt(s);
            loginMenu.insertMenuUser(Fid);
        }
        return 1;
    }
}
