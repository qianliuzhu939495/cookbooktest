package com.cookbook.dao.backstageDao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BackOrderDetailDao {
    @Select("select ut.utid,ut.Pay,ut.Income,ut.MadeTime,\n" +
            "(select u.uname from users u where ut.uid = u.uid)'uname',\n" +
            "(select s.Sname from studio s where s.sid = ut.Wid)'sname'\n" +
            " from userturnover ut inner join user_studio us on ut.uid = us.uid left join studio st on us.sid = st.sid")
    public List<Map<String,Object>> BackOrderDetailQuery();
}
