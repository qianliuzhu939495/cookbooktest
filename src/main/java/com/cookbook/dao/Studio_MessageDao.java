package com.cookbook.dao;

import com.cookbook.entity.Studio_message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Studio_MessageDao {
    @Select("SELECT ROUND(AVG(Start),2) from studio_message where sid=#{sid}")
    Integer queryAvg(Integer sid);
    @Select("SELECT * from studio_message where sid=#{sid}")
    List<Studio_message> queryBysid(Integer sid);
    @Insert("insert into studio_message(sid,message,start,uid,state,evaluatetime) values(#{sid},#{message},#{start},#{uid},0,now())")
    int add(Studio_message studio_message);
}
