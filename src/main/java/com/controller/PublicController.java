package com.controller;

import com.daomain.*;
import com.service.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/public")
public class PublicController {
  @Autowired private Adminservice adminservice;
  Message message = new Message();

  /*当前显示的公告栏数据*/
  @RequestMapping("/nownotice")
  @ResponseBody
  public List<Notice> test5() {

    return adminservice.nownotice();
  }

  /*查询所有工种的信息*/
  @RequestMapping("/typelist")
  @ResponseBody
  public List<Worker_type> test2() {
    System.out.println(adminservice.typeList());
    return adminservice.typeList();
  }

  /*插入反馈信息*/
  @RequestMapping("/insertfeedback")
  @ResponseBody
  public Message test3(Feedback feedback) {
    if (adminservice.Insertfeedback(feedback) == 1) {
      message.setFlag(1);
      message.setMessage("反馈成功，请注意后续版本的更新!");
    } else {
      message.setFlag(0);
      message.setMessage("反馈失败，请重试!");
    }
    return message;
  }

  /*查询所有的反馈信息*/
  @RequestMapping("/listfeedback")
  @ResponseBody
  public List<Feedback> test3() {
    return adminservice.listfeedback();
  }
  /*返回普通用户报修次数 数据*/
  @RequestMapping("/user_num")
  @ResponseBody
  public List<Map<Object, Object>> test4(){
     return adminservice.use_num();
  }

  /*返回维修师傅 维修数量和平均时间*/
  @RequestMapping("/w_num")
  @ResponseBody
  public List<Worker_num> test6(){
    return adminservice.w_num();
  }

  /*返回设备每月的平均使用周期*/
  @RequestMapping("/equip_live")
  @ResponseBody
  public List<equip_live> test7(){
    return adminservice.equip_live();
  }
}
