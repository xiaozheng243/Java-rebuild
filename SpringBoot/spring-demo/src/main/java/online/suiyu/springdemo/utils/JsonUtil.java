package online.suiyu.springdemo.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
    public static void main(String[] args) {
        String string = "{\n" +
                "\t\"name\":\"yuluo\",\n" +
                "\t\"age\":23\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(string);
        System.out.println(jsonObject.getString("name"));
        System.out.println(jsonObject.getInteger("age"));
        System.out.println("--------------------");
        Person person = JSONObject.parseObject(string, Person.class);
        System.out.println(person.getName());
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}