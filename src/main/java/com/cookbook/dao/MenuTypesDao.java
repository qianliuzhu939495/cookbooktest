package com.cookbook.dao;

import com.cookbook.entity.MenuTypes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuTypesDao {
    @Select("select * from menutypes where mlevel=#{mlevel}")
    public List<MenuTypes> querybymlevel(Integer mlevel);
    @Select("select * from menutypes where mtid=#{mtid}")
    public MenuTypes querybymtid(Integer mtid);
}
