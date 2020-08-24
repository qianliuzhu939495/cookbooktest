package com.cookbook.entity;

import java.util.Date;

public class Works_message {
    private Integer Wmid;
    private Integer Wid;
    private String Message;
    private Integer upid;
    private Integer uid;
    private Integer State;
    private Date MessageTime;

    public Works_message(Integer wmid, Integer wid, String message, Integer upid, Integer uid, Integer state, Date messageTime) {
        Wmid = wmid;
        Wid = wid;
        Message = message;
        this.upid = upid;
        this.uid = uid;
        State = state;
        MessageTime = messageTime;
    }

    public Works_message() {
    }

    public Integer getWmid() {
        return Wmid;
    }

    public void setWmid(Integer wmid) {
        Wmid = wmid;
    }

    public Integer getWid() {
        return Wid;
    }

    public void setWid(Integer wid) {
        Wid = wid;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Integer getUpid() {
        return upid;
    }

    public void setUpid(Integer upid) {
        this.upid = upid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    public Date getMessageTime() {
        return MessageTime;
    }

    public void setMessageTime(Date messageTime) {
        MessageTime = messageTime;
    }

    @Override
    public String toString() {
        return "Works_message{" +
                "Wmid=" + Wmid +
                ", Wid=" + Wid +
                ", Message='" + Message + '\'' +
                ", upid=" + upid +
                ", uid=" + uid +
                ", State=" + State +
                ", MessageTime=" + MessageTime +
                '}';
    }
}
