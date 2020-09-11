package com.cookbook.dao;

import com.cookbook.entity.Users;
import com.cookbook.entity.Works;
import com.cookbook.entity.Works_message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorksDao {
    @Select("select * from Works where Mid=#{mid}")
    public List<Works> querybymid(Integer mid);
    @Select("select * from Works where uid=#{uid}")
    public List<Works> querybyuid(Integer uid);
    @Select("select * from Works where uid=#{uid} ORDER BY MakeTime DESC")
    public List<Works> querybyuidtwo(Integer uid);
    @Select("select * from Works_message where Wid=#{wid}")
    List<Works_message> queryworksmessage(Integer wid);
    @Select("select u.* from Works_start ws left join users u on ws.uid=u.uid where ws.Wid=#{wid}")
    List<Users> querystartBywid(Integer wid);
    @Select("select * from works where day(MakeTime) BETWEEN day(NOW())-7 and day(NOW()) and mid=#{mid}")
    List<Works> querySevenWork(Integer mid);
    @Insert("insert into works(winfo,pic,mid,uid,maketime) values(#{winfo},#{pic},#{mid},#{uid},NOW())")
    Integer saveWorks(Works works);

    @Select("select *,(select count(*) from Works_start ws left join users u on ws.uid=u.uid where ws.Wid=w.wid\n" +
            ") count from Works w where w.Mid=#{mid} ORDER BY count DESC")
    List<Works> queryBystartcount(Integer mid);
    @Select("select * from Works where mid=#{mid} ORDER BY MakeTime DESC")
    public List<Works> queryOrderBytime(Integer mid);

    //查询我的所有作品的维度评论
    @Select("select * from works_message wm inner join works w on wm.wid=w.wid where w.uid=#{uid} and wm.state=0")
    List<Works_message> queryMyWorksMessage(String uid);
    @Select("select * from Works where wid=#{wid}")
    public Works queryByWid(Integer wid);

    //点赞与取消 查询增删
    @Select("select count(uid) from works_start where wid=#{param1} and uid=#{param2}")
    int queryUserlikework(String wid,String uid);
    @Delete("delete from works_start where wid=#{param1} and uid=#{param2}")
    int deletelikework(String wid,String uid);
    @Insert("insert into works_start values(#{param1},#{param2},0)")
    int saveLikeWork(String wid,String uid);
    @Select("SELECT * from works w LEFT JOIN users u on u.uid=w.uid LEFT JOIN user_user uu on uu.followuid=u.uid WHERE uu.uid=#{uid}")
    List<Works> queryGuanzhuWorks(Integer uid);

    @Update("update works set winfo=#{winfo},pic=#{pic} where wid=#{wid}")
    int updateWorks(Works works);
    @Delete("delete from works where wid=#{wid}")
    int deleteWorks(String wid);
    @Delete("delete from works_start where wid=#{wid}")
    int deleteworkstart(String wid);
}
