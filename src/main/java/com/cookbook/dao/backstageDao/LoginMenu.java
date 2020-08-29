package com.cookbook.dao.backstageDao;

import com.cookbook.entity.Functions;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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

    @Select("select functions.flevel'parentMenu',functions.Fid 'parentFid',functions.fname 'parentName',functions.URL 'parentUrl',functions.flevel 'parentFlevel'  from customer inner join customer_role on customer.cid = customer_role.cid \n" +
            "INNER JOIN role on customer_role.Rid = role.Rid left join role_function on role.Rid = role_function.Rid\n" +
            "LEFT JOIN functions on role_function.Fid = functions.Fid where functions.flevel = 0 and customer.cid = #{Cid}")
    List<Map<String,Object>> queryOneMenu(Integer cid);

    @Select("select * from functions where functions.flevel = #{fid}")
    List<Functions> queryTwoMenu(Integer fid);
}
