package com.cookbook.entity;

import org.omg.CORBA.INTERNAL;

public class MenuStep {
    private Integer Msid;
    private String msinfo;
    private Integer Msnum;
    private String MsPic;
    private Integer Mid;

    public MenuStep(Integer msid, String msinfo, Integer msnum, String msPic, Integer mid) {
        Msid = msid;
        this.msinfo = msinfo;
        Msnum = msnum;
        MsPic = msPic;
        Mid = mid;
    }

    public MenuStep() {
    }

    public Integer getMsid() {
        return Msid;
    }

    public void setMsid(Integer msid) {
        Msid = msid;
    }

    public String getMsinfo() {
        return msinfo;
    }

    public void setMsinfo(String msinfo) {
        this.msinfo = msinfo;
    }

    public Integer getMsnum() {
        return Msnum;
    }

    public void setMsnum(Integer msnum) {
        Msnum = msnum;
    }

    public String getMsPic() {
        return MsPic;
    }

    public void setMsPic(String msPic) {
        MsPic = msPic;
    }

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    @Override
    public String toString() {
        return "MenuStep{" +
                "Msid=" + Msid +
                ", msinfo='" + msinfo + '\'' +
                ", Msnum=" + Msnum +
                ", MsPic='" + MsPic + '\'' +
                ", Mid=" + Mid +
                '}';
    }
}