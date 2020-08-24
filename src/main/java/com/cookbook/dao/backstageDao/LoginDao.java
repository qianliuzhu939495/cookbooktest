package com.cookbook.dao.backstageDao;

import com.cookbook.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LoginDao {
    @Select("select * from customer where Lognum = #{Lognum} and Pwd = #{Pwd}")
    public List<Customer> Login(@Param("Lognum")String Lognum,@Param("Pwd") String Pwd);
    @Select("select * from customer")
    List<Customer> queryByCid(@Param("Cid") Integer cid);
    @Update("update customer set Pwd=#{Pwd} where cid = #{cid}")
    public Integer UpdCustomerPwd(@Param("Pwd") String pwd, @Param("cid") Integer cid);
}
