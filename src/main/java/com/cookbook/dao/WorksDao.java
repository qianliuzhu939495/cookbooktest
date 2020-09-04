package com.cookbook.dao;

import com.cookbook.entity.Users;
import com.cookbook.entity.Works;
import com.cookbook.entity.Works_message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorksDao {
    @Select("select * from Works where Mid=#{mid}")
    public List<Works> querybymid(Integer mid);
    @Select("select * from Works where uid=#{uid}")
    public List<Works> querybyuid(Integer uid);
    @Select("select * from Works where uid=#{uid} ORDER BY MakeTime DESC")
    public List<Works> querybyuidtwo(Integer uid);
    @Select("select * from Works_message where Wid=#{wid}")
    List<Works_message> queryworksmessage(Integer wid);
    @Select("select u.* from Works_start ws left join users u on ws.uid=u.uid where ws.Wid=#{wid}")
    List<Users> querystartBywid(Integer wid);
    @Select("select * from works where day(MakeTime) BETWEEN day(NOW())-7 and day(NOW()) and mid=#{mid}")
    List<Works> querySevenWork(Integer mid);

    @Select("select *,(select count(*) from Works_start ws left join users u on ws.uid=u.uid where ws.Wid=w.wid\n" +
            ") count from Works w where w.Mid=#{mid} ORDER BY count DESC")
    List<Works> queryBystartcount(Integer mid);
    @Select("select * from Works where mid=#{mid} ORDER BY MakeTime DESC")
    public List<Works> queryOrderBytime(Integer mid);
}
