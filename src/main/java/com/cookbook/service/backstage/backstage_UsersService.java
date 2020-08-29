package com.cookbook.service.backstage;

import com.cookbook.dao.backstageDao.backstage_UsersDao;
import com.cookbook.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class backstage_UsersService {
    @Resource
    backstage_UsersDao usersDao;
    public List<Users> queryUsers(){
        return usersDao.queryUsers();
    }
    public Integer updateUsers(Integer state, Integer uid){
        return usersDao.updateUsers(state, uid);
    }
    public int addUsers(String uname, String Pwd, Integer state){
        return usersDao.addUsers(uname, Pwd, state);
    }

}

