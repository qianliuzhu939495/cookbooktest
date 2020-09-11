package com.cookbook.dao.backstageDao;

import com.cookbook.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LoginDao {
    @Select("SELECT c.cid,c.cname,c.Lognum,c.Pwd,c.state,r.Rid,r.Rname from customer c inner JOIN customer_role cr on c.cid = cr.cid inner join role r on cr.rid = r.rid where Lognum = #{Lognum} and Pwd = #{Pwd}")
    Customer Login(@Param("Lognum") String Lognum, @Param("Pwd") String Pwd);
    @Select("select * from customer where cid = #{cid}")
    List<Customer> queryByCid(@Param("cid") Integer cid);
    @Update("update customer set Pwd=#{Pwd} where cid = #{cid}")
    Integer UpdCustomerPwd(@Param("Pwd") String pwd, @Param("cid") Integer cid);
}
