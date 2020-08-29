package com.cookbook.entity;

import java.util.List;

public class Functions {
    private Integer Fid;
    private String Fname;
    private String URL;
    private Integer flevel;
    private List<Role> roles;

    public Functions(Integer fid, String fname, String URL, Integer flevel, List<Role> roles) {
        Fid = fid;
        Fname = fname;
        this.URL = URL;
        this.flevel = flevel;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Functions{" +
                "Fid=" + Fid +
                ", Fname='" + Fname + '\'' +
                ", URL='" + URL + '\'' +
                ", flevel=" + flevel +
                ", roles=" + roles +
                '}';
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

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

}
