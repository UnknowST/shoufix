package com.daomain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*自定义数据结构 用来保存每一栋楼的维修数据*/
public class Floornums {
    String num;  //序号
    String floor;
     String sum;
    //用来记录每一个维修类型的详细数据
    List<Map<String, String>>  listmap;

    public  Floornums (){

    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public List<Map<String, String>> getListmap() {
        return listmap;
    }

    public void setListmap(List<Map<String, String>> listmap) {
        this.listmap = listmap;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Floornums{" +
                "num='" + num + '\'' +
                ", floor='" + floor + '\'' +
                ", sum='" + sum + '\'' +
                ", listmap=" + listmap +
                '}';
    }
}
