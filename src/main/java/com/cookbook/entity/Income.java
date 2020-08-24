package com.cookbook.entity;

import java.util.Date;

public class Income {
    private Integer Iid;
    private Integer Sid;
    private double Shares;
    private Date InTime;

    public Income(Integer iid, Integer sid, double shares, Date inTime) {
        Iid = iid;
        Sid = sid;
        Shares = shares;
        InTime = inTime;
    }

    public Income() {
    }

    public Integer getIid() {
        return Iid;
    }

    public void setIid(Integer iid) {
        Iid = iid;
    }

    public Integer getSid() {
        return Sid;
    }

    public void setSid(Integer sid) {
        Sid = sid;
    }

    public double getShares() {
        return Shares;
    }

    public void setShares(double shares) {
        Shares = shares;
    }

    public Date getInTime() {
        return InTime;
    }

    public void setInTime(Date inTime) {
        InTime = inTime;
    }

    @Override
    public String toString() {
        return "Income{" +
                "Iid=" + Iid +
                ", Sid=" + Sid +
                ", Shares=" + Shares +
                ", InTime=" + InTime +
                '}';
    }
}
