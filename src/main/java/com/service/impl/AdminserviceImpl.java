package com.service.impl;

import com.daomain.*;
import com.mapper.Adminmapper;
import com.service.Adminservice;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("adminservice")
public class AdminserviceImpl implements Adminservice {
  @Autowired private Adminmapper adminmapper;

  @Override
  public List<Infor> listOf() {
    return adminmapper.listOf();
  }

  @Override
  public List<Worker> listworker() {
    return adminmapper.listworker();
  }

  @Override
  public List<Worker_type> typeList() {
    return adminmapper.typeList();
  }

  @Override
  public List<Infor> daiinfor() {
    return adminmapper.daiinfor();
  }

  @Override
  public List<Infor> waitinfor() {
    return adminmapper.waitinfor();
  }

  @Override
  public List<Infor> inginfor() {
    return adminmapper.inginfor();
  }

  @Override
  public List<Infor> succinfor() {
    return adminmapper.succinfor();
  }

  @Override
  public int suminfor(String workerid) {
    return adminmapper.suminfor(workerid);
  }

  @Override
  public int uiworker(String num, String workerid) {
    int i = 0;
    try {
      i = adminmapper.uiworker(num, workerid);
    } catch (Exception e) {
      i = -1;
    }
    if (i == 1) return 1;
    else return 0;
  }

  @Override
  public List<User> userlist() {
    return adminmapper.userlist();
  }

  @Override
  public int deleteuser(String num) {
    return adminmapper.deleteuser(num);
  }

  @Override
  public int resetpassword(String num) {
    return adminmapper.resetpassword(num);
  }

  @Override
  public List<User> searchuser(User user) {
    return adminmapper.searchuser(user);
  }

  @Override
  public List<Bill> billlist() {
    return adminmapper.billlist();
  }

  @Override
  public int deletebill(String snum) {
    return adminmapper.deletebill(snum);
  }

  @Override
  public int updatebill(Bill bill) {
    return adminmapper.updatebill(bill);
  }

  @Override
  public int InsertUser(User user) {
    return adminmapper.InsertUser(user);
  }

  @Override
  public int InsertWorker(Worker worker) {
    return adminmapper.InsertWorker(worker);
  }

  @Override
  public int deleteworker(String num) {
    return adminmapper.deleteworker(num);
  }

  @Override
  public int resetworker(String num) {
    return adminmapper.resetworker(num);
  }

  @Override
  public int updateworker(Worker worker) {
    return adminmapper.updateworker(worker);
  }

  @Override
  public List<Worker> searchworkers(Worker worker) {
    return adminmapper.searchworkers(worker);
  }

  @Override
  public List<Bill> searchbill(Bill bill) {
    return adminmapper.searchbill(bill);
  }

  @Override
  public int backinfor(String num, String ad_replay) {

    int i = 0;
    try {
      i = adminmapper.backinfor(num, ad_replay);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public List<Infor> failinfor() {
    return adminmapper.failinfor();
  }

  @Override
  public List<Infor> A_backinfor() {
    return adminmapper.A_backinfor();
  }

  @Override
  public int revoke(String num) {
    return adminmapper.revoke(num);
  }

  @Override
  public List<Equipment> equipmentlist() {
    return adminmapper.equipmentlist();
  }

  @Override
  public int subequip(String snum, String num) {
    int i = 0;
    try {
      i = adminmapper.subequip(snum, num);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public int addequip(String snum, String num) {
    int i = 0;
    try {
      i = adminmapper.addequip(snum, num);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public int deleteequipment(String snum) {
    int i = 0;
    try {
      i = adminmapper.deleteequipment(snum);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public int insertequipment(Equipment equipment) {
    int i = 0;
    try {
      i = adminmapper.insertequipment(equipment);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public int updateequipment(Equipment equipment) {
    int i = 0;
    try {
      i = adminmapper.updateequipment(equipment);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public int maxeid() {
    return adminmapper.maxeid();
  }

  @Override
  public List<Notice> noticelist() {
    return adminmapper.noticelist();
  }

  @Override
  public int updatenotice(Notice notice) {
    int i = 0;
    try {
      i = adminmapper.updatenotice(notice);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public int deletenotice(String num) {
    int i = 0;
    try {
      i = adminmapper.deletenotice(num);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public int insertnotice(Notice notice) {
    int i = 0;
    try {
      i = adminmapper.insertnotice(notice);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public List<Notice> nownotice() {
    return adminmapper.nownotice();
  }

  @Override
  public int Insertfeedback(Feedback feedback) {
    int i = 0;
    try {
      i = adminmapper.Insertfeedback(feedback);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public List<Feedback> listfeedback() {
    return adminmapper.listfeedback();
  }

  @Override
  public List<Floornums> floosnums() {


    Map<String, String> map1=new HashMap<String, String>();
    List<Map<String,String>> list2 = new ArrayList<>();

    List<Floornums> list1=new ArrayList<>();
   List<Floornums> list=adminmapper.floornum();
    for (Floornums floornums : list) {
      //

      list2=adminmapper.typenums(floornums.getFloor());
      System.out.println("test++ "+list2);
      System.out.println("size " +list2.size());
      /*for (Map<String, String> map : list2) {
            floornums.setMap(map);
      }*/
      floornums.setListmap(list2);

      list1.add(floornums);
    }

    return list1;
  }

  @Override
  public List<Map<String, String>> equipnums() {
    return adminmapper.equipnums();
  }

  @Override
  public List<Expend> equip_expend() {
    //先查询使用了的设备编号和使用的数量
    List<Map<String, String>> list1=adminmapper.typeequip();
    List <Expend> list=new ArrayList<>();
   Map<String ,Map<String, String>> map1=new HashMap<>();
    List<Map<String, String>> list2=new ArrayList<>();

    System.out.println("size"+list1.size());
    for (Map<String, String> map : list1) {
     list2=adminmapper.equip_price(String.valueOf(map.get("eid")));
      for (Map<String, String> map3 : list2) {
        //
        Expend expend=new Expend();

        String num=String.valueOf(map.get("sum"));
        String price=String.valueOf(map3.get("price"));
        double sum=Double.parseDouble(price)*Integer.parseInt(num);
        expend.setEqname(map3.get("eqname"));
        expend.setCost(sum);
        expend.setEid(map.get("eid"));
        expend.setPrice(String.valueOf(map3.get("price")));
        list.add(expend);

      }

    }
    System.out.println(list.toString());
    return list;
  }

  @Override
  public List<Worker> eval_rank() {
    return adminmapper.eval_rank();
  }

  @Override
  public List<Map<Object, Object>> use_num() {
    return adminmapper.use_num();
  }

  @Override
  public List<Worker_num> w_num() {
    return adminmapper.w_num();
  }

  @Override
  public List<equip_live> equip_live() {
    return adminmapper.equip_live();
  }


}
