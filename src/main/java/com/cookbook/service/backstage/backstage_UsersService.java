package com.cookbook.service.backstage;

import com.cookbook.dao.backstageDao.backstage_UsersDao;
import com.cookbook.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service//自动注册到Spring容器
public class backstage_UsersService {
    @Resource //属于J2EE的 默认按照名称进行装配，名称可以通过name属性进行指定，减少了与spring的耦合
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

