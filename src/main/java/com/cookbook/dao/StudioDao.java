package com.cookbook.dao;

import com.cookbook.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudioDao {
    @Select("select s.* from user_studio us left join studio s on us.sid=s.sid where us.uid=#{uid} ORDER BY us.savetime desc")
    List<Studio> queryusercollectedstudio(Integer uid);
    @Select("select * from studiotypes where sLevel=0")
    List<StudioTypes> queryTypes();

    @Select("select * from studiotypes where sLevel=#{sLevel}")
        List<StudioTypes> queryChildrenTypes(String sLevel);

    @Insert("insert into studio(sname,money,stid,uid,stupic,info,uptime) values(#{sname},#{money},#{stid},#{uid},#{stupic},#{info},NOW())")
    Integer saveStudio(Studio studio);
    @Insert("INSERT into tudiodetails(sinfo,surl,state,sid) values(#{sinfo},#{surl},#{state},#{sid})")
    Integer saveStudioDetail(StudioDetails studioDetails);

    @Select("select * from studio where stupic=#{stupic}")
    Studio queryByPic(String stupic);

    @Select("select * from studio_message where sid=#{sid}")
    List<Studio_message> qeuerymessageBysid(Integer sid);

    //查询已购买和已发布
    @Select("select s.* from UserTurnover ut left join studio s on ut.wid=s.Sid where ut.uid=#{uid} and pay > 0 ")
    List<Studio> queryByPayUid(String uid);
    @Select("select * from studio where uid=#{uid} ")
    List<Studio> queryMyStudio(String uid);
    @Select("select * from studio where sid=#{sid} ")
    Studio queryByid(String sid);
    @Select("select * from tudiodetails where sid=#{sid} ")
    List<StudioDetails> queryDetailByid(String sid);
    @Select("select * from studiotypes where stid=#{stid}")
    StudioTypes queryTypeByid(String stid);
    //查询购买过，销量
    @Select("select utid from  userturnover where wid=#{sid}")
    List<String> querystudiosales(String stid);
    //查询人购买该视频没
    @Select("select * from userturnover where uid=#{param1} and wid=#{param2}")
    UserTurnover queryPaysByid(String uid,String wid);
    //查询我的所有视频的所有未读评论
    @Select("select sm.* from studio_message sm inner join studio s on sm.sid=s.sid where s.uid=#{uid} and sm.state=0")
    public List<Studio_message> queryMyStudioMessage(String uid);
    @Update("update studio_message set state=1 where smid=#{smid}")
    int updatemessageBysmid(String smid);

    @Select("SELECT * FROM Studio ORDER BY UpTime desc LIMIT 9")
    public List<Studio> querynewStudio();
    @Select("SELECT *,(SELECT ROUND(AVG(sm.Start),2) from studio_message sm where sm.sid=s.sid) pingjun from studio s ORDER BY pingjun desc LIMIT 9")
    public List<Studio> queryOrderBystart();

    @Select("select count(uid) from user_studio where uid=#{param1} and sid=#{param2}")
    int queryLikeStudio(String uid,String sid);
    @Delete("delete from user_studio where uid=#{param1} and sid=#{param2}")
    int deleteLikeStudio(String uid,String sid);
    @Insert("insert into user_studio values(#{param1},#{param2},0)")
    int saveLikeStudio(String uid,String sid);
    @Select("select * FROM Studio")
    List<Studio> queryall();
    @Select("select * FROM Studio where stid=#{stid}")
    List<Studio> queryByStid(Integer stid);
}
