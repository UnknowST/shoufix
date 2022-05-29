import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringTest {
    private Arrays Ints;

    @Test
    public void test2(){
       /* String path;
        Scanner sc=new Scanner(System.in);
        path=sc.nextLine();
        System.out.println("null".equals(path));*/
        String str="/";
        String  []str1=str.split("/");
    System.out.println(str1.length);
    }
    @Test
    public void test3(){
        String str="Y";
    System.out.println("Y".equals(str));
    }

    @Test
    public void test4(){

        int a[]=new int[]{1,2,3,4};
      List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            list.add(a[i]);
        }
        System.out.println(list.contains(1));
    }
}
