package com.cookbook.dao;

import com.cookbook.entity.StudioTypes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface StudioTypeDao {
    @Select("select * from StudioTypes where sLevel=#{slevel}")
    List<StudioTypes> querybyslevel(Integer slevel);
}
