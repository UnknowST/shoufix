package com.service;

import com.daomain.Equipment;
import com.daomain.Infor;

import java.util.List;

public interface WechatAppservice {
    /*提交报修单*/
    int submitinfor(Infor infor);
    /*获取装备表的数据*/
    List<Equipment> equipmentlist();
}
