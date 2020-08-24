package com.cookbook.entity;

import java.util.Date;
import java.util.List;

public class Works {
    private Integer Wid;
    private String Winfo;
    private String Pic;
    private Integer Mid;
    private Integer uid;
    private Date MakeTime;
    private List<Works_message> works_messages;
    private List<Users> startUsers; //点赞人
    public Works() {
    }

    public Works(Integer wid, String winfo, String pic, Integer mid, Integer uid, Date makeTime, List<Works_message> works_messages, List<Users> startUsers) {
        Wid = wid;
        Winfo = winfo;
        Pic = pic;
        Mid = mid;
        this.uid = uid;
        MakeTime = makeTime;
        this.works_messages = works_messages;
        this.startUsers = startUsers;
    }

    public Integer getWid() {
        return Wid;
    }

    public void setWid(Integer wid) {
        Wid = wid;
    }

    public String getWinfo() {
        return Winfo;
    }

    public void setWinfo(String winfo) {
        Winfo = winfo;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getMakeTime() {
        return MakeTime;
    }

    public void setMakeTime(Date makeTime) {
        MakeTime = makeTime;
    }

    public List<Works_message> getWorks_messages() {
        return works_messages;
    }

    public void setWorks_messages(List<Works_message> works_messages) {
        this.works_messages = works_messages;
    }

    public List<Users> getStartUsers() {
        return startUsers;
    }

    public void setStartUsers(List<Users> startUsers) {
        this.startUsers = startUsers;
    }

    @Override
    public String toString() {
        return "Works{" +
                "Wid=" + Wid +
                ", Winfo='" + Winfo + '\'' +
                ", Pic='" + Pic + '\'' +
                ", Mid=" + Mid +
                ", uid=" + uid +
                ", MakeTime=" + MakeTime +
                ", works_messages=" + works_messages +
                ", startUsers=" + startUsers +
                '}';
    }
}
