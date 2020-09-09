package com.cookbook.dao.backstageDao;

import com.cookbook.entity.MenuTypes;
import com.cookbook.entity.StudioTypes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BackRadioTypeDao {
    @Select("select * from studiotypes")//显示所有
    List<StudioTypes> queryStudioType();
    @Select("select * from studiotypes where Stid = #{Stid}")
    List<StudioTypes> queryStudioTypeTwo(@Param("Stid") Integer sLevel);//
    @Select("select * from studiotypes where sLevel = 0")
    List<StudioTypes> queryStudioOne();//查询所有一级菜谱
    @Select("select * from studiotypes where sLevel = #{sLevel}")
    List<StudioTypes> queryStudioTwo(@Param("sLevel") Integer stid);//根据一级菜谱查询所有二级菜谱
    @Insert("insert into studiotypes(Stname,sLevel) values(#{Stname},#{sLevel})")
    int insertStudioTypesTwo(@Param("Stname")String Stname,@Param("sLevel")Integer sLevel);//添加菜谱
    @Update("update studiotypes set sLevel = #{sLevel},Stname = #{Stname} where Stid = #{Stid}")//修改菜谱所属父级
    int updateStudioTypesTwo(@Param("sLevel")Integer sLevel,@Param("Stname")String stname,@Param("Stid")Integer Stid);
}
