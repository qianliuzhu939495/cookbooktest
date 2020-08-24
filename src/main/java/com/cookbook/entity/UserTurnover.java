package com.cookbook.entity;

import java.util.Date;

public class UserTurnover {
    private Integer utid;
    private Integer uid;
    private Integer Wid;
    private double Pay;
    private double Income;
    private Date MadeTime;

    public UserTurnover(Integer utid, Integer uid, Integer wid, double pay, double income, Date madeTime) {
        this.utid = utid;
        this.uid = uid;
        Wid = wid;
        Pay = pay;
        Income = income;
        MadeTime = madeTime;
    }

    public Integer getUtid() {
        return utid;
    }

    public void setUtid(Integer utid) {
        this.utid = utid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getWid() {
        return Wid;
    }

    public void setWid(Integer wid) {
        Wid = wid;
    }

    public double getPay() {
        return Pay;
    }

    public void setPay(double pay) {
        Pay = pay;
    }

    public double getIncome() {
        return Income;
    }

    public void setIncome(double income) {
        Income = income;
    }

    public Date getMadeTime() {
        return MadeTime;
    }

    public void setMadeTime(Date madeTime) {
        MadeTime = madeTime;
    }

    @Override
    public String toString() {
        return "UserTurnover{" +
                "utid=" + utid +
                ", uid=" + uid +
                ", Wid=" + Wid +
                ", Pay=" + Pay +
                ", Income=" + Income +
                ", MadeTime=" + MadeTime +
                '}';
    }
}
