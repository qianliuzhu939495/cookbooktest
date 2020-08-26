package com.cookbook.dao;

import com.cookbook.entity.Studio;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudioOrder {
    // 查询购买课程订单
    @Select("select s.* from UserTurnover ut left join studio s on ut.wid=s.Sid where ut.uid=#{uid} and pay != null ")
    List<Studio> queryBypay(Integer uid);

    // 查询购买课程订单
    @Select("select s.* from UserTurnover ut left join studio s on ut.wid=s.Sid where ut.uid=#{uid} and income != null ")
    List<Studio> queryByincome(Integer uid);
}
