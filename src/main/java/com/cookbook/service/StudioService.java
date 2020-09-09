package com.cookbook.service;

import com.cookbook.dao.StudioDao;
import com.cookbook.dao.UserDao;
import com.cookbook.entity.Studio;
import com.cookbook.entity.StudioDetails;
import com.cookbook.entity.Studio_message;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudioService {
    @Resource
    StudioDao studioDao;
    @Resource
    UserDao userDao;
    public Studio saveStudio(Studio studio){
        studioDao.saveStudio(studio);
        return studioDao.queryByPic(studio.getStupic());
    }
    public List<Studio_message> queryMyStudioMessage(String uid){
        List<Studio_message> studio_messages = studioDao.queryMyStudioMessage(uid);
        for(Studio_message s:studio_messages){
            s.setLeveluser(userDao.querybyid(Integer.valueOf(s.getUid())));
        }
        return studio_messages;
    }
    public List<Studio> querynewStudio(){
        return studioDao.querynewStudio();
    }
}
