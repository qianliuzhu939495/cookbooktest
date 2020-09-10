package com.cookbook.service.backstage;

import com.alibaba.fastjson.JSON;
import com.cookbook.dao.backstageDao.BackReportFormDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BackReportFormService {
    @Resource
    BackReportFormDao backReportFormDao;
    public String ReportFormIncomeMonth(){//月收入
        List<Map<String, Object>> list = backReportFormDao.ReportFormIncomeMonth();
        List<Map<String,Object>> liss = new ArrayList<>();
        System.out.println(list);
        if(list.get(0) != null) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                double shares = (double) list.get(i).get("Shares");
                map.put("name", "本月收入");
                map.put("value", shares);
                liss.add(map);
            }
            return JSON.toJSONString(liss);
        }else{
            return null;
        }
    }
    public List<Map<String, Object>> ReportFormMenuMonth(){
        return backReportFormDao.ReportFormMenuMonth();
    }
    public List<Map<String, Object>> ReportFormMenuTypesMonth(){
        return backReportFormDao.ReportFormMenuTypesMonth();
    }
    public String ReportFormIncomeYear(){//年收入
        List<Map<String, Object>> lists = backReportFormDao.ReportFormIncomeYear();
        List<Map<String,Object>> newList = new ArrayList<>();
        if(lists.get(0) != null){
            for (int i= 0;i<lists.size();i++){
                Map<String,Object> maps = new HashMap<>();
                double shares =(double) lists.get(i).get("Shares");
                maps.put("name","本年收入");
                maps.put("value",shares);
                newList.add(maps);
            }
            return JSON.toJSONString(newList);
        }else{
            return null;
        }

    }
    public List<Map<String, Object>> ReportFormMenuYear(){
        return backReportFormDao.ReportFormMenuYear();
    }
    public List<Map<String, Object>> ReportFormMenuTypesYear(){
        return backReportFormDao.ReportFormMenuTypesYear();
    }
}
