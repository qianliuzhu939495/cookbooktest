package com.cookbook.service;

import com.cookbook.dao.StudioTypeDao;
import com.cookbook.entity.StudioTypes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudioTypeService {
    @Resource
    StudioTypeDao studioTypeDao;
    public List<StudioTypes> queryall(){
        List<StudioTypes> studioTypes = studioTypeDao.querybyslevel(0);
        for (StudioTypes st:studioTypes){
            List<StudioTypes> level = studioTypeDao.querybyslevel(st.getStid());
            st.setStudioTypes(level);
        }
        return studioTypes;
    }
}
