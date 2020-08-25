package com.cookbook.service;

import com.cookbook.dao.UserDao;
import com.cookbook.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserDao ud;
    public Users quryByPwd(String phone, String pwd){
        return ud.queryByPwd(phone,pwd);
    }
    public Users queryByphone(String phone){
        Users users = ud.queryByMsg(phone);
        if(null==users){
            ud.sasveone(phone);
        }
        users = ud.queryByMsg(phone);
        return users;
    }
    public Users queryByMsg(String phone){
        return ud.queryByMsg(phone);

    }
    public Integer sasveone(String phone){
        return ud.sasveone(phone);
    }
    public Integer sasveoneRe(String pwd,String phone){
        return ud.sasveoneRe(pwd,phone);
    }
    public List<Users> queryAll(){
        return ud.queryAll();
    }
}
