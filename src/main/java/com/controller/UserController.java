package com.controller;

import com.daomain.Infor;
import com.daomain.Message;
import com.daomain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Userservice;
import com.service.impl.UserserviceImpl;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;

import org.apache.http.entity.ContentType;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired private Userservice userservice;
  private Message message = new Message();
  /*更新用户信息*/
  @RequestMapping("/update")
  @ResponseBody
  public Message saveuser(User user, HttpServletRequest request) throws NullPointerException {
    User user1 = userservice.updateuser(user);
    if (user1 != null) { // 我淦 之前一直循环更新不出结果的原因就是 user1写成了user
      request.getSession().setAttribute("user", user1);
      message.setFlag(1);
      message.setMessage("修改成功！");
    } else {
      message.setFlag(0);
      message.setMessage("修改失败，请重试");
    }
    return message;
  }

  /*文件上传方法 上传维修信息*/
  /*
  *
  * userid: 1853130
    floor: 第4小区
    layer: 2楼
    h_number: A030栋208
    equip: 水龙头
    reason: 松动
    detail:  滴答滴答
  * */
  @RequestMapping("/upfile")
  @ResponseBody
  public Message test5(
      MultipartFile[] file,
      @RequestParam("userid") String userid,
      @RequestParam("floor") String floor,
      @RequestParam("layer") String layer,
      @RequestParam("h_number") String h_number,
      @RequestParam("reason") String reason,
      @RequestParam("equip") String equip,
      @RequestParam("detail") String detail,
      HttpServletRequest request)
      throws IOException {

    detail = Encode.forHtmlContent(detail);


    int count = 0; // 用来记录上传图片的数量 最多上传五张图

    Infor infor = new Infor();
    // 上传文件不为空
    if (file.length != 0) {
      if (file.length > 5) {
        message.setFlag(0);
        message.setMessage("最多只能上传五张图片！");
        return message;
      }

      for (MultipartFile multipartFile : file) {

        count++;
        String realpath; // 实际保存到项目中的路径
        String sqlpath; // 保存到数据库中问路径
        String path = request.getServletContext().getRealPath("/images/"); // 获取项目路径
        String projectname = request.getServletContext().getContextPath(); // 获取项目名称
        // 生成uuid作为文件名称
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 得到新的文件名 统一图片类型为jpg
        String newfilename = uuid + ".jpg";

        File filepath = new File(path + newfilename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
          System.out.println("创建文件夹");
          filepath.getParentFile().mkdirs();
        }
        String uppath = path + newfilename;

        // 将上传文件保存到一个目标文件当中

        Thumbnails.of(multipartFile.getInputStream())
            .scale(1f) // 放大还是缩小
            .outputQuality(0.1f) // 图片质量
            .toFile(uppath);

        File file1 = new File(uppath);
        FileInputStream fileInputStream = new FileInputStream(file1);
        MultipartFile multipartFile1 =
            new MockMultipartFile(
                file1.getName(),
                file1.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(),
                fileInputStream);

        try {
          multipartFile1.transferTo(new File(uppath));
        } catch (IOException ioException) {
          ioException.printStackTrace();
        } catch (IllegalStateException illegalStateException) {
          illegalStateException.printStackTrace();
        }

        sqlpath = projectname + "/images/" + newfilename;
        if (count == 1) {
          // 第1长图片
          infor.setImagepath1(sqlpath);
        }
        if (count == 2) {
          // 第1长图片
          infor.setImagepath2(sqlpath);
        }
        if (count == 3) {
          // 第3长图片
          infor.setImagepath3(sqlpath);
        }
        if (count == 4) {
          // 第4长图片
          infor.setImagepath4(sqlpath);
        }
        if (count == 5) {
          // 第5长图片
          infor.setImagepath5(sqlpath);
        }
      }

      // 添加其他数据
      infor.setUserid(userid);
      infor.setFloor(floor);
      infor.setReason(reason);
      infor.setLayer(layer);
      infor.setH_number(h_number);
      infor.setEquip(equip);
      infor.setDetail(detail);
      // 保存到数据库
      int i = 0;
      try {
        i = userservice.insertinfor(infor);
      } catch (Exception e) {
        i = -1;
      }
      if (i == 1) {
        message.setFlag(1);
        message.setMessage("填报成功！");
      } else {
        message.setFlag(0);
        message.setMessage("填报失败，请重试！");
      }
      return message;

    } else {
      // 之间添加其他数据
      infor.setUserid(userid);
      infor.setFloor(floor);
      infor.setReason(reason);
      infor.setLayer(layer);
      infor.setH_number(h_number);
      infor.setEquip(equip);
      infor.setDetail(detail);
      // 保存到数据库
      int i = 0;
      try {
        i = userservice.insertinfor(infor);
      } catch (Exception e) {
        i = -1;
      }
      if (i == 1) {
        message.setFlag(1);
        message.setMessage("填报成功！");
      } else {
        message.setFlag(0);
        message.setMessage("填报失败，请重试！");
      }
      return message;
    }
  }

  /*修改维修信息*/
  @RequestMapping("/update_infor")
  @ResponseBody
  public Message test9(
      MultipartFile[] file,
      @RequestParam("userid") String userid,
      @RequestParam("floor") String floor,
      @RequestParam("layer") String layer,
      @RequestParam("h_number") String h_number,
      @RequestParam("reason") String reason,
      @RequestParam("equip") String equip,
      @RequestParam("detail") String detail,
      @RequestParam("num") String num,
      @RequestParam("images") String []images,
      @RequestParam("nums") int []nums,
      HttpServletRequest request) throws IOException {
    /*解决xss攻击*/

    detail = Encode.forHtmlContent(detail);
    System.out.println("num.length"+nums.length);
    System.out.println("images.length"+images.length);
    /*
     * file 是新上传的文件
     * images是原来就已经存在的图片
     * nums 是原本存在现在修改后还存在的图片的编号
     * 根据原本的编号来决定用户上传了多少新的图片
     */

    // 现在是多张图的路径 有的可能是之前就已经加入其中的 所以数据会不变

    int count = 0; // 用来记录新上传的图片数量
    Infor infor = new Infor();
    /*最多上传五张*/
 /*   if (file.length > 5) {
      message.setFlag(0);
      message.setMessage("最多只能上传五张图片！");
      return message;
    }*/
    // 上传文件不为空
    if (file.length != 0&&images.length==0) {    //用户重新上传了所有的图片
      /*清空之前的路径*/
      if(userservice.deleteimages(num)!=1)  {

        message.setFlag(0);
        message.setMessage("修改失败，请重试!");
        return message;
      }
      System.out.println("全是重新上传的");
      for (MultipartFile multipartFile : file) {
        count++;
        String realpath; // 实际保存到项目中的路径
        String sqlpath; // 保存到数据库中问路径
        String path = request.getServletContext().getRealPath("/images/"); // 获取项目路径
        String projectname = request.getServletContext().getContextPath(); // 获取项目名称

        // 生成uuid作为文件名称
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 得到新的文件名 统一图片类型为jpg
        String newfilename = uuid + ".jpg";

        File filepath = new File(path + newfilename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
          System.out.println("创建文件夹");
          filepath.getParentFile().mkdirs();
        }

        String uppath = path + newfilename;

        // 将上传文件保存到一个目标文件当中

        Thumbnails.of(multipartFile.getInputStream())
                .scale(1f) // 放大还是缩小
                .outputQuality(0.1f) // 图片质量
                .toFile(uppath);

        File file1 = new File(uppath);
        FileInputStream fileInputStream = new FileInputStream(file1);
        MultipartFile multipartFile1 =
                new MockMultipartFile(
                        file1.getName(),
                        file1.getName(),
                        ContentType.APPLICATION_OCTET_STREAM.toString(),
                        fileInputStream);

        try {
          multipartFile1.transferTo(new File(uppath));
        } catch (IOException ioException) {
          ioException.printStackTrace();
        } catch (IllegalStateException illegalStateException) {
          illegalStateException.printStackTrace();
        }

        sqlpath = projectname + "/images/" + newfilename;
        if (count == 1) {
          // 第1长图片
          infor.setImagepath1(sqlpath);
        }
        if (count == 2) {
          // 第1长图片
          infor.setImagepath2(sqlpath);
        }
        if (count == 3) {
          // 第3长图片
          infor.setImagepath3(sqlpath);
        }
        if (count == 4) {
          // 第4长图片
          infor.setImagepath4(sqlpath);
        }
        if (count == 5) {
          // 第5长图片
          infor.setImagepath5(sqlpath);
        }
      }



    }
    if(file.length==0&&images.length!=0){   //用户没有上传新的文件  传上来的都是新的文件
      //查看还有多少文件上传了   现在先不考虑把不需要的图片删除的操作
      /*清空之前的路径*/

      if(userservice.deleteimages(num)!=1)  {

        message.setFlag(0);
        message.setMessage("修改失败，请重试!");
        return message;
      }
      System.out.println("没有新上传");
      for(int i=0;i<images.length;i++){
        if (i+1 == 1) {
          // 第1长图片
          infor.setImagepath1(images[i]);
        }
        if (i+1 == 2) {
          // 第2长图片
          infor.setImagepath2(images[i]);
        }
        if (i+1 == 3) {
          // 第3长图片
          infor.setImagepath3(images[i]);
        }
        if (i+1 == 4) {
          // 第4长图片
          infor.setImagepath4(images[i]);
        }
        if (i+1 == 5) {
          // 第5长图片
          infor.setImagepath5(images[i]);
        }
      }
    }
    if(file.length!=0&&images.length!=0){
      System.out.println("信息两者都有上传");

      /*既有新上传的 也有原本就存在的*/
      /*先把原本留下的存到数组*/
      List<Integer> list=new ArrayList<Integer>();
      for(int i=0;i<nums.length;i++){
        list.add(nums[i]);
        if (nums[i]== 1) {
          // 第1长图片
          infor.setImagepath1(images[i]);
        }
        if (nums[i]== 2) {
          // 第2长图片
          infor.setImagepath2(images[i]);
        }
        if (nums[i] == 3) {
          // 第3长图片
          infor.setImagepath3(images[i]);
        }
        if (nums[i]== 4) {
          // 第4长图片
          infor.setImagepath4(images[i]);
        }
        if (nums[i]== 5) {
          // 第5长图片
          infor.setImagepath5(images[i]);
        }
      }

      int i=0;
      count=0;
      /*创建一个数组*/
      int []cu=new int[]{1,2,3,4,5};
      List list2=new ArrayList();
      list2.add(1);
      list2.add(2);
      list2.add(3);
      list2.add(4);
      list2.add(5);
      //两个集合做差
      list2.removeAll(list);

      for (MultipartFile multipartFile : file) {

        String realpath; // 实际保存到项目中的路径
        String sqlpath; // 保存到数据库中问路径
        String path = request.getServletContext().getRealPath("/images/"); // 获取项目路径
        String projectname = request.getServletContext().getContextPath(); // 获取项目名称

        // 生成uuid作为文件名称
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 得到新的文件名 统一图片类型为jpg
        String newfilename = uuid + ".jpg";

        File filepath = new File(path + newfilename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
          System.out.println("创建文件夹");
          filepath.getParentFile().mkdirs();
        }

        String uppath = path + newfilename;

        // 将上传文件保存到一个目标文件当中

        Thumbnails.of(multipartFile.getInputStream())
                .scale(1f) // 放大还是缩小
                .outputQuality(0.1f) // 图片质量
                .toFile(uppath);

        File file1 = new File(uppath);
        FileInputStream fileInputStream = new FileInputStream(file1);
        MultipartFile multipartFile1 =
                new MockMultipartFile(
                        file1.getName(),
                        file1.getName(),
                        ContentType.APPLICATION_OCTET_STREAM.toString(),
                        fileInputStream);

        try {
          multipartFile1.transferTo(new File(uppath));
        } catch (IOException ioException) {
          ioException.printStackTrace();
        } catch (IllegalStateException illegalStateException) {
          illegalStateException.printStackTrace();
        }

        sqlpath = projectname + "/images/" + newfilename;
 
          //
          int m= (int) list2.get(count);
            if (m==1) {
              // 第1张图片
              infor.setImagepath1(sqlpath);
            }
            if (m==2) {
              // 第2张图片
              infor.setImagepath2(sqlpath);
            }
            if (m==3) {
              // 第3张图片
              infor.setImagepath3(sqlpath);
            }
            if (m==4) {
              // 第4张图片
              infor.setImagepath4(sqlpath);
            }
            if (m==5) {
              // 第5张图片
              infor.setImagepath5(sqlpath);
            }
        count++;
      }




    }
    // 添加其他数据
    infor.setUserid(userid);
    infor.setNum(Integer.parseInt(num));

    infor.setFloor(floor);
    infor.setReason(reason);
    infor.setLayer(layer);
    infor.setH_number(h_number);
    infor.setEquip(equip);
    infor.setDetail(detail);
    // 保存到数据库
    int i = 0;
    try {
      i = userservice.update_infor(infor);
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

  /*
   * 查找指定用户id的维修记录*/
  /*此时获取到的是所有的维修单*/
  @RequestMapping("/allinfor")
  @ResponseBody
  public ModelAndView test6(String userid, Integer p) {
    // 设置分页相关参数   当前页+每页显示的条数
    PageHelper.startPage(p, 10);

    ModelAndView modelAndView = new ModelAndView();
    List<Infor> list = userservice.findbyuserid(userid);

    for (Infor infor : list) {
      // 循环构建相应的 imagepaths list
      infor.setList();
    }
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("您还当前没有相关的维修单");
      modelAndView.addObject("userid", userid);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("s_record.jsp");
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("message", message);
      modelAndView.addObject("userid", userid);
      modelAndView.setViewName("s_record.jsp");
    }
    return modelAndView;
  }
  /*查找指定主键的infor记录*/
  @RequestMapping("/infor_num")
  @ResponseBody
  public ModelAndView test7(String num) {
    ModelAndView modelAndView = new ModelAndView();
    Infor infor = userservice.infor_num(Integer.parseInt(num));
    infor.setList();
    modelAndView.addObject("infor", infor);
    System.out.println("testset+++" + infor);

    modelAndView.setViewName("infordetail.jsp");
    return modelAndView;
  }
  /*查询待分配的维修单*/
  @RequestMapping("/infor_dai")
  @ResponseBody
  public ModelAndView test11(String userid, Integer p) {
    PageHelper.startPage(p, 10);
    ModelAndView modelAndView = new ModelAndView();
    List<Infor> list = userservice.infor_dai(userid);

    for (Infor infor : list) {
      // 循环构建相应的 imagepaths list
      infor.setList();
    }
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("您还当前没有相关的维修单");
      modelAndView.addObject("userid", userid);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("s_daiinfor.jsp");
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("message", message);
      modelAndView.addObject("userid", userid);
      modelAndView.setViewName("s_daiinfor.jsp");
    }
    return modelAndView;
  }
  /*查询用户正在维修的维修单*/
  @RequestMapping("/infor_ing")
  @ResponseBody
  public ModelAndView test12(String userid, Integer p) {
    PageHelper.startPage(p, 10);
    ModelAndView modelAndView = new ModelAndView();
    List<Infor> list = userservice.infor_ing(userid);

    for (Infor infor : list) {
      // 循环构建相应的 imagepaths list
      infor.setList();
    }

    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("您还当前没有相关的维修单");
      modelAndView.addObject("userid", userid);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("s_inginfor.jsp");
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("message", message);
      modelAndView.addObject("userid", userid);
      modelAndView.setViewName("s_inginfor.jsp");
    }
    return modelAndView;
  }

  /*查询用户待维修的维修单*/
  @RequestMapping("/infor_wait")
  @ResponseBody
  public ModelAndView test13(String userid, Integer p) {
    PageHelper.startPage(p, 10);
    ModelAndView modelAndView = new ModelAndView();
    List<Infor> list = userservice.infor_wait(userid);

    for (Infor infor : list) {
      // 循环构建相应的 imagepaths list
      infor.setList();
    }
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("您还当前没有相关的维修单");
      modelAndView.addObject("userid", userid);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("s_waitinfor.jsp");
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("message", message);
      modelAndView.addObject("userid", userid);
      modelAndView.setViewName("s_waitinfor.jsp");
    }
    return modelAndView;
  }

  /*查询用户已完成维修的维修单 也就是待评分的维修单*/
  @RequestMapping("/infor_eval")
  @ResponseBody
  public ModelAndView test14(String userid, Integer p) {
    PageHelper.startPage(p, 10);
    ModelAndView modelAndView = new ModelAndView();
    List<Infor> list = userservice.infor_eval(userid);

    for (Infor infor : list) {
      // 循环构建相应的 imagepaths list
      infor.setList();
    }
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("您还当前没有相关的维修单");
      modelAndView.addObject("userid", userid);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("s_evalinfor.jsp");
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("message", message);
      modelAndView.addObject("userid", userid);
      modelAndView.setViewName("s_evalinfor.jsp");
    }
    return modelAndView;
  }
  /*删除指定主键的Infor表单 并且一同删除相应的replay表单*/
  @RequestMapping("/delete_infor")
  @ResponseBody
  public Message test8(String num) {
    if (userservice.delete_infor(Integer.parseInt(num)) == 1) {
      message.setFlag(1);
      message.setMessage("删除成功!");
    } else {
      message.setFlag(0);
      message.setMessage("删除失败,请重试！");
    }
    return message;
  }

  /*修改用户密码*/
  @RequestMapping("modif_pass")
  @ResponseBody
  public Message test10(String num, String password) {
    int i = 0;
    try {
      i = userservice.modif_pass(num, password);
    } catch (Exception e) {
      i = -1;
    }
    if (i == 1) {
      message.setFlag(1);
      message.setMessage("密码修改成功");
    } else {
      message.setFlag(0);
      message.setMessage("密码修改失败，请重试");
    }
    return message;
  }

  /*用户评分*/
  @RequestMapping("/eval")
  @ResponseBody
  public Message test11(String num, String fenshu, String workerid, String comment) {
    if (userservice.updateevl(num, fenshu, workerid, comment) == 1) {
      message.setFlag(1);
      message.setMessage("确认成功，感谢你的支持");
    } else {
      message.setFlag(0);
      message.setMessage("确认失败，请重试！");
    }
    return message;
  }

  @RequestMapping("/headupload")
  @ResponseBody
  public Message cropper(
      @RequestParam("file") String file,
      @RequestParam("userid") String userid,
      HttpServletRequest request)
      throws Exception {

    Base64.Decoder decoder = Base64.getDecoder();
    // 去掉base64编码的头部 如："data:image/jpeg;base64," 如果不去，转换的图片不可以查看
    file = file.substring(22);

    String savepath; // 实际保存的路劲
    String sqlpath; // 保存到数据库中的路径
    // 生成uuid作为文件名称
    // String uuid = UUID.randomUUID().toString().replaceAll("-","");
    // 得到新的文件名
    String newfilename = userid + "." + "jpg";
    // 获取项目名称
    String name = request.getServletContext().getContextPath();
    // 获取上传文件路径
    String path = request.getServletContext().getRealPath("/head/user/");
    File filepath = new File(path + newfilename);
    // 判断路径是否存在，如果不存在就创建一个
    if (!filepath.getParentFile().exists()) {
      System.out.println("创建文件夹");
      filepath.getParentFile().mkdirs();
    }
    // 解码
    byte[] imgByte = decoder.decode(file);
    try {
      FileOutputStream out = new FileOutputStream(path + newfilename); // 输出文件路径
      out.write(imgByte);
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    String headpath = name + "/head/user/" + newfilename;
    System.out.println(headpath + "---");

    if (userservice.user_head(userid, headpath) == 1) {
      User user = (User) request.getSession().getAttribute("user");
      user.setHeadpath(headpath);
      request.getSession().setAttribute("user", user);
      message.setFlag(1);
      message.setMessage("修改成功");
    } else {
      message.setFlag(0);
      message.setMessage("修改失败，请重试");
    }
    return message;
  }

  /*查询用户已完成维修的维修单 也就是待评分的维修单*/
  @RequestMapping("/infor_day30")
  @ResponseBody
  public ModelAndView test20(Integer p) {
    PageHelper.startPage(p, 10);
    ModelAndView modelAndView = new ModelAndView();
    List<Infor> list = userservice.listInfor();
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("近三十天没有维修记录");
      modelAndView.setViewName("NearInfor.jsp");
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("NearInfor.jsp");
    }
    return modelAndView;
  }

  @RequestMapping("/normalinfor")
  @ResponseBody
  public ModelAndView test31(String userid, Integer p) {
    PageHelper.startPage(p, 10);
    ModelAndView modelAndView = new ModelAndView();
    List<Infor> list = userservice.normalInfor(userid);
    for (Infor infor : list) {
      //
      infor.setList();
    }
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有相关记录");
      modelAndView.addObject("userid", userid);
      modelAndView.setViewName("s_abnormal.jsp");
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("userid", userid);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("s_abnormal.jsp");
    }
    return modelAndView;
  }

  /*已经完成并且 已经评分*/
  @RequestMapping("/infor_ok")
  @ResponseBody
  public ModelAndView test33(String userid, Integer p) {
    PageHelper.startPage(p, 10);
    ModelAndView modelAndView = new ModelAndView();
    List<Infor> list = userservice.infor_ok(userid);
    for (Infor infor : list) {
      infor.setList();
    }
    if (list.size() == 0) {
      message.setFlag(0);
      message.setMessage("当前没有相关记录");
      modelAndView.addObject("userid", userid);
      modelAndView.setViewName("s_lookinfor_ok.jsp");
      return modelAndView;
    } else {
      message.setFlag(1);
      PageInfo<Infor> pageInfo = new PageInfo<Infor>(list);
      modelAndView.addObject("page", pageInfo);
      modelAndView.addObject("userid", userid);
      modelAndView.addObject("inforlist", list);
      modelAndView.addObject("message", message);
      modelAndView.setViewName("s_lookinfor_ok.jsp");
    }
    return modelAndView;
  }

  @RequestMapping(value = "test",method = RequestMethod.GET,
          produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String test33() {
      return "今天周三";
  }

}
