package com.cookbook.entity;

import java.util.List;

public class Role {
    private Integer Rid;
    private String Rname;
    private List<Functions> functions;

    public Role() {
    }

    public Role(Integer rid, String rname, List<Functions> functions) {
        Rid = rid;
        Rname = rname;
        this.functions = functions;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }

    public String getRname() {
        return Rname;
    }

    public void setRname(String rname) {
        Rname = rname;
    }

    public List<Functions> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Functions> functions) {
        this.functions = functions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "Rid=" + Rid +
                ", Rname='" + Rname + '\'' +
                ", functions=" + functions +
                '}';
    }
}
