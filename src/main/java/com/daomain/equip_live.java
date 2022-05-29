package com.daomain;

public class equip_live {
    //查询出的年 月 设备，数量
    String yer,mon,equip,num;

    public String getYer() {
        return yer;
    }

    public void setYer(String yer) {
        this.yer = yer;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "equip_live{" +
                "yer='" + yer + '\'' +
                ", mon='" + mon + '\'' +
                ", equip='" + equip + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
