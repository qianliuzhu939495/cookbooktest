package com.cookbook.dao;

import com.cookbook.entity.LeavMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LeavlMessageDao {
    @Select("select * from LeavMessage where mid=#{mid}")
    List<LeavMessage> querymessageBymid(Integer mid);
    @Select("select * from LeavMessage where mid=#{mid} and reply is NOT NULL")
    List<LeavMessage> querymessagereplyNonull(Integer mid);
    @Select("select * from LeavMessage where mid=#{mid} and reply is NULL")
    List<LeavMessage> querymessageNull(Integer mid);
}
