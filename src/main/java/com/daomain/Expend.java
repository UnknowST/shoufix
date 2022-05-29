package com.daomain;

/*用来保存 设备支出数据*/
public class Expend {
    Integer num;
    String eid,eqname,price;
    Double cost;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEqname() {
        return eqname;
    }

    public void setEqname(String eqname) {
        this.eqname = eqname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "expend{" +
                "num=" + num +
                ", eid='" + eid + '\'' +
                ", eqname='" + eqname + '\'' +
                ", prince='" + price + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
