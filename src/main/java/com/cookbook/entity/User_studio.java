package com.cookbook.entity;

import java.util.Date;
import java.util.List;

public class User_studio {
    private Date SaveTime;
    private List<Studio> studioList;
    public User_studio() {
    }

    public User_studio(Date saveTime, List<Studio> studioList) {
        SaveTime = saveTime;
        this.studioList = studioList;
    }

    public Date getSaveTime() {
        return SaveTime;
    }

    public void setSaveTime(Date saveTime) {
        SaveTime = saveTime;
    }

    public List<Studio> getStudioList() {
        return studioList;
    }

    public void setStudioList(List<Studio> studioList) {
        this.studioList = studioList;
    }

    @Override
    public String toString() {
        return "User_studio{" +
                "SaveTime=" + SaveTime +
                ", studioList=" + studioList +
                '}';
    }
}
