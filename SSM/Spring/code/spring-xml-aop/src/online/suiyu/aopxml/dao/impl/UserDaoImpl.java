package online.suiyu.aopxml.dao.impl;

import online.suiyu.aopxml.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDao save");
    }

    @Override
    public void update() {
        System.out.println("UserDao update");
    }
}
