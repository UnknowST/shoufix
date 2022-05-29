package com.mapper;

import com.daomain.User;
import com.daomain.Worker;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface Loginmapper {
    User check_userid(String userid);
    User Userlogin(User user);
    Worker Workerlogin(Worker worker);
    int insertuser(User user);
    int insertworker(Worker worker);
    /*用户校验邮件地址和账号是否匹配*/
    User checkemail_user(String userid,String mail );
    /*工人校验邮件地址和账号是否匹配*/
    Worker checkemail_worker(String userid,String mail);
    /*修改用户密码*/
    int modifpass_user(String userid,String password);
    /*修改工人密码*/
    int modifpass_worker(String userid,String password);
    /*当用户注册的时候校验用户的账号是否已经存在 邮箱是否已经被使用*/
    List<String> checkuserid();
    List<String> checkemail();
    /*根据激活码查找用户*/
    User findbycode(String code);
    /*激活用户*/
    int updatestatus(String userid);

}
