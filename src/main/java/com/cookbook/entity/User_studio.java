package com.cookbook.entity;

import java.util.Date;

public class User_studio {
    private Integer uid;
    private Integer Sid;
    private Date SaveTime;

    public User_studio() {
    }

    public User_studio(Integer uid, Integer sid, Date saveTime) {
        this.uid = uid;
        Sid = sid;
        SaveTime = saveTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return Sid;
    }

    public void setSid(Integer sid) {
        Sid = sid;
    }

    public Date getSaveTime() {
        return SaveTime;
    }

    public void setSaveTime(Date saveTime) {
        SaveTime = saveTime;
    }

    @Override
    public String toString() {
        return "User_studio{" +
                "uid=" + uid +
                ", Sid=" + Sid +
                ", SaveTime=" + SaveTime +
                '}';
    }
}
