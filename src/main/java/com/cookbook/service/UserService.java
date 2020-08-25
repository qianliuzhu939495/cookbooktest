package com.cookbook.service;

import com.cookbook.dao.UserDao;
import com.cookbook.entity.Users;
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
        return  ud.queryByMsg(phone);
    }
    public Users queryByMsg(String phone,String rs){
        Users users=null;
        if(rs.indexOf("OK")!=-1){
            users =this.queryByphone(phone);
            if(users==null){
                ud.sasveone(phone);
            }
        }
        users = this.queryByphone(phone);
        System.out.println(users);
        return users;
    }
    public List<Users> queryAll(){
        return ud.queryAll();
    }
}
