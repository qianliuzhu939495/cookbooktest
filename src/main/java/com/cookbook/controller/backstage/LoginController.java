package com.cookbook.controller.backstage;

import com.cookbook.entity.Customer;
import com.cookbook.service.backstage.LoginService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("backstage")
public class LoginController {
    @Resource
    LoginService loginService;
    @RequestMapping("Login")
    public List<Customer> login(String Lognum,String Pwd){
        System.out.println(Lognum);
        System.out.println(Pwd);
        System.out.println(loginService.Login(Lognum, Pwd));
        return loginService.Login(Lognum, Pwd);
    }
    @RequestMapping("QueryCustomerByCid")
    public List<Customer> queryByCid(Integer cid){
        return loginService.queryByCid(cid);
    }
    @RequestMapping("UpdCustomerPwd")
    public int UpdCustomerPwd(String Pwd,Integer cid){
        return loginService.UpdCustomerPwd(Pwd, cid);
    }
}
