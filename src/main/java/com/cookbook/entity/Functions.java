package com.cookbook.entity;

public class Functions {
    private Integer Fid;
    private String Fname;
    private String URL;
    private Integer flevel;

    public Functions(Integer fid, String fname, String URL, Integer flevel) {
        Fid = fid;
        Fname = fname;
        this.URL = URL;
        this.flevel = flevel;
    }

    public Functions() {
    }

    public Integer getFid() {
        return Fid;
    }

    public void setFid(Integer fid) {
        Fid = fid;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Integer getFlevel() {
        return flevel;
    }

    public void setFlevel(Integer flevel) {
        this.flevel = flevel;
    }

    @Override
    public String toString() {
        return "Functions{" +
                "Fid=" + Fid +
                ", Fname='" + Fname + '\'' +
                ", URL='" + URL + '\'' +
                ", flevel=" + flevel +
                '}';
    }
}
