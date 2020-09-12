package com.cookbook.controller;

import com.cookbook.dao.UserDao;
import com.cookbook.dao.WorksDao;
import com.cookbook.entity.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import com.cookbook.service.WorksService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("WorksController")
public class WorksController {
    @Resource
    WorksDao worksDao;
    @Resource
    WorksService worksService;
    @RequestMapping("saveWorks")
    public Integer saveWorks(@RequestBody Works works) {
        return worksDao.saveWorks(works);
    }
    @RequestMapping("querybymid")
    public List<Works> querybymid(Integer mid){
        return worksService.querybymid(mid);
    }
    @RequestMapping("queryOrderBytime")
    public List<Works> queryOrderBytime(Integer mid){
        return worksService.queryOrderBytime(mid);
    }
    @RequestMapping("queryMyWorksMessage")
    public List<Works_message> queryMyWorksMessage(String uid){
        return  worksService.queryMyWorksMessage(uid);
    }
    @RequestMapping("queryByWid")
    public Works queryByWid(Integer wid){
        return worksService.queryByWid(wid);
    }
    @RequestMapping("querybyuid")
    public List<Works> querybyuid(String uid){
        return worksDao.querybyuid(Integer.valueOf(uid));
    }
    @RequestMapping("queryAllBymid")
    public List<Works> queryAllBymid(String mid){

        return worksDao.querybymid(Integer.valueOf(mid));
    }

    @RequestMapping("queryStateBywid")
    public List<Users> queryStateBywid(String wid){
        return worksDao.querystartBywid(Integer.parseInt(wid));
    }

    @RequestMapping("queryLikes")
    public Integer queryLikes(String wid,String uid){

        return worksDao.queryUserlikework(wid,uid);
    }

    @RequestMapping("updateLike")
    public Integer updateLike(String wid,String uid){
        try {
            int i = worksDao.queryUserlikework(wid, uid);
            if(i>0){
                worksDao.deletelikework(wid,uid);
                return 0;
            }else{
                worksDao.saveLikeWork(wid,uid);
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    @RequestMapping("queryGuanzhuWorks")
    public List<Works> queryGuanzhuWorks(Integer uid){
        return worksService.queryGuanzhuWorks(uid);
    }
    @RequestMapping("queryAllWorks")
    public List<Works> queryAllWorks(){
        return worksService.queryAllWorks();
    }

    @RequestMapping("updateWorks")
    public int updateWorks(@RequestBody Works works){
        return worksDao.updateWorks(works);
    }

    @RequestMapping("deleteWorks")
    public int deleteWorks(String wid){
        return worksService.deleteWorks(wid);
    }
    @Resource
    UserDao userDao;
    @RequestMapping("queryMyWorksByid")
    public List<Menu> queryMyWorksByid(String uid){
        List<Menu> menus1 = userDao.queryLikemenu(Integer.parseInt(uid));
        return menus1;
    }
}
