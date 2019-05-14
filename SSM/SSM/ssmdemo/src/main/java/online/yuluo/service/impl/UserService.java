package online.yuluo.service.impl;

import online.yuluo.service.IUserService;

public class UserService implements IUserService {

    private UserService1 userService1;

    public void setUserService1(UserService1 userService1) {
        this.userService1 = userService1;
    }

    @Override
    public void printHello() {
        System.out.println("Hello,xml IOC");
        userService1.printHello();
    }
}
