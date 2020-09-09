package com.cookbook.entity;

public class StudioDetails {
    private Integer sdid;
    private String sinfo;
    private String surl;
    private Integer state;
    private Integer sid;

    public StudioDetails() {
    }

    public StudioDetails(Integer sdid, String sinfo, String surl, Integer state, Integer sid) {
        this.sdid = sdid;
        this.sinfo = sinfo;
        this.surl = surl;
        this.state = state;
        this.sid = sid;
    }

    public Integer getSdid() {
        return sdid;
    }

    public void setSdid(Integer sdid) {
        this.sdid = sdid;
    }

    public String getSinfo() {
        return sinfo;
    }

    public void setSinfo(String sinfo) {
        this.sinfo = sinfo;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "StudioDetails{" +
                "sdid=" + sdid +
                ", sinfo='" + sinfo + '\'' +
                ", surl='" + surl + '\'' +
                ", state=" + state +
                ", sid=" + sid +
                '}';
    }
}
