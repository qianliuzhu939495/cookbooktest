package com.cookbook.controller;

import com.cookbook.dao.StudioDao;
import com.cookbook.dao.UserDao;
import com.cookbook.entity.Studio;
import com.cookbook.entity.StudioTypes;
import com.cookbook.entity.Studio_message;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("StudioContorller")
public class StudioContorller {
    @Resource
    StudioDao studioDao;
    @Resource
    UserDao userDao;
    @RequestMapping("queryTypes")
    public List<StudioTypes> queryTypes(){
        return studioDao.queryTypes();
    }
    @RequestMapping("queryChildrenTypes")
    public List<StudioTypes> queryChildrenTypes(String slevel){
        List<StudioTypes> st=null;
        try {
            st = studioDao.queryChildrenTypes(slevel);
        }catch (Exception e){
            e.printStackTrace();
        }
        return st;
    }
    @RequestMapping("queryusercollectedstudio")
    public List<Studio> queryByUid(String uid){
        List<Studio> stu = studioDao.queryusercollectedstudio(Integer.valueOf(uid));
        for(Studio s:stu){
            List<Studio_message> studio_messages = studioDao.qeuerymessageBysid(s.getSid());
            s.setStudio_messages(studio_messages);
        }
        return stu;
    }
    @RequestMapping("queryByPayUid")
    public List<Studio> queryByPayUid(String uid){
        System.out.println(uid);
        List<Studio> studios = studioDao.queryByPayUid(uid);
        for(Studio s:studios){
            s.setStudio_messages(studioDao.qeuerymessageBysid(s.getSid()));
        }
        System.out.println(studios);
        return studios;
    }
    @RequestMapping("queryMyStudio")
    public List<Studio> queryMyStudio(String uid){
        List<Studio> studios = studioDao.queryMyStudio(uid);
        for(Studio s:studios){
            s.setStudio_messages(studioDao.qeuerymessageBysid(s.getSid()));
        }
        System.out.println(studios);
        return studios;
    }
    @RequestMapping("querydetail")
    public Studio querydetail(String sid){
        Studio stu = studioDao.queryByid(sid);
        stu.setStudioDetails(studioDao.queryDetailByid(sid));
        List<Studio_message> studio_messages = studioDao.qeuerymessageBysid(Integer.parseInt(sid));
        for(Studio_message sm:studio_messages){
            sm.setLeveluser(userDao.querybyid(sm.getUid()));
        }
        stu.setStudio_messages(studio_messages);
        return stu;
    }
    @RequestMapping("queryTypeByid")
    public StudioTypes queryTypeByid(String stid){
        StudioTypes studioTypes = studioDao.queryTypeByid(stid);
        System.out.println(stid+studioTypes);
        return studioTypes;
    }
    @RequestMapping("querystudiosales")
    public String querystudiosales(String sid){
        return String.valueOf(studioDao.querystudiosales(sid).size());
    }
}
