package com.cookbook.service.backstage;

import com.cookbook.dao.backstageDao.LoginDao;
import com.cookbook.entity.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginService {
    @Resource
    LoginDao loginDao;
    public Customer Login(String Lognum,String Pwd){
        return loginDao.Login(Lognum,Pwd);
    }
    public List<Customer> queryByCid(Integer cid){
        return loginDao.queryByCid(cid);
    }
    public int UpdCustomerPwd(String Pwd, Integer cid){
        return loginDao.UpdCustomerPwd(Pwd,cid);
    }
}
