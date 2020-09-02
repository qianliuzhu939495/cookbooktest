package com.cookbook.entity;

import java.util.Date;
import java.util.List;

public class User_menu {
    private Integer uid;
    private Date SaveTime;
    private Menu umenus;
    public User_menu() {
    }

    public User_menu(Integer uid, Date saveTime, Menu umenus) {
        this.uid = uid;
        SaveTime = saveTime;
        this.umenus = umenus;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getSaveTime() {
        return SaveTime;
    }

    public void setSaveTime(Date saveTime) {
        SaveTime = saveTime;
    }

    public Menu getUmenus() {
        return umenus;
    }

    public void setUmenus(Menu umenus) {
        this.umenus = umenus;
    }

    @Override
    public String toString() {
        return "User_menu{" +
                "uid=" + uid +
                ", SaveTime=" + SaveTime +
                ", umenus=" + umenus +
                '}';
    }
}
