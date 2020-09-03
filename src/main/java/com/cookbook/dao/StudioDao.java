package com.cookbook.dao;

import com.cookbook.entity.Studio;
import com.cookbook.entity.StudioDetails;
import com.cookbook.entity.StudioTypes;
import com.cookbook.entity.Studio_message;
import org.apache.ibatis.annotations.Insert;
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
}
