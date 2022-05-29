package com.daomain;

public class Worker_num {
   private String workerid;
   private Integer num,tm;

    public String getWorkerid() {
        return workerid;
    }

    public void setWorkerid(String userid) {
        this.workerid = userid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getTm() {
        return tm;
    }

    public void setTm(Integer tm) {
        this.tm = tm;
    }

    @Override
    public String toString() {
        return "Worker_num{" +
                "userid='" + workerid + '\'' +
                ", num=" + num +
                ", tm=" + tm +
                '}';
    }
}
