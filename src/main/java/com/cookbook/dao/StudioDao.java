package com.cookbook.dao;

import com.cookbook.entity.Studio;
import com.cookbook.entity.StudioTypes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudioDao {
    @Select("select s.* from user_studio us left join studio s on us.sid=s.sid where us.uid=#{uid} ORDER BY us.savetime desc")
    List<Studio> queryusercollectedstudio(Integer uid);
    @Select("select * from studiotypes where sLevel=0")
    List<StudioTypes> queryTypes();

    @Select("select * from studiotypes where sLevel=#{sLevel}")
    List<StudioTypes> queryChildrenTypes(String sLevel);
}
