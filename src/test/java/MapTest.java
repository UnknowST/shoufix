import com.Utils.MailUtil;
import com.daomain.Infor;
import com.mapper.Workermapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MapTest {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig-spring.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得MyBatis框架生成的UserMapper接口的实现类
        Workermapper workermapper = sqlSession.getMapper(Workermapper.class);
        List<Infor> listinfor = workermapper.Listinfor("11111");
        System.out.println(listinfor);
        sqlSession.close();

    }
    @Test
    public void test2(){
        String path;
        Scanner sc=new Scanner(System.in);
        path=sc.nextLine();
    System.out.println("null".equals(path));
    }

    @Test
    public void test3() throws MessagingException {
        MailUtil mailUtil=new MailUtil();
        String code=mailUtil.RandomCode();
        //把code存进session中

        String title="nishibuhsihen";
        String context="zhehiyijiao<span style='color: brown;font-size: 35px' >"+code+"</span>gasdasjdgjh";
        int i= mailUtil.sendMail("1757949943@qq.com",context,title);
    if (i == 1) System.out.println("发送成功");
    else System.out.println("发送失败");
    }

    @Test
    public  void test4(){
  /*      HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String,Integer>>();

        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("一班张三", 20);
        map1.put("一班李四", 22);
        map.put("一班", map1);

        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        map1.put("二班张三", 200);
        map1.put("二班李四", 222);
        map.put("二班", map2);

        Set<String> set = map.keySet();
        for (String string : set) {
            System.out.println(string);
            HashMap<String, Integer> mapneibu = map.get(string);
            Set<String> set2 = mapneibu.keySet();
            for (String string2 : set2) {
                System.out.println(string2+"--"+mapneibu.get(string2));
            }
        }*/

        List<Map<String, String>> list=new ArrayList<>();
        Map<String, String> map3=new HashMap<>();
        map3.put("一班张三", "20");
        map3.put("一班李四", "22");
        map3.put("二班张三", "200");
        map3.put("二班李四", "222");

        list.add(map3);
        System.out.println(list.size());
    for (Map<String, String> map4 : list) {
      //
      System.out.println(map4.toString());
        for(String key:map4.keySet()){
        System.out.println(key);
        System.out.println(map4.get(key));
        }
    }
    }
}
