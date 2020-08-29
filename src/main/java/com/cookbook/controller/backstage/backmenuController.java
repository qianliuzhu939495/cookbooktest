package com.cookbook.controller.backstage;

import com.cookbook.entity.Functions;
import com.cookbook.service.backstage.backmenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("menu")
public class backmenuController {
    @Resource
    backmenuService backmenuService;
    @RequestMapping("queryFunction")
    public List<Functions> queryFunction(){
        return backmenuService.queryFunction();
    }
    @RequestMapping("updateFunction")
    public int updateFunctions(String Fname,Integer Fid){
        return backmenuService.updateFunctions(Fname,Fid);
    }
    @RequestMapping("queryCustomer")
    public List<Map<String,Object>> queryCustomer(){

        return backmenuService.queryCustomer();
    }
    @RequestMapping("updateCustomerState")
    public int updateCustomerState(Integer state,Integer cid){
        return backmenuService.updateCustomer(state,cid);
    }
    @RequestMapping("updateCustomerPwd")
    public int updateCustomerPwd(String Pwd,Integer cid){
        System.out.println(Pwd);
        return backmenuService.updateCustomerPwd(Pwd,cid);
    }
    @RequestMapping("insertCusotmer")
    public int insertCusotmer(String cname,String Lognum,String Pwd,Integer state,Integer Rid){
        System.out.println(Rid);
        return  backmenuService.insertCusotmer(cname, Lognum, Pwd, state, Rid);
    }
}
