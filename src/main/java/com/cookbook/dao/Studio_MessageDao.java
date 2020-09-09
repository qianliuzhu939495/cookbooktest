package com.cookbook.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Studio_MessageDao {
    @Select("SELECT ROUND(AVG(Start),2) from studio_message where sid=#{sid}")
    Integer queryAvg(Integer sid);
}
