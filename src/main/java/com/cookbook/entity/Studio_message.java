package com.cookbook.entity;

import java.util.Date;

public class Studio_message {
    private Integer smid;
    private Integer sid;
    private String message;
    private Integer Start;
    private Integer uid;
    private Integer State;
    private Date evaluateTime;
    private Users leveluser;


    public Studio_message() {
    }

    public Studio_message(Integer smid, Integer sid, String message, Integer start, Integer uid, Integer state, Date evaluateTime, Users leveluser) {
        this.smid = smid;
        this.sid = sid;
        this.message = message;
        Start = start;
        this.uid = uid;
        State = state;
        this.evaluateTime = evaluateTime;
        this.leveluser = leveluser;
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
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Users getLeveluser() {
        return leveluser;
    }

    public void setLeveluser(Users leveluser) {
        this.leveluser = leveluser;
    }

    @Override
    public String toString() {
        return "Studio_message{" +
                "smid=" + smid +
                ", sid=" + sid +
                ", message='" + message + '\'' +
                ", Start=" + Start +
                ", uid=" + uid +
                ", State=" + State +
                ", evaluateTime=" + evaluateTime +
                ", leveluser=" + leveluser +
                '}';
    }
}
