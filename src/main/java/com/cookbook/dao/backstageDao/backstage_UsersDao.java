package com.cookbook.dao.backstageDao;

import com.cookbook.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
//接口
public interface backstage_UsersDao {
    //sql注解
    @Select("select * from users")//查询所有的用户
    public List<Users> queryUsers();
    //#{}占位符
    @Update("update users set state = #{state} where uid = #{uid}")
    int updateUsers(@Param("state") Integer state, @Param("uid") Integer uid);
    //当参数多个时 要使用@Param  不使用@Param注解时，参数只能有一个
    //@Param注解的作用是给参数命名
    @Insert("insert into users(uname,Pwd,createTime,state) values(#{uname},#{Pwd},now(),#{state})")
    int addUsers(@Param("uname") String uname, @Param("Pwd") String Pwd, @Param("state") Integer state);
}
