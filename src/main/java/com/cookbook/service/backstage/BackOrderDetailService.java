package com.cookbook.service.backstage;

import com.cookbook.dao.backstageDao.BackOrderDetailDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BackOrderDetailService {
    @Resource
    BackOrderDetailDao backOrderDetailDao;
    public List<Map<String,Object>> BackOrderDetailQuery(){
        return backOrderDetailDao.BackOrderDetailQuery();
    }
}

