package com.cookbook.controller.backstage;

import com.cookbook.entity.Users;
import com.cookbook.service.backstage.backstage_UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller //用于标记一个类，使用它标记的类就是一个SpringMVC Controller 对象，即一个控制器类
@RequestMapping("backstage_users")
public class backstage_UsersController {
    @Resource //属于J2EE的 默认按照名称进行装配，名称可以通过name属性进行指定，减少了与spring的耦合
            backstage_UsersService usersService;
    @RequestMapping("queryUsers")//RequestMapping 处理请求地址映射 窄化路径
    @ResponseBody//@ResponseBody的作用其实是异步请求时将java对象转为json格式的数据。
    public List<Users> queryUsers(){
        return usersService.queryUsers();
    }
    @RequestMapping("updateUsers")
    @ResponseBody
    public Integer updateUsers(Integer state, Integer uid){
        return usersService.updateUsers(state, uid);
    }
    @ResponseBody
    @RequestMapping("addUsers")
    public int addUsers(String uname, String Pwd , Integer state){
        return usersService.addUsers(uname, Pwd, state);
    }
}
