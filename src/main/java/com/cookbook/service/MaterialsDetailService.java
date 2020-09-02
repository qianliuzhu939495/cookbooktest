package com.cookbook.service;

import com.cookbook.dao.MaterialsDetailDao;
import com.cookbook.entity.MaterialsDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterialsDetailService {
    @Resource
    MaterialsDetailDao materialsDetailDao;
    public List<MaterialsDetail> queryBymid(Integer mid){
        return materialsDetailDao.queryBymid(mid);
    }
}
