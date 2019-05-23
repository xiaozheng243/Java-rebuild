package javabasic.CollectionDemo;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(34, 45, 56, 12, 23, 34, 45);
        Integer max = Collections.max(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(max);
        HashMap<String, String> map;
    }
}
