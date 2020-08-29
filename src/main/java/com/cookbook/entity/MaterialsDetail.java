package com.cookbook.entity;

public class MaterialsDetail {
    private Integer Mdid;
    private String Material;
    private String Num;
    private Integer Mid;

    public MaterialsDetail(Integer mdid, String material, String num, Integer mid) {
        Mdid = mdid;
        Material = material;
        Num = num;
        Mid = mid;
    }

    public MaterialsDetail() {
    }

    public Integer getMdid() {
        return Mdid;
    }

    public void setMdid(Integer mdid) {
        Mdid = mdid;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    @Override
    public String toString() {
        return "MaterialsDetail{" +
                "Mdid=" + Mdid +
                ", Material='" + Material + '\'' +
                ", Num=" + Num +
                ", Mid=" + Mid +
                '}';
    }
}
