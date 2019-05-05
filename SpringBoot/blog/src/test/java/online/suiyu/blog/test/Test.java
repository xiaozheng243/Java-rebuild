package online.suiyu.blog.test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String string = new String("abc");
        StringUtils stringUtils = new StringUtils();
        if (stringUtils.isNotEmpty(string)) {
            System.out.println("---");
        }
    }
}
