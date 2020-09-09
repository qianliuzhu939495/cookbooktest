package com.cookbook.dao;

import com.cookbook.entity.Menu;
import com.cookbook.entity.User_studio;
import com.cookbook.entity.Users;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from users where phone=#{param1} and pwd=#{param2}")
    Users queryByPwd(String phone,String pwd);
    @Select("select * from users where phone=#{phone}")
    Users queryByMsg(String phone);
    @Insert("insert into users(uname,pwd,phone,createTime) values(#{param1},'12345',#{param2},now())")
    Integer sasveone(String uname,String phone);
    @Insert("insert into users(uname,pwd,phone,createTime) values(#{param1},#{param2},#{param3},now())")
    Integer sasveoneRe(String uname,String pwd,String phone);
    @Select("SELECT *,(SELECT COUNT(*) from works w where w.uid=u.uid) count from users u ORDER BY count desc")
    List<Users> queryAll();
    @Select("select * from users where uid=#{uid}")
    Users querybyid(Integer uid);
    //查询关注人
    @Select("select u.* from User_User uu LEFT JOIN users u on u.uid=uu.followuid where uu.uid=#{uid}")
    List<Users> queryguanzhu(Integer uid);
    @Select("select u.* from User_User uu LEFT JOIN users u on u.uid=uu.uid where uu.followuid=#{uid}")
    List<Users> querybeiguanzhu(Integer uid);
    //查询用户收藏的菜谱
    @Select("select um.SaveTime,m.* from User_menu um LEFT JOIN menu m on m.mid=um.mid where um.uid=#{uid} order by um.saveTime desc")
    List<Menu> queryLikemenu(Integer uid);
    //查询用户收藏的课程
    @Select("select s.*,us.SaveTime from user_studio us LEFT JOIN studio s on s.Sid=us.Sid where us.uid=#{uid} order by us.saveTime desc")
    List<User_studio> queryLikestudios(Integer uid);
    //模糊查询
    @Select("select * from users where uname like '%${uname}%'")
    List<Users> queryBylikeUname(String uname);
    @Update("update users set pic=#{param1} where uid=#{param2}")
    void updateUserpic(String pic,String uid);
    @Update("update users set uname=#{uname},selfinfo=#{selfinfo},sex=#{sex},birthday=#{birthday} where uid=#{uid}")
    void updateInfo(Users users);
    @Update("update users set pwd=#{param1} where uid=#{param2}")
    Integer msgUpdatePwd(String pwd,String uid);
    @Select("select count(*) from user_user where uid=#{param1} and followuid=#{param2}")
    int queryIsFollow(String uid,String followuid);
    @Delete("delete from user_user where uid=#{param1} and followuid=#{param2}")
    int Isfollows(String uid,String followuid);
    @Insert("insert into user_user values(#{param1},#{param2})")
    int saveIsfollows(String uid,String followuid);

    //成为作家
    @Update("update users set state=1 where uid=#{uid}")
    int updateUserState(String uid);
    @Insert("insert into income(uid,shares,intime) values(#{uid},'2000',NOW())")
    int saveincome(String uid);
}
