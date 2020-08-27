package com.cookbook.dao;

import com.cookbook.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuDao {
    @Select("SELECT *,(select count(*) from Works w where w.Mid=m.Mid) count from menu m where m.state=0 and  m.MadeTime BETWEEN DATE_FORMAT(CURDATE(),'%Y-%m-01 00:00:00') and DATE_FORMAT(LAST_DAY(CURDATE()),'%Y-%m-%d 23:59:59') ORDER BY count DESC LIMIT 6")
    public List<Menu> queryThisMonth();
    @Select("SELECT *,(select count(*) from Works w where w.Mid=m.Mid) count from menu m where m.state=0 and  m.MadeTime BETWEEN DATE_ADD(CURDATE()-DAY(CURDATE())+1,INTERVAL -1 MONTH) and LAST_DAY(DATE_SUB(NOW(),INTERVAL 1 MONTH)) ORDER BY count DESC LIMIT 4")
    public List<Menu> queryupMonth();
    @Select("SELECT * FROM menu where state=0 ORDER BY MadeTime desc LIMIT 9")
    public List<Menu> queryNewMenu();
    @Select("select * from menu where state=0 and uid=#{uid} order by MadeTime desc")
    public List<Menu> querybyuid(Integer uid);
    @Select("SELECT * from(\n" +
            "SELECT *,(select count(*) from works w where w.mid=m.mid and day(w.MakeTime) BETWEEN day(NOW())-7 and day(NOW())) count from menu m ORDER BY count desc limit 999999) as a\n" +
            "where a.state=0 and a.Mtid=#{mtid}")
    List<Menu> querybymtidorderliuxing(Integer mtid);
}
