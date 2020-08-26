package com.cookbook.dao;

import com.cookbook.entity.Works;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorksDao {
    @Select("select * from Works where Mid=#{mid}")
    public List<Works> querybymid(Integer mid);
    @Select("select * from Works where uid=#{uid}")
    public List<Works> querybyuid(Integer uid);
}
