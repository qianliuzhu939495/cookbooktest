package com.cookbook.dao.backstageDao;

import com.cookbook.entity.MenuTypes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface backmenuTypes {
    @Select("select * from menutypes")//显示所有
    List<MenuTypes> queryMenuType();
    @Select("select * from menutypes where Mtid = #{Mtid}")
    List<MenuTypes> queryMenuTypeTwo(@Param("Mtid") Integer mLevel);//
    @Select("select * from menutypes where mLevel = 0")
    List<MenuTypes> queryMenuOne();//查询所有一级菜谱
    @Select("select * from menutypes where mLevel = #{mLevel}")
    List<MenuTypes> queryMenuTwo(@Param("mLevel") Integer mtid);//根据一级菜谱查询所有二级菜谱
    @Insert("insert into menutypes(Mtname,mLevel) values(#{Mtname},#{mLevel})")
    int insertMenuTypesTwo(@Param("Mtname")String Mtname,@Param("mLevel")Integer mLevel);//添加菜谱
    @Update("update menutypes set mLevel = #{mLevel},Mtname = #{Mtname} where Mtid = #{Mtid}")//修改菜谱所属父级
    int updateMenuTypesTwo(@Param("mLevel")Integer mLevel,@Param("Mtname")String mtname,@Param("Mtid")Integer Mtid);
}
