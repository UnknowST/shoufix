package com.controller;

import com.daomain.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Adminservice;
import com.service.impl.AdminserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired private Adminservice adminservice;
  // private Adminservice  adminservice=new AdminserviceImpl();
  private Message message = new Message();

  /*查询所有的Infor信息记录*/
  @RequestMapping("/allinfor")
  @ResponseBody
  public List<Infor> test1() {
    return adminservice.listOf();
  }

  /*查询所有工人的信息*/
  @RequestMapping("/listworker")
  @ResponseBody
  public List<Worker> test3() {
    return adminservice.listworker();
  }

  /*查询对应工人的正在维修的订单数*/
  @RequestMapping("suminfor")
  @ResponseBody
  public int test5(String workerid) {
    return adminservice.suminfor(workerid);
  }
  /*更新 infor表的分工*/
  @RequestMapping("uiworker")
  @ResponseBody
  public Message test6(String num, String workerid) {
    if (adminservice.uiworker(num, workerid) == 1) {
      message.setFlag(1);
      message.setMessage("分配成功");
    } else {
      message.setFlag(0);
      message.setMessage("分配失败");
    }
    return message;
  }

  /*查询所有的普通用户数据*/
  @RequestMapping("userlist")
  // @ResponseBody
  public ModelAndView test6(Integer p) {
    // 设置分页相关参数   当前页+每页显示的条数
    PageHelper.startPage(p, 10);
    List<User> list = adminservice.userlist();

    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有用户数据记录");
      modelAndView.setViewName("alluser.jsp");
      modelAndView.addObject("message", message);
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<User> pageInfo = new PageInfo<User>(list);
      modelAndView.addObject("userlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.addObject("n", 2);
      modelAndView.setViewName("alluser.jsp");
    }
    return modelAndView;
  }

  @RequestMapping("deleteuser")
  @ResponseBody()
  public Message test8(String num) {
    if (adminservice.deleteuser(num) == 1) {
      message.setFlag(1);
      message.setMessage("删除成功！");
    } else {
      message.setFlag(0);
      message.setMessage("删除失败，请重试！");
    }
    return message;
  }

  @RequestMapping("resetpass")
  @ResponseBody()
  public Message test9(String num) {
    if (adminservice.resetpassword(num) == 1) {
      message.setFlag(1);
      message.setMessage("重置成功！");
    } else {
      message.setFlag(0);
      message.setMessage("重置失败，请重试！");
    }
    return message;
  }

  /*查询所有待分配的报修单*/
  /*现删除了待分配，故应该链接到等待维修界面   */

  /*查询所有待维修的报修单*/
  @RequestMapping("/waitinfor")
  @ResponseBody
  public ModelAndView test11(Integer p) {
    PageHelper.startPage(p, 10);
    List<Infor> list = adminservice.waitinfor();
    for (Infor infor : list) {
      //
      infor.setList();
    }
    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有相关的维修单");
      modelAndView.setViewName("A_seewaitinfor.jsp");
      modelAndView.addObject("message", message);

      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("A_seewaitinfor.jsp");
    }
    return modelAndView;
  }

  /*查询所有正在维修的报修单*/
  @RequestMapping("/inginfor")
  @ResponseBody
  public ModelAndView test12(Integer p) {
    PageHelper.startPage(p, 10);
    List<Infor> list = adminservice.inginfor();
    for (Infor infor : list) {
      //
      infor.setList();
    }
    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有相关的维修单");
      modelAndView.setViewName("A_seeinginfor.jsp");
      modelAndView.addObject("message", message);

      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("A_seeinginfor.jsp");
    }
    return modelAndView;
  }

  /*查询所有已维修的报修单*/
  @RequestMapping("/succinfor")
  @ResponseBody
  public ModelAndView test13(Integer p) {
    PageHelper.startPage(p, 10);
    List<Infor> list = adminservice.succinfor();
    for (Infor infor : list) {

      infor.setList();
    }
    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有相关的维修单");
      modelAndView.setViewName("A_succinfor.jsp");
      modelAndView.addObject("message", message);

      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("A_succinfor.jsp");
    }
    return modelAndView;
  }

  /*查询所有已维修的报修单*/
  @RequestMapping("/searchuser")
  @ResponseBody
  public ModelAndView test14(User user, Integer p) {
    PageHelper.startPage(p, 10);
    List<User> list = adminservice.searchuser(user);

    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("没有找到符合条件的对象");
      modelAndView.setViewName("alluser.jsp");
      modelAndView.addObject("message", message);
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<User> pageInfo = new PageInfo<User>(list);
      modelAndView.addObject("userlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.addObject("n", 1);
      modelAndView.addObject("user", user);
      modelAndView.setViewName("alluser.jsp");
    }
    return modelAndView;
  }

  /*查询所有已维修的报销单记录*/
  @RequestMapping("/billlist")
  @ResponseBody
  public ModelAndView test15(Integer p) {
    PageHelper.startPage(p, 10);
    List<Bill> list = adminservice.billlist();
    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有报销单记录");
      modelAndView.setViewName("A_seebill.jsp");
      modelAndView.addObject("message", message);
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Bill> pageInfo = new PageInfo<Bill>(list);
      modelAndView.addObject("billlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.addObject("n", 1);
      modelAndView.setViewName("A_seebill.jsp");
    }
    return modelAndView;
  }

  /*按条件搜索bill录*/
  @RequestMapping("/searchbills")
  @ResponseBody
  public ModelAndView test23(Bill bill, Integer p) {
    PageHelper.startPage(p, 10);
    List<Bill> list = adminservice.searchbill(bill);
    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有符合条件的记录");
      modelAndView.setViewName("A_seebill.jsp");
      modelAndView.addObject("message", message);
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Bill> pageInfo = new PageInfo<Bill>(list);
      modelAndView.addObject("billlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("bill", bill);
      modelAndView.addObject("message", message);
      modelAndView.addObject("n", 2);
      modelAndView.setViewName("A_seebill.jsp");
    }
    return modelAndView;
  }

  /*查询所有已维修的报销单记录*/
  @RequestMapping("/deletebill")
  @ResponseBody
  public Message test16(String snum) {

    int i = 0;
    try {
      i = adminservice.deletebill(snum);
    } catch (Exception e) {
      i = -1;
    }

    if (i == 1) {
      message.setFlag(1);
      message.setMessage("删除成功！");

    } else {
      message.setFlag(0);
      message.setMessage("删除失败，请重试！");
    }
    return message;
  }

  /*查询所有已维修的报销单记录*/
  @RequestMapping("/updatebill")
  @ResponseBody
  public Message test16(Bill bill) {

    int i = 0;
    try {
      i = adminservice.updatebill(bill);
    } catch (Exception e) {
      i = -1;
    }

    if (i == 1) {
      message.setFlag(1);
      message.setMessage("修改成功！");

    } else {
      message.setFlag(0);
      message.setMessage("修改失败，请重试！");
    }
    return message;
  }
  /*查询所有已维修的报销单记录*/
  @RequestMapping("/insertuser")
  @ResponseBody
  public Message test17(String userid, String password, String sf) {
    /*普通用户*/
    if ("1".equals(sf)) {
      User user = new User();
      user.setUserid(userid);
      user.setPassword(password);
      int i = 0;
      try {
        i = adminservice.InsertUser(user);
      } catch (Exception e) {
        i = -1;
      }
      if (i == 1) {
        message.setFlag(1);
        message.setMessage("添加成功！");

      } else {
        message.setFlag(0);
        message.setMessage("添加失败，请重试！");
      }
    }
    /*维修工人*/
    if ("2".equals(sf)) {
      Worker worker = new Worker();
      worker.setUserid(userid);
      worker.setPassword(password);
      int m = 0;
      try {
        m = adminservice.InsertWorker(worker);
      } catch (Exception e) {
        m = -1;
      }
      if (m == 1) {
        message.setFlag(1);
        message.setMessage("添加成功！");

      } else {
        message.setFlag(0);
        message.setMessage("添加失败，请重试！");
      }
    }

    return message;
  }

  /*查询所有的工人信息 并返回前端*/
  @RequestMapping("/listworkers")
  @ResponseBody
  public ModelAndView test18(Integer p) {
    PageHelper.startPage(p, 10);
    List<Worker> list = adminservice.listworker();
    List<Worker_type> list1 = adminservice.typeList();
    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前还没有工人数据");
      modelAndView.setViewName("A_listworker.jsp");
      modelAndView.addObject("message", message);
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Worker> pageInfo = new PageInfo<Worker>(list);
      modelAndView.addObject("workerlist", list);
      modelAndView.addObject("type", list1);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.addObject("n", 1);
      modelAndView.setViewName("A_listworker.jsp");
    }
    return modelAndView;
  }
  /*查询所有已维修的报销单记录*/
  @RequestMapping("/deleteworker")
  @ResponseBody
  public Message test19(String num) {

    int i = 0;
    try {
      i = adminservice.deleteworker(num);
    } catch (Exception e) {
      i = -1;
    }
    if (i == 1) {
      message.setFlag(1);
      message.setMessage("删除成功！");

    } else {
      message.setFlag(0);
      message.setMessage("删除失败，请重试！");
    }
    return message;
  }

  /*查询所有已维修的报销单记录*/
  @RequestMapping("/resetworker")
  @ResponseBody
  public Message test20(String num) {

    int i = 0;
    try {
      i = adminservice.resetworker(num);
    } catch (Exception e) {
      i = -1;
    }
    if (i == 1) {
      message.setFlag(1);
      message.setMessage("重置成功！");

    } else {
      message.setFlag(0);
      message.setMessage("重置失败，请重试！");
    }
    return message;
  }
  /*管理员更新维修师傅的信息*/
  @RequestMapping("/updateworker")
  @ResponseBody
  public Message test21(Worker worker) {

    int i = 0;
    try {
      i = adminservice.updateworker(worker);
    } catch (Exception e) {
      i = -1;
    }
    if (i == 1) {
      message.setFlag(1);
      message.setMessage("修改成功！");

    } else {
      message.setFlag(0);
      message.setMessage("修改失败，请重试！");
    }
    return message;
  }

  /*按条件搜索维修师傅数据*/
  @RequestMapping("/searchworkers")
  @ResponseBody
  public ModelAndView test22(Worker worker, Integer p) {
    PageHelper.startPage(p, 10);
    List<Worker> list = adminservice.searchworkers(worker);
    List<Worker_type> list1 = adminservice.typeList();
    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("没有找到符合条件的维修师傅信息");
      modelAndView.setViewName("A_listworker.jsp");
      modelAndView.addObject("message", message);
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Worker> pageInfo = new PageInfo<Worker>(list);
      modelAndView.addObject("workerlist", list);
      modelAndView.addObject("type", list1);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.addObject("n", 2);
      modelAndView.addObject("worker", worker);
      modelAndView.setViewName("A_listworker.jsp");
    }
    return modelAndView;
  }
  /*按条件搜索维修师傅数据*/
  @RequestMapping("/backinfor")
  @ResponseBody
  public Message test23(String num, String ad_replay) {
    if (" ".equals(ad_replay) || ad_replay == null) {
      message.setFlag(0);
      message.setMessage("请填写退回原因！");
      return message;
    }
    int i = adminservice.backinfor(num, ad_replay);
    if (i == 1) {
      message.setFlag(1);
      message.setMessage("退回成功！");
    } else {
      message.setFlag(0);
      message.setMessage("退回失败，请重试！");
    }
    return message;
  }

  /*查看维修失败的记录*/
  @RequestMapping("/failinfor")
  @ResponseBody
  public ModelAndView test24(Integer p) {
    PageHelper.startPage(p, 10);
    List<Infor> list = adminservice.failinfor();
    for (Infor infor : list) {
      infor.setList();
    }
    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有相关的维修记录");
      modelAndView.setViewName("A_abnormal.jsp");
      modelAndView.addObject("message", message);
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);

      modelAndView.setViewName("A_abnormal.jsp");
    }
    return modelAndView;
  }

  /*查看维修失败的记录*/
  @RequestMapping("/a_backinfor")
  @ResponseBody
  public ModelAndView test25(Integer p) {
    PageHelper.startPage(p, 10);
    List<Infor> list = adminservice.A_backinfor();
    for (Infor infor : list) {
      infor.setList();
    }
    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有相关的维修记录");
      modelAndView.setViewName("A_backinfor.jsp");
      modelAndView.addObject("message", message);
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);

      modelAndView.setViewName("A_backinfor.jsp");
    }
    return modelAndView;
  }

  /*查看维修失败的记录*/
  @RequestMapping("/revoke")
  @ResponseBody
  public Message test26(String num) {
    int i = 0;
    try {
      i = adminservice.revoke(num);
    } catch (Exception e) {
      i = -1;
    }
    if (i == 1) {
      message.setMessage("撤回成功!");
      message.setFlag(1);
    } else {
      message.setFlag(0);
      message.setMessage("操作失败，请重试!");
    }
    return message;
  }
  /*查看设备表*/
  @RequestMapping("/equipmentlist")
  @ResponseBody
  public ModelAndView test26(Integer p) {
    PageHelper.startPage(p, 10);
    List<Equipment> list = adminservice.equipmentlist();
    // 获取最大的编号
    int maxeid = adminservice.maxeid();
    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("设备表为空");
      modelAndView.setViewName("A_mequipment.jsp");
      modelAndView.addObject("message", message);
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Equipment> pageInfo = new PageInfo<Equipment>(list);
      modelAndView.addObject("equipmentlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.addObject("maxeid", maxeid + 1);
      modelAndView.setViewName("A_mequipment.jsp");
    }
    return modelAndView;
  }
  /*设备入库*/
  @RequestMapping("/addequip")
  @ResponseBody
  public Message test27(String snum, String num) {
    if (adminservice.addequip(snum, num) == 1) {
      message.setFlag(1);
      message.setMessage("入库成功!");
    } else {
      message.setFlag(0);
      message.setMessage("入库失败，请重试！");
    }
    return message;
  }
  /*设备出库*/
  @RequestMapping("/subequip")
  @ResponseBody
  public Message test28(String snum, String num) {
    if (adminservice.subequip(snum, num) == 1) {
      message.setFlag(1);
      message.setMessage("出库成功!");
    } else {
      message.setFlag(0);
      message.setMessage("出库失败，请重试！");
    }
    return message;
  }

  /*删除设备*/
  @RequestMapping("/deleteequipment")
  @ResponseBody
  public Message test29(String snum) {
    if (adminservice.deleteequipment(snum) == 1) {
      message.setFlag(1);
      message.setMessage("删除成功!");
    } else {
      message.setFlag(0);
      message.setMessage("删除失败，请重试！");
    }
    return message;
  }
  /*添加设备*/
  @RequestMapping("/insertequipment")
  @ResponseBody
  public Message test30(Equipment equipment) {
    if (adminservice.insertequipment(equipment) == 1) {
      message.setFlag(1);
      message.setMessage("添加成功!");
    } else {
      message.setFlag(0);
      message.setMessage("添加失败，请重试！");
    }
    return message;
  }
  /*修改设备信息*/
  @RequestMapping("/updateequipment")
  @ResponseBody
  public Message test31(Equipment equipment) {
    if (adminservice.updateequipment(equipment) == 1) {
      message.setFlag(1);
      message.setMessage("修改成功!");
    } else {
      message.setFlag(0);
      message.setMessage("修改失败，请重试！");
    }
    return message;
  }

  /*查看公告栏*/
  @RequestMapping("/noticelist")
  @ResponseBody
  public ModelAndView test31(Integer p) {
    PageHelper.startPage(p, 10);
    List<Notice> list = adminservice.noticelist();

    ModelAndView modelAndView = new ModelAndView();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有公告记录");
      modelAndView.setViewName("A_notice.jsp");
      modelAndView.addObject("message", message);
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Notice> pageInfo = new PageInfo<Notice>(list);
      modelAndView.addObject("noticelist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("A_notice.jsp");
    }
    return modelAndView;
  }

  /*修改公告*/
  @RequestMapping("/updatenotice")
  @ResponseBody
  public Message test32(Notice notice) {

    if (adminservice.updatenotice(notice) == 1) {
      message.setFlag(1);
      message.setMessage("修改成功!");
    } else {
      message.setFlag(0);
      message.setMessage("修改失败，请重试！");
    }
    return message;
  }

  /*删除公告记录*/
  @RequestMapping("/deletenotice")
  @ResponseBody
  public Message test33(String num) {
    if (adminservice.deletenotice(num) == 1) {
      message.setFlag(1);
      message.setMessage("删除成功!");
    } else {
      message.setFlag(0);
      message.setMessage("删除失败，请重试！");
    }
    return message;
  }
  /*添加公告记录*/
  @RequestMapping("/insertnotice")
  @ResponseBody
  public Message test34(Notice notice) {
    System.out.println(notice);
    if (adminservice.insertnotice(notice) == 1) {
      message.setFlag(1);
      message.setMessage("添加成功!");
    } else {
      message.setFlag(0);
      message.setMessage("添加失败，请重试！");
    }
    return message;
  }

  /*查询各个楼的报修数据*/
  @RequestMapping(value = "backnums")
  @ResponseBody
  public List<Floornums> test35(){

    return adminservice.floosnums();
  }
  /*查询各个设备的报修数据*/
  @RequestMapping(value = "backequipnums")
  @ResponseBody
  public List<Map<String, String>> test36(){

    return adminservice.equipnums();
  }
  /*查询各个设备支出数据*/
  @RequestMapping(value = "backexpend")
  @ResponseBody
  public List<Expend> test37(){

    return adminservice.equip_expend();
  }
  /*返回师傅评分排行*/
  @RequestMapping(value = "workerrank")
  @ResponseBody
  public List<Worker> test38(){

    return adminservice.eval_rank();
  }



}
