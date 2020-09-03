package com.cookbook.service;

import com.cookbook.dao.StudioDao;
import com.cookbook.entity.Studio;
import com.cookbook.entity.StudioDetails;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudioService {
    @Resource
    StudioDao studioDao;
    public Studio saveStudio(Studio studio){
        studioDao.saveStudio(studio);
        return studioDao.queryByPic(studio.getStupic());
    }
}
