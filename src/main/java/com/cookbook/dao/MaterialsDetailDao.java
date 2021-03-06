package com.cookbook.dao;

import com.cookbook.entity.MaterialsDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MaterialsDetailDao {
    @Select("select * from MaterialsDetail where mid=#{mid}")
    List<MaterialsDetail> queryBymid(Integer mid);
    @Insert("insert into MaterialsDetail(Material,Num,mid) values(#{Material},#{Num},#{mid})")
    void savedetail(MaterialsDetail materialsDetail);
}
