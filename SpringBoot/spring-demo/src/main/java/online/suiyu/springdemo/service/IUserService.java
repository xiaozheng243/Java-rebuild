package online.suiyu.springdemo.service;

import online.suiyu.springdemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
    List<User> getAllUser();

    List<User> getAllUser(int pageNum, int pageSize);

    List<User> getUserBySex(String sex);

    boolean addUsers(List<User> userList);
}
