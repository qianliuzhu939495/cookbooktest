package com.cookbook.entity;

public class StudioDetails {
    private Integer Sdid;
    private String sInfo;
    private String sUrl;
    private Integer State;
    private Integer Sid;

    public StudioDetails(Integer sdid, String sInfo, String sUrl, Integer state, Integer sid) {
        Sdid = sdid;
        this.sInfo = sInfo;
        this.sUrl = sUrl;
        State = state;
        Sid = sid;
    }

    public StudioDetails() {
    }

    public Integer getSdid() {
        return Sdid;
    }

    public void setSdid(Integer sdid) {
        Sdid = sdid;
    }

    public String getsInfo() {
        return sInfo;
    }

    public void setsInfo(String sInfo) {
        this.sInfo = sInfo;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    public Integer getSid() {
        return Sid;
    }

    public void setSid(Integer sid) {
        Sid = sid;
    }

    @Override
    public String toString() {
        return "StudioDetails{" +
                "Sdid=" + Sdid +
                ", sInfo='" + sInfo + '\'' +
                ", sUrl='" + sUrl + '\'' +
                ", State=" + State +
                ", Sid=" + Sid +
                '}';
    }
}
