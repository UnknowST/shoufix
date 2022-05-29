package com.Interceptor;

import com.daomain.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

@RequestMapping("LoginInterceptor")
/*登录拦截器*/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean flag=false;
        //获取资源的请求路径
        String url=request.getRequestURI();
        System.out.println(url+"地址");


        //url=url.replaceAll("/","");
        String str1[]=url.split("/");
        System.out.println(str1.length);
        if(str1.length==0) return true;
        Properties pro=new Properties();
        InputStream in = getClass().getClassLoader().getResourceAsStream("power.properties");
        pro.load(in);//读取键值对 pro.load(fr);
      /*  if(str1.length==2&&"0".equals(pro.getProperty(str1[1]))){
            flag=true;
            return flag;
        }*/
        String str=pro.getProperty(str1[1]);//取值
        System.out.println(str);
        String projectname=request.getServletContext().getContextPath();

        System.out.println("url+++"+url);
        System.out.println("url2+++"+str1[1]);
         System.out.println("str+++"+str);
        System.out.println("num+++"+Message.num);

        if("0".equals(str)){
            flag=true;
      System.out.println("公共资源放行------");
            return flag;
        } else {
            //判断session user是否存在
            Object object=request.getSession().getAttribute("user");
            //不空既是登录状态
            if(object!=null){
                //判断是什么类型的用户
                if(Message.num==1){
                    //普通用户
                    if("1".equals(str)) flag=true;
                    else flag=false;
                }
                if(Message.num==2){
                    //维修师傅
                    if("2".equals(str)) flag=true;
                    else flag=false;
                }
                if(Message.num==3){
                    //管理员
                    if("3".equals(str)) flag=true;
                    else flag=false;
                }
                if(flag==true) return flag;
                else {


                    response.sendRedirect(request.getContextPath()+"/power.jsp?num=1");  //num状态为1 权限不足
                    System.out.println("状态不放行-----");
                }

            }
            //没有登录
            else {
                flag=false;
                response.sendRedirect(request.getContextPath()+"/power.jsp?num=2");  //num状态为 没有登录

            }


            return flag;

        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
