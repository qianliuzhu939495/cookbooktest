package com.cookbook.dao.backstageDao;

import com.cookbook.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface backstage_UsersDao {
    @Select("select * from users")
    List<Users> queryUsers();
    @Update("update users set state = #{state} where uid = #{uid}")
    int updateUsers(@Param("state") Integer state, @Param("uid") Integer uid);
    @Insert("insert into users(uname,Pwd,createTime,state) " +
            "values(#{uname},#{Pwd},now(),#{state})")
    int addUsers(@Param("uname") String uname, @Param("Pwd") String Pwd, @Param("state") Integer state);
}
