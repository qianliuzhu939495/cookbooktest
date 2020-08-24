package com.cookbook.entity;

import java.util.Date;

public class User_menu {
    private Integer uid;
    private Integer Mid;
    private Date SaveTime;

    public User_menu() {
    }

    public User_menu(Integer uid, Integer mid, Date saveTime) {
        this.uid = uid;
        Mid = mid;
        SaveTime = saveTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    public Date getSaveTime() {
        return SaveTime;
    }

    public void setSaveTime(Date saveTime) {
        SaveTime = saveTime;
    }

    @Override
    public String toString() {
        return "User_menu{" +
                "uid=" + uid +
                ", Mid=" + Mid +
                ", SaveTime=" + SaveTime +
                '}';
    }
}
