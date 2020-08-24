package com.cookbook.entity;

import java.util.Date;

public class Studio_message {
    private Integer smid;
    private Integer sid;
    private String Message;
    private Integer Start;
    private Integer uid;
    private Integer State;
    private Date evaluateTime;

    public Studio_message(Integer smid, Integer sid, String message, Integer start, Integer uid, Integer state, Date evaluateTime) {
        this.smid = smid;
        this.sid = sid;
        Message = message;
        Start = start;
        this.uid = uid;
        State = state;
        this.evaluateTime = evaluateTime;
    }

    public Studio_message() {
    }

    public Integer getSmid() {
        return smid;
    }

    public void setSmid(Integer smid) {
        this.smid = smid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Integer getStart() {
        return Start;
    }

    public void setStart(Integer start) {
        Start = start;
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

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    @Override
    public String toString() {
        return "Studio_message{" +
                "smid=" + smid +
                ", sid=" + sid +
                ", Message='" + Message + '\'' +
                ", Start=" + Start +
                ", uid=" + uid +
                ", State=" + State +
                ", evaluateTime=" + evaluateTime +
                '}';
    }
}
