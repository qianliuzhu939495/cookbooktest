package com.cookbook.entity;

import java.util.Date;
import java.util.List;

public class User_menu {
    private Date SaveTime;
    private List<Menu> menus;
    public User_menu() {
    }

    public User_menu(Integer uid, Integer mid, Date saveTime, List<Menu> menus) {
        SaveTime = saveTime;
        this.menus = menus;
    }


    public Date getSaveTime() {
        return SaveTime;
    }

    public void setSaveTime(Date saveTime) {
        SaveTime = saveTime;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "User_menu{" +
                ", SaveTime=" + SaveTime +
                ", menus=" + menus +
                '}';
    }
}
