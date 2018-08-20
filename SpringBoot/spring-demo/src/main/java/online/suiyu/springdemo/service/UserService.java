package online.suiyu.springdemo.service;

import online.suiyu.springdemo.entity.User;

import java.util.List;


public interface UserService {
    List<User> getAllUser();

    List<User> getAllUser(int pageNum, int pageSize);

    List<User> getUserBySex(String sex);

    boolean addUsers(List<User> userList);
}
