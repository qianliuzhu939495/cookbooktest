package com.cookbook.dao.backstageDao;


import com.cookbook.entity.Functions;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface backmenuDao {
    @Select("select * from functions")
    List<Functions> queryFunction();
    @Update("update functions set Fname=#{Fname} where Fid = #{Fid}")
    int updateFunctions(@Param("Fname") String Fname, @Param("Fid") Integer Fid);
    @Select("select c.*,role.rname from customer c inner join customer_role on c.cid = customer_role.cid INNER JOIN role on customer_role.Rid = role.Rid")
    @Results(id = "roles",value = {
            @Result(column = "Rname",property = "roles.Rname"),
    })
    List<Map<String,Object>> queryCustomer();
    @Update("update customer set state=#{state} where cid = #{cid}")
    int updateCustomer(@Param("state") Integer state, @Param("cid") Integer cid);
    @Update("update customer set Pwd=#{Pwd} where cid = #{cid}")
    int updateCustomerPwd(@Param("Pwd") String Pwd, @Param("cid") Integer cid);
    @Insert("insert into customer(cname,Lognum,Pwd,state) values(#{cname},#{Lognum},#{Pwd},#{state})")
    int insertCustomer(@Param("cname") String cname, @Param("Lognum") String Lognum, @Param("Pwd") String Pwd, @Param("state") Integer state);
    @Select("select max(cid) cid from customer")
    int cid();
    @Insert("insert into customer_role(cid,rid) values(#{cid},#{Rid})")
    int  insertCustomer_role(@Param("cid") Integer cid, @Param("Rid") Integer Rid);
}
