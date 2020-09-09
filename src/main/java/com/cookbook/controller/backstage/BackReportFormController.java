package com.cookbook.controller.backstage;

import com.cookbook.dao.backstageDao.BackReportFormDao;
import com.cookbook.service.backstage.BackReportFormService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("BackReportForm")
public class BackReportFormController {
    @Resource
    BackReportFormService backReportFormService;
    @RequestMapping("ReportFormIncomeMonth")
    public String ReportFormIncomeMonth(){
        System.out.println(backReportFormService.ReportFormIncomeMonth());
        return backReportFormService.ReportFormIncomeMonth();
    }
    @RequestMapping("ReportFormMenuMonth")
    public List<Map<String, Object>> ReportFormMenuMonth(){
        return backReportFormService.ReportFormMenuMonth();
    }
    @RequestMapping("ReportFormMenuTypesMonth")
    public List<Map<String, Object>> ReportFormMenuTypesMonth(){
        return backReportFormService.ReportFormMenuTypesMonth();
    }
    @RequestMapping("ReportFormIncomeYear")
    public String ReportFormIncomeYear(){
        return backReportFormService.ReportFormIncomeYear();
    }
    @RequestMapping("ReportFormMenuYear")
    public List<Map<String, Object>> ReportFormMenuYear(){
        return backReportFormService.ReportFormMenuYear();
    }
    @RequestMapping("ReportFormMenuTypesYear")
    public List<Map<String, Object>> ReportFormMenuTypesYear(){
        return backReportFormService.ReportFormMenuTypesYear();
    }
}
