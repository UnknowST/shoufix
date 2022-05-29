package com.service.impl;

import com.daomain.Equipment;
import com.daomain.Infor;
import com.mapper.WechatApp;
import com.service.WechatAppservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wechatapp")
public class WechatAppserviceImpl  implements WechatAppservice {
    @Autowired
    private WechatApp wechatapp;
    @Override
    public int submitinfor(Infor infor) {
        // 事务控制
        int i = wechatapp.submitinfor(infor);
        int j = wechatapp.creatreplay(infor.getNum());
        /*添加记录成功 接下来就是自动分配给合适的维修师傅*/
        String workerid=wechatapp.back_workerid();
        //进行分配
        int k=wechatapp.fenpeiinfor(String.valueOf(infor.getNum()),workerid);
        if (i == 1 && j == 1 && k==1) return 1;
        else return 0;
    }

    @Override
    public List<Equipment> equipmentlist() {
        return wechatapp.equipmentlist();
    }
}
