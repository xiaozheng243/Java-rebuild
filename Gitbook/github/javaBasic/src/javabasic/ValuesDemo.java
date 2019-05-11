package javabasic;

import java.lang.reflect.Field;

public class ValuesDemo {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "a";
        String str4 = str3 + "bc";
        System.out.println(str1 == str2);
        System.out.println(str1 == str4);

    }
    void test(){
     
    }
}
