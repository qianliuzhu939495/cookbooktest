package com.cookbook.entity;

import java.util.List;

public class Customer {
    private Integer cid;
    private String Cname;
    private String Lognum;
    private String pwd;
    private Integer state;
    private List<Functions> functions;
    private List<Role> roles;

    public Customer(Integer cid, String cname, String lognum, String pwd, Integer state, List<Functions> functions, List<Role> roles) {
        this.cid = cid;
        Cname = cname;
        Lognum = lognum;
        this.pwd = pwd;
        this.state = state;
        this.functions = functions;
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", Cname='" + Cname + '\'' +
                ", Lognum='" + Lognum + '\'' +
                ", pwd='" + pwd + '\'' +
                ", state=" + state +
                ", functions=" + functions +
                ", roles=" + roles +
                '}';
    }

    public List<Functions> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Functions> functions) {
        this.functions = functions;
    }

    public Customer() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getLognum() {
        return Lognum;
    }

    public void setLognum(String lognum) {
        Lognum = lognum;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
