package com.cookbook.dao;

import com.cookbook.entity.Studio;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudioDao {
    @Select("select s.* from user_studio us left join studio s on us.sid=s.sid where us.uid=#{uid} ORDER BY us.savetime desc")
    List<Studio> queryusercollectedstudio(Integer uid);
}
