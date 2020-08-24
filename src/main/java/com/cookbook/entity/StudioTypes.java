package com.cookbook.entity;

import java.util.List;

public class StudioTypes {
    private Integer Stid;
    private String Stname;
    private Integer sLevel;
    private List<Studio> studios;

    public StudioTypes(Integer stid, String stname, Integer sLevel, List<Studio> studios) {
        Stid = stid;
        Stname = stname;
        this.sLevel = sLevel;
        this.studios = studios;
    }

    public StudioTypes() {
    }

    public Integer getStid() {
        return Stid;
    }

    public void setStid(Integer stid) {
        Stid = stid;
    }

    public String getStname() {
        return Stname;
    }

    public void setStname(String stname) {
        Stname = stname;
    }

    public Integer getsLevel() {
        return sLevel;
    }

    public void setsLevel(Integer sLevel) {
        this.sLevel = sLevel;
    }

    public List<Studio> getStudios() {
        return studios;
    }

    public void setStudios(List<Studio> studios) {
        this.studios = studios;
    }

    @Override
    public String toString() {
        return "StudioTypes{" +
                "Stid=" + Stid +
                ", Stname='" + Stname + '\'' +
                ", sLevel=" + sLevel +
                ", studios=" + studios +
                '}';
    }
}
