package com.cookbook.entity;

import java.util.List;

/*菜谱分类*/
public class MenuTypes {
    private Integer Mtid;
    private String Mtname;
    private Integer mLevel;
    private List<MenuTypes> menutypess;
private List<Menu> menus;

    public List<MenuTypes> getMenutypess() {
        return menutypess;
    }

    public void setMenutypess(List<MenuTypes> menutypess) {
        this.menutypess = menutypess;
    }

    public MenuTypes(Integer mtid, String mtname, Integer mLevel, List<MenuTypes> menutypess, List<Menu> menus) {
        Mtid = mtid;
        Mtname = mtname;
        this.mLevel = mLevel;
        this.menutypess = menutypess;
        this.menus = menus;
    }

    public MenuTypes() {
    }

    public Integer getMtid() {
        return Mtid;
    }

    public void setMtid(Integer mtid) {
        Mtid = mtid;
    }

    public String getMtname() {
        return Mtname;
    }

    public void setMtname(String mtname) {
        Mtname = mtname;
    }

    public Integer getmLevel() {
        return mLevel;
    }

    public void setmLevel(Integer mLevel) {
        this.mLevel = mLevel;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "MenuTypes{" +
                "Mtid=" + Mtid +
                ", Mtname='" + Mtname + '\'' +
                ", mLevel=" + mLevel +
                ", menus=" + menus +
                '}';
    }
}
