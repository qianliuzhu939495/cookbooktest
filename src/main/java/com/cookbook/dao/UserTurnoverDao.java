package com.cookbook.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserTurnoverDao {
    @Select("SELECT count(*) from UserTurnover where wid=#{sid}")
    public int querycountBysid(Integer sid);
}
