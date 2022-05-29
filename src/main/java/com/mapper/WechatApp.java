package com.mapper;

import com.daomain.Equipment;
import com.daomain.Infor;

import java.util.List;

public interface WechatApp {
    /*提交报修单*/
    int submitinfor(Infor infor);
    /*为每一个新添加的维修记录创建一个回复表单*/
    int creatreplay(int inforid);
    /*自动分配维修单*/
    int fenpeiinfor(String num,String workerid);
    /*返回要分配的维修师傅账号*/
    String back_workerid();
    /*获取装备表的数据*/
    List<Equipment> equipmentlist();
}
