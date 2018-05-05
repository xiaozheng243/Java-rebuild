package online.suiyu.service.impl;

import online.suiyu.service.CollectionDemo;

import java.util.*;

public class CollectionDemoImpl implements CollectionDemo {
    private String[] array;
    private List<String> list;
    private Map<Integer, String> map;
    private Set<String> set;

    public void setArray(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return array;
    }

    public void getList() {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void getMap() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public void getSet() {
        for (String s : set) {
            System.out.println(s);
        }
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @Override
    public void showArray() {
        for (String arr : array) {
            System.out.println(arr);
        }
    }
}
