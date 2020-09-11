package com.cookbook.dao;

import com.cookbook.entity.UserTurnover;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserTurnoverDao {
    @Select("SELECT count(*) from UserTurnover where wid=#{sid}")
    public int querycountBysid(Integer sid);

    @Select("select * from UserTurnover where uid=#{uid} and income!=0 and pay=0")
    List<UserTurnover> queryMyincome(String uid);

    @Select("select * from UserTurnover where uid=#{uid} and pay!=0 and income=0")
    List<UserTurnover> querymypay(String uid);
}
