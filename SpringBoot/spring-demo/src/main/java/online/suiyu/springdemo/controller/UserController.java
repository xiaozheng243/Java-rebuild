package online.suiyu.springdemo.controller;

import online.suiyu.springdemo.entity.User;

import java.util.List;

public interface UserController {
    String index();

    List<User> getAllUser();

    List<User> getAllUser(int pageNum, int pageSize);

    List<User> getUserBySex(String sex);
}
