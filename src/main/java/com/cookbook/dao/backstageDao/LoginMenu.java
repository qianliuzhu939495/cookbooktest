package com.cookbook.dao.backstageDao;

import com.cookbook.entity.Functions;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface LoginMenu {
    @Select("select functions.flevel 'parentMenu', functions.Fid 'parentFid',functions.fname 'parentName',functions.URL 'parentUrl',f.fid,f.Fname,f.url from customer inner join customer_role on customer.cid = customer_role.cid \n" +
            "INNER JOIN role on customer_role.Rid = role.Rid left join role_function on role.Rid = role_function.Rid\n" +
            "LEFT JOIN functions on role_function.Fid = functions.Fid inner join functions f on functions.Fid = f.flevel where customer.cid = #{Cid}")
    @Results(id = "functions",value = {
        @Result(column = "Fid",property = "functions.Fid"),
        @Result(column = "Fname",property = "functions.Fname"),
        @Result(column = "url",property = "functions.URL")
    })
    List<Map<String,Object>> queryLoginMenu(Integer cid);

    @Select("select functions.flevel'parentMenu',functions.Fid 'parentFid',functions.fname 'parentName',functions.URL 'parentUrl',functions.flevel 'parentFlevel',role.Rid from customer inner join customer_role on customer.cid = customer_role.cid \n" +
            "INNER JOIN role on customer_role.Rid = role.Rid left join role_function on role.Rid = role_function.Rid\n" +
            "LEFT JOIN functions on role_function.Fid = functions.Fid where functions.flevel = 0 and customer.cid = #{Cid}")
    List<Map<String,Object>> queryOneMenu(Integer cid);

    @Select("select * from functions f INNER JOIN role_function rf on f.fid = rf.fid inner join role r on rf.rid = r.Rid where r.Rid = #{Rid} and f.flevel = #{flevel}")
    List<Functions> queryTwoMenu(@Param("Rid") Integer rid,@Param("flevel") Integer fid);

    @Select("select functions.Fid 'parentFid',functions.fname 'parentName'from customer inner join customer_role on customer.cid = customer_role.cid \n" +
            "INNER JOIN role on customer_role.Rid = role.Rid left join role_function on role.Rid = role_function.Rid\n" +
            "LEFT JOIN functions on role_function.Fid = functions.Fid  where customer.cid = 1 and functions.flevel = 0")
    List<Map<String,Object>> queryMenuOne();//查询一级菜单

    @Select("select f.fname 'parentName',f.fid 'parentFid' from functions f where f.flevel = #{fid}")
    List<Map<String,Object>> queryMenuTwo(Integer fid);
    @Delete("delete from role_function where Rid = 2")
    int deleteMenuUser();
    @Insert("insert into role_function(Rid,Fid) values(2,#{Fid})")
    int insertMenuUser(Integer Fid);
}
