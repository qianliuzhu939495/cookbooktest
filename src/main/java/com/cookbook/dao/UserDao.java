package com.cookbook.dao;

import com.cookbook.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from users where phone=#{param1} and pwd=#{param2}")
    Users queryByPwd(String phone,String pwd);
    @Select("select * from users where phone=#{phone}")
    Users queryByMsg(String phone);
    @Insert("insert into users(uname,pwd,phone,createTime) values('default','12345',#{phone},now())")
    Integer sasveone(String phone);
    @Insert("insert into users(uname,pwd,phone,createTime) values('default',#{param1},#{param2},now())")
    Integer sasveoneRe(String pwd,String phone);
    @Select("select * from users")
    List<Users> queryAll();
    @Select("select * from users where uid=#{uid}")
    Users querybyid(Integer uid);
    //查询关注人
    @Select("select u.* from User_User uu LEFT JOIN users u on u.uid=uu.followuid where uu.uid=#{uid}")
    List<Users> queryguanzhu(Integer uid);
}
