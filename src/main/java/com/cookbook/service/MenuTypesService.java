package com.cookbook.service;

import com.cookbook.dao.MenuTypesDao;
import com.cookbook.entity.MenuTypes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MenuTypesService {
    @Resource
    MenuTypesDao menuTypesDao;
    public List<MenuTypes> queryall(){
        List<MenuTypes> menuTypes = menuTypesDao.querybymlevel(0);
        for (MenuTypes menutype:menuTypes){
            List<MenuTypes> menutwo = menuTypesDao.querybymlevel(menutype.getMtid());
            menutype.setMenutypess(menutwo);
        }
        return menuTypes;
    }
}
