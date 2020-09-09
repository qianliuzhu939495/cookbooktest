package com.cookbook.dao.backstageDao;


import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BackWorkDao {
    @Select("select *,\n" +
            " (select users.uname from users where users.uid = works.uid)'uname',\n" +
            " (select menu.Mname from menu where menu.Mid = works.Mid)'Mname'\n" +
            " from works\n")
    List<Map<String,Object>>  queryWorks();

    @Select("select l.lid,l.info,l.State,l.LeaveTime,l.replytime,\n" +
            "(select users.uname from users where users.uid = l.uid)'uname',\n" +
            "(select menu.Mname from menu where menu.Mid = l.Mid)'mname'\n" +
            " from leavmessage l")
    List<Map<String,Object>> queryLeaveMessage();
}
