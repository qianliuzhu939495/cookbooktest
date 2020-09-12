package com.cookbook.dao.backstageDao;

import com.cookbook.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LoginDao {

    //select代表查询
    @Select("SELECT c.cid,c.cname,c.Lognum,c.Pwd,c.state,r.Rid,r.Rname from customer c inner JOIN customer_role cr on c.cid = cr.cid inner join role r on cr.rid = r.rid where Lognum = #{Lognum} and Pwd = #{Pwd}")
    public Customer Login(@Param("Lognum")String Lognum,@Param("Pwd") String Pwd);

    @Select("select * from customer where cid = #{cid}")
    List<Customer> queryByCid(@Param("cid") Integer cid);
    //param用于传递参数，从而可以与SQL中的的字段名相对应,update
    @Update("update customer set Pwd=#{Pwd} where cid = #{cid}")
    public Integer UpdCustomerPwd(@Param("Pwd") String pwd, @Param("cid") Integer cid);
}
