package com.cookbook.entity;

import java.util.Date;
import java.util.List;

public class Works_message {
    private Integer Wmid;
    private Integer Wid;
    private String Message;
    private Integer upid;
    private Integer uid;
    private Integer State;
    private Date MessageTime;
    private Users users;
    private List<Works_message> works_messages;

    public Works_message(Integer wmid, Integer wid, String message, Integer upid, Integer uid, Integer state, Date messageTime, Users users, List<Works_message> works_messages) {
        Wmid = wmid;
        Wid = wid;
        Message = message;
        this.upid = upid;
        this.uid = uid;
        State = state;
        MessageTime = messageTime;
        this.users = users;
        this.works_messages = works_messages;
    }

    public Works_message() {
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Works_message> getWorks_messages() {
        return works_messages;
    }

    public void setWorks_messages(List<Works_message> works_messages) {
        this.works_messages = works_messages;
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
                ", users=" + users +
                ", works_messages=" + works_messages +
                '}';
    }
}
