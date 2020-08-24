package com.cookbook.entity;

public class Customer {
    private Integer cid;
    private String Cname;
    private String Lognum;
    private String pwd;

    public Customer() {
    }

    public Customer(Integer cid, String cname, String lognum, String pwd) {
        this.cid = cid;
        Cname = cname;
        Lognum = lognum;
        this.pwd = pwd;
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

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", Cname='" + Cname + '\'' +
                ", Lognum='" + Lognum + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
