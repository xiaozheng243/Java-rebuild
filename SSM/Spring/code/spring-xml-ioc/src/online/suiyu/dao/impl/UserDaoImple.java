package online.suiyu.dao.impl;

import online.suiyu.dao.UserDao;

public class UserDaoImple implements UserDao {

    private String name;
    private String password;

    public UserDaoImple() {
    }

    public UserDaoImple(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public void getUser() {
        System.out.println("userDao执行！");
    }

    public void getNewUser() {
        System.out.println(name + "::" + password);
    }

}
