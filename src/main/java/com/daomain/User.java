package com.daomain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
  private Integer num;
  private String userid, username, password, phone, name, gender, collage, mail, headpath;
  private String code, status; // 激活码和激活状态

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  Date createdate;

  public String getHeadpath() {
    return headpath;
  }

  public void setHeadpath(String headpath) {
    this.headpath = headpath;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public Date getCreatedate() {
    return createdate;
  }

  public void setCreatedate(Date createdate) {
    this.createdate = createdate;
  }

  public String getCollage() {
    return collage;
  }

  public void setCollage(String collage) {
    this.collage = collage;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "User{"
        + "num="
        + num
        + ", userid='"
        + userid
        + '\''
        + ", username='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + ", phone='"
        + phone
        + '\''
        + ", name='"
        + name
        + '\''
        + ", gender='"
        + gender
        + '\''
        + ", collage='"
        + collage
        + '\''
        + ", mail='"
        + mail
        + '\''
        + ", headpath='"
        + headpath
        + '\''
        + ", code='"
        + code
        + '\''
        + ", status='"
        + status
        + '\''
        + ", createdate="
        + createdate
        + '}';
  }
}
