package com.cookbook.dao;

import com.cookbook.entity.Works_message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Works_messageDao {
    @Select("select * from Works_message where Wid=#{param1} and upid=#{param2}")
    List<Works_message> querybywid(Integer Wid, Integer upid);
    @Insert("insert into Works_message(Wid,Message,upid,uid,State,MessageTime) values(#{Wid},#{Message},#{upid},#{uid},0,now())")
    int add(Works_message wm);
    @Delete("delete from Works_message where wmid=#{wmid}")
    int delBywmid(Integer wmid);
    @Delete("delete from Works_message where upid=#{wmid}")
    int delByupid(Integer wmid);
    @Update("update Works_message set state=1 where wmid=#{wmid}")
    int updateworkstate(String wmid);
    @Delete("delete from Works_message where wid=#{wid}")
    int deleteByWid(String wid);
}
