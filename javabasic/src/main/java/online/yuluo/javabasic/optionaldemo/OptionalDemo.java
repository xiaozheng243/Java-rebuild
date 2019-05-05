package online.yuluo.javabasic.optionaldemo;

import online.yuluo.javabasic.model.UserVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalDemo {

    public static void main(String[] args) {
        UserVO userVO = new UserVO();
        userVO.setAge(21);
        userVO.setName("suiyu");
        userVO.setId(241);
        UserVO userVO1 = new UserVO();
        userVO1.setAge(23);
//        userVO1.setName("yuluo");
        userVO1.setId(243);
        System.out.println("name:" + userVO1.getName());
        Integer aa = test1(userVO);
        System.out.println(aa);
        System.out.println("-------");
        List<UserVO> list = new ArrayList<>();
        list.add(userVO);
        list.add(userVO1);
//        for (int i = 0; i < 1000; i++) {
//            UserVO userVO2 = new UserVO();
//            userVO2.setId(i);
//            userVO2.setAge(i + 1);
//            list.add(userVO2);
//        }
        Long start1 = System.currentTimeMillis();
        for (UserVO uu : list) {
            if (uu.getName() == null || uu.getName().equals("")) {
                uu.setName(uu.getId() + "" + uu.getAge());
            }
//            System.out.println(uu.toString());
        }
        Long end1 = System.currentTimeMillis();
        System.out.println("----------");
        Long start2 = System.currentTimeMillis();
        List<UserVO> list1 = list.parallelStream().peek(e -> {
                    if (e.getName() == null || e.getName().equals("")) {
                        e.setName(e.getId() + "");
                    } else {
                        e.setName(e.getName() + "" + e.getAge());
                    }
//                    e.setName(Optional.ofNullable(e).map(UserVO::getName).orElseGet(() -> e.getId() + "" + e.getAge()));
                }
        ).collect(Collectors.toList());
        Long end2 = System.currentTimeMillis();
        System.out.println("1:" + (end1 - start1));
        System.out.println("2:" + (end2 - start2));
        list1.forEach(System.out::println);
    }

    static Integer test1(UserVO user) {
        return Optional.ofNullable(user)
                .map(UserVO::getAge)
                .filter(age -> age > 0)
                .orElseThrow(() -> new NullPointerException("年龄为空"));
    }
}
