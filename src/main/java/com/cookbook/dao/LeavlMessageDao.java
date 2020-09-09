package com.cookbook.dao;

import com.cookbook.entity.LeavMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LeavlMessageDao {
    @Select("select * from LeavMessage where mid=#{mid}")
    List<LeavMessage> querymessageBymid(Integer mid);
    @Select("select * from LeavMessage where mid=#{mid} and reply is NOT NULL")
    List<LeavMessage> querymessagereplyNonull(Integer mid);
    @Select("select * from LeavMessage where mid=#{mid} and reply is NULL")
    List<LeavMessage> querymessageNull(Integer mid);
    @Insert("insert into LeavMessage(info,uid,mid,state,leavetime) values(#{info},#{uid},#{mid},0,now())")
    int add(LeavMessage leavMessage);
    @Update("update LeavMessage set state=1,reply=#{reply},replytime=now() where lid=#{lid}")
    int reply(LeavMessage leavMessage);
    @Delete("delete from LeavMessage where lid=#{lid}")
    int delBylid(Integer lid);
    @Update("update LeavMessage set state=1 where lid=#{lid}")
    int updatestate(Integer lid);
}
