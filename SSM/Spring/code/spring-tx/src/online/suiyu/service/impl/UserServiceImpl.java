package online.suiyu.service.impl;

import online.suiyu.dao.UserDao;
import online.suiyu.service.UserService;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void change() {
        userDao.add(2);
        userDao.reduce(3);
    }
}
