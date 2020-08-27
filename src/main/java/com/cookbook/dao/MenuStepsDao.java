package com.cookbook.dao;

import com.cookbook.entity.MenuStep;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuStepsDao {
    @Select("select * from MenuStep where mid=#{mid}")
    List<MenuStep> queryBymid(Integer mid);
}
