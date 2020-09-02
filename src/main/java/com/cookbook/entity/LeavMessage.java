package com.cookbook.entity;

import java.util.Date;
import java.util.List;

public class LeavMessage {
    private Integer lid;
    private String Info;
    private Integer uid;
    private Integer Mid;
    private Integer State;
    private Date LeaveTime;
    private Users LeavUsers;
    private String reply;// -- 作者回复
    private Date replytime;// 回复时间

    public LeavMessage() {
    }


    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
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

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    public Date getLeaveTime() {
        return LeaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        LeaveTime = leaveTime;
    }

    public Users getLeavUsers() {
        return LeavUsers;
    }

    public void setLeavUsers(Users leavUsers) {
        LeavUsers = leavUsers;
    }

    public LeavMessage(Integer lid, String info, Integer uid, Integer mid, Integer state, Date leaveTime, Users leavUsers, String reply, Date replytime) {
        this.lid = lid;
        Info = info;
        this.uid = uid;
        Mid = mid;
        State = state;
        LeaveTime = leaveTime;
        LeavUsers = leavUsers;
        this.reply = reply;
        this.replytime = replytime;
    }

    @Override
    public String toString() {
        return "LeavMessage{" +
                "lid=" + lid +
                ", Info='" + Info + '\'' +
                ", uid=" + uid +
                ", Mid=" + Mid +
                ", State=" + State +
                ", LeaveTime=" + LeaveTime +
                ", LeavUsers=" + LeavUsers +
                ", reply='" + reply + '\'' +
                ", replytime=" + replytime +
                '}';
    }
}
