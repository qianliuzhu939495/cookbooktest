package com.cookbook.controller.backstage;

import com.cookbook.entity.Users;
import com.cookbook.service.backstage.backstage_UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("backstage_users")
public class backstage_UsersController {
    @Resource
    backstage_UsersService usersService;
    @RequestMapping("queryUsers")
    @ResponseBody
    public List<Users> queryUsers(){
        return usersService.queryUsers();
    }
    @RequestMapping("updateUsers")
    @ResponseBody()
    public Integer updateUsers(Integer state, Integer uid){
        System.out.println(state);
        return usersService.updateUsers(state, uid);
    }
    @ResponseBody
    @RequestMapping("addUsers")
    public int addUsers(String uname, String Pwd , Integer state){
        return usersService.addUsers(uname, Pwd, state);
    }
}
