package com.cookbook.entity;

import java.util.Date;
import java.util.List;

public class Users {
    private Integer uid;
    private String access_token;
    private String uname;
    private String Pwd;
    private String Phone;
    private String Pic;
    private String selfinfo;
    private Integer Sex;
    private Date Birthday;
    private Date createTime;
    private Integer state;
    private List<Menu> munus;//创建的菜谱
    private List<Works> works;
    private  List<User_menu> user_menus; //用户收藏菜单
    private List<User_studio> user_studios; // 收藏课程
    private List<Users>  users; //关注的人
    private List<Users>  follows; //被关注的人
    private List<Studio> mystudio; //我发布的课程
    private List<Studio> paystudio; //我购买的课程
    public Users() {
    }
    public Users(Integer uid, String access_token, String uname, String pwd, String phone, String pic, String selfinfo, Integer sex, Date birthday, Date createTime, Integer state, List<Menu> munus, List<Works> works, List<User_menu> user_menus, List<User_studio> user_studios, List<Users> users, List<Users> follows, List<Studio> mystudio, List<Studio> paystudio) {
        this.uid = uid;
        this.access_token = access_token;
        this.uname = uname;
        Pwd = pwd;
        Phone = phone;
        Pic = pic;
        this.selfinfo = selfinfo;
        Sex = sex;
        Birthday = birthday;
        this.createTime = createTime;
        this.state = state;
        this.munus = munus;
        this.works = works;
        this.user_menus = user_menus;
        this.user_studios = user_studios;
        this.users = users;
        this.follows = follows;
        this.mystudio = mystudio;
        this.paystudio = paystudio;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }

    public String getSelfinfo() {
        return selfinfo;
    }

    public void setSelfinfo(String selfinfo) {
        this.selfinfo = selfinfo;
    }

    public Integer getSex() {
        return Sex;
    }

    public void setSex(Integer sex) {
        Sex = sex;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Menu> getMunus() {
        return munus;
    }

    public void setMunus(List<Menu> munus) {
        this.munus = munus;
    }

    public List<Works> getWorks() {
        return works;
    }

    public void setWorks(List<Works> works) {
        this.works = works;
    }

    public List<User_menu> getUser_menus() {
        return user_menus;
    }

    public void setUser_menus(List<User_menu> user_menus) {
        this.user_menus = user_menus;
    }

    public List<User_studio> getUser_studios() {
        return user_studios;
    }

    public void setUser_studios(List<User_studio> user_studios) {
        this.user_studios = user_studios;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public List<Users> getFollows() {
        return follows;
    }

    public void setFollows(List<Users> follows) {
        this.follows = follows;
    }

    public List<Studio> getMystudio() {
        return mystudio;
    }

    public void setMystudio(List<Studio> mystudio) {
        this.mystudio = mystudio;
    }

    public List<Studio> getPaystudio() {
        return paystudio;
    }

    public void setPaystudio(List<Studio> paystudio) {
        this.paystudio = paystudio;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", access_token='" + access_token + '\'' +
                ", uname='" + uname + '\'' +
                ", Pwd='" + Pwd + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Pic='" + Pic + '\'' +
                ", selfinfo='" + selfinfo + '\'' +
                ", Sex=" + Sex +
                ", Birthday=" + Birthday +
                ", createTime=" + createTime +
                ", state=" + state +
                ", munus=" + munus +
                ", works=" + works +
                ", user_menus=" + user_menus +
                ", user_studios=" + user_studios +
                ", users=" + users +
                ", follows=" + follows +
                ", mystudio=" + mystudio +
                ", paystudio=" + paystudio +
                '}';
    }
}
