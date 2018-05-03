package online.suiyu.aopxml.service.impl;

import online.suiyu.aopxml.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("UserService save");
    }

    @Override
    public void update() {
        System.out.println("UserService update");
    }
}
