package com.cookbook.entity;

import java.util.Date;
import java.util.List;

public class Menu {
    private Integer Mid;
    private String Mname;
    private String Pic;
    private String Info;
    private Integer Mtid;
    private Integer State;
    private Integer uid;
    private Date MadeTime;
    private List<MenuStep> menuSteps; // 步骤
    private List<MaterialsDetail> materialsDetails; // 用料
    private List<Works> works; //翻拍的作品
    private  List<LeavMessage> leavMessages;
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Menu() {
    }

    public Menu(Integer mid, String mname, String pic, String info, Integer mtid, Integer state, Integer uid, Date madeTime, List<MenuStep> menuSteps, List<MaterialsDetail> materialsDetails, List<Works> works, List<LeavMessage> leavMessages,Users users) {
        Mid = mid;
        Mname = mname;
        Pic = pic;
        Info = info;
        Mtid = mtid;
        State = state;
        this.uid = uid;
        MadeTime = madeTime;
        this.menuSteps = menuSteps;
        this.materialsDetails = materialsDetails;
        this.works = works;
        this.leavMessages = leavMessages;
        this.users=users;
    }

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public Integer getMtid() {
        return Mtid;
    }

    public void setMtid(Integer mtid) {
        Mtid = mtid;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getMadeTime() {
        return MadeTime;
    }

    public void setMadeTime(Date madeTime) {
        MadeTime = madeTime;
    }

    public List<MenuStep> getMenuSteps() {
        return menuSteps;
    }

    public void setMenuSteps(List<MenuStep> menuSteps) {
        this.menuSteps = menuSteps;
    }

    public List<MaterialsDetail> getMaterialsDetails() {
        return materialsDetails;
    }

    public void setMaterialsDetails(List<MaterialsDetail> materialsDetails) {
        this.materialsDetails = materialsDetails;
    }

    public List<Works> getWorks() {
        return works;
    }

    public void setWorks(List<Works> works) {
        this.works = works;
    }

    public List<LeavMessage> getLeavMessages() {
        return leavMessages;
    }

    public void setLeavMessages(List<LeavMessage> leavMessages) {
        this.leavMessages = leavMessages;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "Mid=" + Mid +
                ", Mname='" + Mname + '\'' +
                ", Pic='" + Pic + '\'' +
                ", Info='" + Info + '\'' +
                ", Mtid=" + Mtid +
                ", State=" + State +
                ", uid=" + uid +
                ", MadeTime=" + MadeTime +
                ", menuSteps=" + menuSteps +
                ", materialsDetails=" + materialsDetails +
                ", works=" + works +
                ", leavMessages=" + leavMessages +
                ", user=" + users +
                '}';
    }
}
