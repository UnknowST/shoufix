package com.service.impl;

import com.Utils.MailUtil;
import com.daomain.User;
import com.daomain.Worker;
import com.mapper.Loginmapper;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("loginservice")
public class LoginServiceImpl implements LoginService {
  @Autowired Loginmapper loginmapper;

  @Override
  public User Userlogin(User user) {
    return loginmapper.Userlogin(user);
  }

  @Override
  public Worker Workerlogin(Worker worker) {
    return loginmapper.Workerlogin(worker);
  }

  @Override
  public int  checkuserid(String userid) {
    User user=loginmapper.check_userid(userid);
    if(user!=null)  return 1;
    else return 0;
  }

  @Transactional
  @Override
  public int insertuser(User user) {
   /* MailUtil mailUtil = new MailUtil();
    int i = 0;
    int m = 0;
    try {
      i = loginmapper.insertuser(user);
    } catch (Exception e) {
      i = -1;
    }
    if (i == 1) {
      // 发送激活邮件
      String title = "校园维修通激活邮件";
      String recive = user.getMail();
      String Code = user.getCode();
      String context =
          "请点击<a href='http://shoufix.cn/login/active?code="
              + Code
              + "' style='font-size: 30px;color: #1296db'>激活</a>账号";
      try {
        m = mailUtil.sendMail(recive, context, title);
      } catch (MessagingException e) {
        m = -1;
      }
    }
    if (i == 1 && m == 1) return 1;
    else return 0;*/
    return loginmapper.insertuser(user);
  }

  @Override
  public int insertworker(Worker worker) {
    return loginmapper.insertworker(worker);
  }

  @Override
  public User checkemail_user(String userid, String mail) {
    return loginmapper.checkemail_user(userid, mail);
  }

  @Override
  public Worker checkemail_worker(String userid, String mail) {
    return loginmapper.checkemail_worker(userid, mail);
  }

  @Override
  public int modifpass_user(String userid, String password) {
    int i = 0;
    try {
      i = loginmapper.modifpass_user(userid, password);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public int modifpass_worker(String userid, String password) {
    int i = 0;
    try {
      i = loginmapper.modifpass_worker(userid, password);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }

  @Override
  public Map<String, List> check_userid_mail() {
    Map map = new HashMap();
    List<String> list1 = loginmapper.checkuserid();
    List<String> list2 = loginmapper.checkemail();
    map.put("userid", list1);
    map.put("email", list2);
    return map;
  }

  @Override
  public User findbycode(String code) {
    return loginmapper.findbycode(code);
  }

  @Override
  public int updatestatus(String userid) {
    int i = 0;
    try {
      i = loginmapper.updatestatus(userid);
    } catch (Exception e) {
      i = -1;
    }
    return i;
  }
}
