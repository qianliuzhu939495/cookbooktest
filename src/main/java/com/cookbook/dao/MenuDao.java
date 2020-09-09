package com.cookbook.dao;

import com.cookbook.entity.MaterialsDetail;
import com.cookbook.entity.Menu;
import com.cookbook.entity.MenuStep;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuDao extends tk.mybatis.mapper.common.Mapper<Menu> {
    @Select("SELECT *,(select count(*) from Works w where w.Mid=m.Mid) count from menu m where m.state=0 and  m.MadeTime BETWEEN DATE_FORMAT(CURDATE(),'%Y-%m-01 00:00:00') and DATE_FORMAT(LAST_DAY(CURDATE()),'%Y-%m-%d 23:59:59') ORDER BY count DESC LIMIT 6")
    public List<Menu> queryThisMonth();
    @Select("SELECT *,(select count(*) from Works w where w.Mid=m.Mid) count from menu m where m.state=0 and  m.MadeTime BETWEEN DATE_ADD(CURDATE()-DAY(CURDATE())+1,INTERVAL -1 MONTH) and LAST_DAY(DATE_SUB(NOW(),INTERVAL 1 MONTH)) ORDER BY count DESC LIMIT 4")
    public List<Menu> queryupMonth();
    @Select("SELECT * FROM menu where state=0 ORDER BY MadeTime desc LIMIT 9")
    public List<Menu> queryNewMenu();
    @Select("select * from menu where uid=#{uid} order by MadeTime desc")
    public List<Menu> querybyuid(Integer uid);
    @Select("SELECT * from(\n" +
            "SELECT *,(select count(*) from works w where w.mid=m.mid and day(w.MakeTime) BETWEEN day(NOW())-7 and day(NOW())) count from menu m ORDER BY count desc limit 999999) as a\n" +
            "where a.state=0 and a.Mtid=#{mtid}")
    List<Menu> querybymtidorderliuxing(Integer mtid);
    @Select("select m.* from user_menu um left join menu m on um.mid=m.mid where um.uid=#{uid} order by um.savetime desc")
    List<Menu> queryusercollectedmenu(Integer uid);
    @Insert("INSERT into menu(mname,pic,info,mtid,state,uid,madeTime) values(#{mname},#{pic},#{info},#{mtid},#{state},#{uid},NOW())")
    void savemenu(Menu menu);

    @Select("SELECT * from(\n" +
            "SELECT *,(select count(*) from Works w where w.Mid=m.Mid) count from menu m ORDER BY count DESC limit 999999) as a\n" +
            "where a.state=0 and a.Mtid=#{mtid}")
    List<Menu> querybymtidorderShouhuanying(Integer mtid);

    @Select("SELECT * FROM menu where state=0 ORDER BY MadeTime")
    public List<Menu> queryAllMenu();

    @Select("SELECT * FROM menu where state=0 and Mname LIKE '%${mname}%'")
    public List<Menu> queryBymname(@Param("mname") String mname);
    @Select("select * from menu where pic=#{pic}")
    Menu querybypic(String pic);

    @Select("select * from menu where mid=#{mid}")
    Menu querybymid(Integer mid);
    @Select("select * from menu where state=0 and uid=#{uid} order by MadeTime desc")
    public List<Menu> queryThreieMenus(Integer uid);


    //修改菜谱和菜谱详情和步骤
    @Update("update menu set mname=#{mname},pic=#{pic},info=#{info},mtid=#{mtid},state=#{state} where mid=#{mid}")
    int updatemenuBymid(Menu menu);
    @Update("update menustep set msinfo=#{msinfo},msnum=#{msnum},mspic=#{mspic} where msid=#{msid}")
    int updatemenustep(MenuStep menuStep);
    @Update("update materialsdetail set material=#{material},num=#{num} where mdid=#{mdid}")
    int updatematerialsdetail(MaterialsDetail materialsDetail);

    //删除菜谱和菜谱详情和步骤和留言
    @Delete("delete from menu where mid=#{mid}")
    int deletemenuBymid(String mid);
    @Delete("delete from menustep where mid=#{mid}")
    int deletemenustep(String mid);
    @Delete("delete from materialsdetail  where mid=#{mid}")
    int deletematerialsdetail(String mid);
    @Delete("delete from leavmessage  where mid=#{mid}")
    int deleteMessage(String mid);
}
