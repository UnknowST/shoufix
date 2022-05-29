package com.controller;

import com.Utils.MailUtil;
import com.daomain.Message;
import com.daomain.User;
import com.daomain.Worker;
import com.service.LoginService;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/login")
public class LoginController {
  @Autowired LoginService loginService;
  private Message message = new Message();
  /*邮件服务工具类*/
  MailUtil mailUtil = new MailUtil();



/*  *//*用户登录*//*
  @RequestMapping("/test1")
  @ResponseBody
  public Message login(
      String code,
      String userid,
      String password,
      String shenfen,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException {

    // 从sesion中获取验证码
    HttpSession session = request.getSession();
    String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
    session.removeAttribute("CHECKCODE_SERVER"); // 为了保证验证码只能使用一次
    // 比较
    if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(code)) {
      // 验证码错误
      // 登陆失败
      message.setFlag(0);
      message.setMessage("验证码错误");
      return message;
    }

    String flag = null;
    System.out.println(userid + " " + password + " " + shenfen);
    if ("1".equals(shenfen) == true) {
      User user = new User();
      user.setUserid(userid);
      user.setPassword(password);
      User user1 = loginService.Userlogin(user);
      if (user1 != null) {

        if ("Y".equals(user1.getStatus())) {

          Message.num = 1;
          message.setFlag(1);
          request.getSession().setAttribute("user", user1);
        } else {
          message.setFlag(0);
          message.setMessage("用户还未激活，请先激活!");
        }
      } else {
        message.setMessage("密码或账号不正确");
        message.setFlag(0);
      }
    }
    if ("2".equals(shenfen) == true) {

      Worker worker = new Worker();
      worker.setUserid(userid);
      worker.setPassword(password);
      Worker worker1 = loginService.Workerlogin(worker);
      if (worker1 != null) {
        message.setFlag(1);
        Message.num = 2;
        request.getSession().setAttribute("user", worker1);
      } else {
        message.setMessage("密码或账号不正确");
        message.setFlag(0);
      }
    }
    if ("3".equals(shenfen) == true) {
      if (userid.equals("admin") && password.equals("12345")) {

        message.setFlag(1);
        Message.num = 3;
        Map<String, String> map = new HashMap<>();
        map.put("name", "admin");
        map.put("password", "12345");
        request.getSession().setAttribute("user", map);

      } else {
        message.setMessage("密码或账号不正确");
        message.setFlag(0);
      }
    }

    return message;
  }*/



  @RequestMapping("/test1")
  @ResponseBody
  public Message test1(Integer num,String userid,String password,HttpServletRequest request){


   if(num==1){
     User user=new User();
     User user1=new User();
     user.setUserid(userid);
     user.setPassword(password);
     user1=loginService.Userlogin(user);
     if(user1!=null){
       message.setFlag(1);
       request.getSession().setAttribute("user",user1);
       message.setMessage("登录成功");

     }else {
       message.setFlag(0);
       message.setMessage("账号或密码错误！");
     }
   }
   if(num==2){
     Worker worker=new Worker();
     Worker  worker1=new Worker();
     worker.setUserid(userid);
     worker.setPassword(password);
     worker1=loginService.Workerlogin(worker);
     if(worker1!=null){
       message.setFlag(1);
       message.setMessage("登录成功");
       request.getSession().setAttribute("user",worker1);
     }else {
       message.setFlag(0);
       message.setMessage("账号或密码错误");

     }

   }
    if(num==3){
      if (userid.equals("admin") && password.equals("12345")) {

        message.setFlag(1);
        Message.num = 3;
        Map<String, String> map = new HashMap<>();
        map.put("name", "admin");
        map.put("password", "12345");
        request.getSession().setAttribute("user", map);

      } else {
        message.setMessage("密码或账号不正确");
        message.setFlag(0);
      }
    }

    return message;

  }


  /*从session中返回普通用户数据*/
  @RequestMapping("/finduser")
  @ResponseBody
  public User test2(HttpServletRequest request) {
    User user=new User();
    user=(User)request.getSession().getAttribute("user");
    user.setPassword(null);
   return user;
  }
  /*从session中返回工人数据*/
  @RequestMapping("/findworker")
  @ResponseBody
  public Worker test3(HttpServletRequest request) {
    Worker worker=new Worker();
    worker= (Worker) request.getSession().getAttribute("user");
    worker.setPassword(null);
    return worker;
  }

/*  *//*用户注册*//*
  @RequestMapping("/insert")
  @ResponseBody
  public Message insert(User user, String code, HttpServletRequest request) {
    // 从sesion中获取验证码
    HttpSession session = request.getSession();
    String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
    session.removeAttribute("CHECKCODE_SERVER"); // 为了保证验证码只能使用一次
    // 比较
    if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(code)) {
      // 验证码错误
      // 登陆失败
      message.setFlag(0);
      message.setMessage("验证码错误");
      return message;
    }
    // int num1=Integer.parseInt(num);

    *//*表示是插入普通用户*//*

    user.setCode(UUID.randomUUID().toString().replaceAll("-", ""));
    user.setStatus("N");
    int i = 0;
    try {
      i = loginService.insertuser(user);
    } catch (Exception e) {
      i = -1;
    }
    if (i == 1) {
      message.setFlag(1);
      message.setMessage("注册成功！请前往邮箱地址激活。");
    } else {
      message.setFlag(0);
      message.setMessage("注册失败！");
    }

    *//*        if (num1==2){
        Worker worker=new Worker();
        worker.setUserid(userid);
        worker.setPassword(password);
        int i=0;
        try {
            i=loginService.insertworker(worker);
        } catch (Exception e) {
            i=-1;
        }
        if(i==1){
            message.setFlag(1);
            message.setMessage("注册成功！");
        }else {
            message.setFlag(0);
            message.setMessage("注册失败！");
        }
    }*//*
    return message;
  }*/

  /*用户注册*/
  @RequestMapping("insert")
  @ResponseBody
  public  Message test3(User user){
    if(loginService.checkuserid(user.getUserid())==1){
      message.setMessage("该账号已经存在!");
      message.setFlag(0);
      return message;
    } else {
      if (loginService.insertuser(user) == 1) {
        message.setFlag(0);
        message.setMessage("注册成功，请登录");

      } else {
        message.setFlag(0);
        message.setMessage("注册失败，请重试!");
      }
      return message;
    }
  }
  /*激活用户*/
  @RequestMapping(
      value = "/active",
      method = RequestMethod.GET,
      produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String test10(String code) {
    String message;
    User user = loginService.findbycode(code);
    if (user != null) {
      int i = loginService.updatestatus(user.getUserid());
      if (i == 1) {
        message = "激活成功，<a href='http://www.shoufix.cn/login.html'>登录</a>";
      } else {
        message = "激活失败请联系管理员";
      }
    } else {
      message = "激活失败请联系管理员";
    }
    return message;
  }

  /*清除session 并退出*/
  @RequestMapping("/exit")
  public String test4(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.invalidate();
    return "redirect:/login.html";
  }
  /*验证邮件地址*/
  /*@RequestMapping("/checkmail")
  @ResponseBody
  public Message test6(String email,HttpServletRequest request) throws MessagingException {
     */
  /* String code=mailUtil.RandomCode();
  //把code存进session中
  request.getSession().setAttribute("codemail",code);*/
  /*
      String title="你好啊";
  String context =
      "这是一条验证邮箱的邮件，本次验证码为<a href='http://localhost:8080/REProject_war_exploded/login/linkmail' style='font-size: 30px;color: #1296db'>点我验证</a>\n请勿回复";
     int i= mailUtil.sendMail(email,context,title);
      if(i==1){
          message.setFlag(1);
          message.setMessage("邮件发送成功！");
      }else {
          message.setFlag(0);
          message.setMessage("邮件发送失败");
      }
      return message;
  }*/

  /*验证邮件地址*/
  /*    @RequestMapping("/linkmail")
  @ResponseBody
  public Message  test7(HttpServletRequest request)  {
      request.getSession().setAttribute("link",1);
     message.setFlag(1);
     message.setMessage("验证成功!");
     return message;


  }*/
  /*验证邮件地址*/
  /*    @RequestMapping("/checklink")
  @ResponseBody
  public Message test8(HttpServletRequest request)  {
     int n=0;
      try {
          n= (int) request.getSession().getAttribute("link");
      } catch (Exception e) {
          n=-1;
      }
      if(n==1) {
          message.setFlag(1);
          message.setMessage("验证成功");
          request.getSession().removeAttribute("link");
      }else {
          message.setFlag(0);
          message.setMessage("验证失败");
      }
      return message;
  }*/

  /*校验账号和邮件地址是否匹配*/
  @RequestMapping("/checkemail")
  @ResponseBody
  public Message test7(Integer shenfen, String userid, String mail, HttpServletRequest request)
      throws MessagingException {

    if (shenfen == 1) {
      User user = loginService.checkemail_user(userid, mail);
      if (user != null) {
        // 验证确实匹配 继续发送邮箱验证码
        String code = mailUtil.RandomCode();
        // 把code存进session中
        request.getSession().setAttribute("codemail", code);
        String title = "找回密码";
        String context =
            "这是一条找回密码验证码的邮件，本次找回密码的验证码为<span style='color: brown;font-size: 35px' >"
                + code
                + "</span>\n有效时间15分钟，请尽快验证。请勿回复";
        int m = mailUtil.sendMail(mail, context, title);
        if (m == 1) {
          message.setFlag(1);
          message.setMessage("邮件发送成功！");
        } else {
          message.setFlag(0);
          message.setMessage("邮件发送失败");
        }
        return message;

      } else {
        message.setFlag(0);
        message.setMessage("账号和邮件地址不匹配！");
      }
      return message;
    }
    if (shenfen == 2) {
      Worker worker = worker = loginService.checkemail_worker(userid, mail);
      if (worker != null) {
        // 验证确实匹配 继续发送邮箱验证码
        String code = mailUtil.RandomCode();
        // 把code存进session中
        request.getSession().setAttribute("codemail", code);
        String title = "找回密码";
        String context =
            "这是一条找回密码验证码的邮件，本次找回密码的验证码为<span style='color: brown;font-size: 35px' >"
                + code
                + "</span>\n有效时间15分钟，请尽快验证。请勿回复";
        int m = mailUtil.sendMail(mail, context, title);
        if (m == 1) {
          message.setFlag(1);
          message.setMessage("邮件发送成功！");
        } else {
          message.setFlag(0);
          message.setMessage("邮件发送失败");
        }
        return message;

      } else {
        message.setFlag(0);
        message.setMessage("账号和邮件地址不匹配！");
      }
      return message;
    }

    return message;
  }

  /*校验邮箱验证码*/
  @RequestMapping("/checkmailcode")
  @ResponseBody
  public Message test8(String code, HttpServletRequest request) {
    /*从session获取code*/
    String mailcode = (String) request.getSession().getAttribute("codemail");
    if (mailcode.equals(code)) {
      message.setFlag(1);
      message.setMessage("验证码正确！");

    } else {
      message.setFlag(0);
      message.setMessage("验证码错误！");
      /*刷新验证码*/
      request.getSession().removeAttribute("codemail");
    }
    return message;
  }
  /*修改密码*/
  @RequestMapping("/modifpass")
  @ResponseBody
  public Message test9(Integer shenfen, String userid, String password) {
    int i = 0;
    if (shenfen == 1) i = loginService.modifpass_user(userid, password);
    if (shenfen == 2) i = loginService.modifpass_worker(userid, password);
    if (i == 1) {
      message.setFlag(1);
      message.setMessage("密码修改成功!");
    } else {
      message.setFlag(0);
      message.setMessage("密码修改失败,请重试!");
    }
    return message;
  }

  /*获取当前已经存在的userid 和mail*/
  @RequestMapping("/getuserid_mail")
  @ResponseBody
  public Map<String, List> test10() {
    return loginService.check_userid_mail();
  }
}
