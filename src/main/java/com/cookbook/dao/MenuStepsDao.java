package com.cookbook.dao;

import com.cookbook.entity.MenuStep;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuStepsDao extends tk.mybatis.mapper.common.Mapper<MenuStep> {
    @Select("select * from MenuStep where mid=#{mid}")
    List<MenuStep> queryBymid(Integer mid);
    @Insert("insert into MenuStep(msinfo,msnum,mspic,mid) values(#{msinfo},#{msnum},#{mspic},#{mid})")
    void savemenustep(MenuStep menuStep);
}
