package com.cookbook.service.backstage;

import com.cookbook.dao.backstageDao.BackWorkDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BackWorkService {
    @Resource
    BackWorkDao backWorkDao;
    public List<Map<String,Object>>  queryWork(){
        return backWorkDao.queryWorks();
    }
    public List<Map<String,Object>> queryLeaveMessage(){
        return backWorkDao.queryLeaveMessage();
    }
}

