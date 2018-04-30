package online.suiyu.service.impl;

import online.suiyu.dao.impl.UserDaoImple;
import online.suiyu.service.UserService;

public class UserServiceImpl implements UserService {
    private String name;
    private UserDaoImple userDao;

    public void setName(String name) {
        this.name = name;
    }

    public void setUserDao(UserDaoImple userDao) {
        this.userDao = userDao;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello,World!" + name);
    }

    public void init() {
        System.out.println("初始化");
    }

    public void destroy() {
        System.out.println("销毁");
    }

    public void getUserDao() {
        System.out.println("userService执行");
        userDao.getUser();
    }

    public void getNewUserDao() {
        System.out.println("newUserService执行");
        userDao.getNewUser();
    }
}
