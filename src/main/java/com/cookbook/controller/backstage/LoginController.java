package com.cookbook.controller.backstage;

import com.cookbook.entity.Customer;
import com.cookbook.service.backstage.LoginService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
//支持跨域
@CrossOrigin
//所有方法都是局部返回，默认返回json
@RestController
//窄化路径，限制只能backstage访问此类
@RequestMapping("backstage")
public class LoginController {
    //按照byName自动注入loginservice
    @Resource
    LoginService loginService;

    @RequestMapping("Login")
    public Customer login(String Lognum,String Pwd){
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
