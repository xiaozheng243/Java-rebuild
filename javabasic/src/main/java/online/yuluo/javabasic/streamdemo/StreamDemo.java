package online.yuluo.javabasic.streamdemo;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbba");
        list.add("ccc");
        list.add("ddda");
        StringBuilder ss = new StringBuilder("");
        list.parallelStream().forEach(e -> {
            if (e.contains("a")) {
                ss.append(e);
            }
        });
        System.out.println(ss);
    }
}
