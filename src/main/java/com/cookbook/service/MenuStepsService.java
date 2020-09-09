package com.cookbook.service;

import com.cookbook.dao.MenuStepsDao;
import com.cookbook.entity.MenuStep;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuStepsService {
    @Resource
    MenuStepsDao menuStepsDao;
    public List<MenuStep> queryBymid(Integer mid){
        return menuStepsDao.queryBymid(mid);
    }
}
