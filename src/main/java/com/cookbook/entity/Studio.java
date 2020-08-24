package com.cookbook.entity;

import sun.dc.pr.PRError;

import java.util.Date;
import java.util.List;

public class Studio {
    private Integer Sid;
    private String Sname;
    private double money;
    private Integer Stid;
    private Integer uid;
    private String stupic;
    private String Info;
    private Date UpTime;
    private List<StudioDetails> studioDetails;
    private List<Studio_message> studio_messages;


    public Studio() {
    }

    public Studio(Integer sid, String sname, double money, Integer stid, Integer uid, String stupic, String info, Date upTime, List<StudioDetails> studioDetails, List<Studio_message> studio_messages) {
        Sid = sid;
        Sname = sname;
        this.money = money;
        Stid = stid;
        this.uid = uid;
        this.stupic = stupic;
        Info = info;
        UpTime = upTime;
        this.studioDetails = studioDetails;
        this.studio_messages = studio_messages;
    }

    public Integer getSid() {
        return Sid;
    }

    public void setSid(Integer sid) {
        Sid = sid;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getStid() {
        return Stid;
    }

    public void setStid(Integer stid) {
        Stid = stid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getStupic() {
        return stupic;
    }

    public void setStupic(String stupic) {
        this.stupic = stupic;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public Date getUpTime() {
        return UpTime;
    }

    public void setUpTime(Date upTime) {
        UpTime = upTime;
    }

    public List<StudioDetails> getStudioDetails() {
        return studioDetails;
    }

    public void setStudioDetails(List<StudioDetails> studioDetails) {
        this.studioDetails = studioDetails;
    }

    public List<Studio_message> getStudio_messages() {
        return studio_messages;
    }

    public void setStudio_messages(List<Studio_message> studio_messages) {
        this.studio_messages = studio_messages;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "Sid=" + Sid +
                ", Sname='" + Sname + '\'' +
                ", money=" + money +
                ", Stid=" + Stid +
                ", uid=" + uid +
                ", stupic='" + stupic + '\'' +
                ", Info='" + Info + '\'' +
                ", UpTime=" + UpTime +
                ", studioDetails=" + studioDetails +
                ", studio_messages=" + studio_messages +
                '}';
    }
}
