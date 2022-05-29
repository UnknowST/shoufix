package com.controller;

import com.daomain.Equipment;
import com.daomain.Infor;
import com.daomain.Message;
import com.service.WechatAppservice;
import com.service.impl.WechatAppserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("/wechat")
public class WechatAppController {
    @Autowired
   private WechatAppservice wechatAppservice;
    Message message=new Message();
    /*添加记录*/
    @RequestMapping("subinfor")
    @ResponseBody
    public Message test1(Infor infor){
        if(wechatAppservice.submitinfor(infor)==1){
            message.setFlag(1);
            message.setMessage("填写成功");
        }else {
            message.setFlag(0);
            message.setMessage("填写失败，请重试");
        }
        return message;
    }
    @RequestMapping("/equipmentlist")
    @ResponseBody
    public List<Equipment> test2() {
        // 获取quiplent的数据并返回
        List<Equipment> equipmentList = wechatAppservice.equipmentlist();
        return equipmentList;
    }
}
