package javabasic;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DataTypes {
    public static void main(String[] args) {
        /**
         * 基本数据类型的定义
         * */
        byte byte1 = 1;
        short short1 = 1;
        char char1 = 'a';
        boolean bool1 = true;
        int int1 = 20;
        float float1 = 2.3f;
        double double1 = 2.3;
        long long1 = 56L;

        /**
         * 基本类型的封装类型
         */
        Byte byte2 = 1;
        Short short2 = 1;
        Character char2 = 'a';
        Boolean bool2 = true;
        Integer int2 = 20;
        Float float2 = 2.3f;
        Double double2 = 2.3;
        Long long2 = 56L;

        Integer integer1 = 127;
        Integer integer2 = 127;
        System.out.println(integer1 == integer2);
        System.out.println(Integer.MAX_VALUE - Integer.MIN_VALUE);

        Character character = 'a'; // 自动装箱
        char ch = character; // 自动拆箱

        BigDecimal bigDecimal = new BigDecimal(50);
        BigInteger bigInteger = new BigInteger("50");
        System.out.println(bigInteger);
    }
}
