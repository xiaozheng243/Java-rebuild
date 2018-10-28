package online.suiyu.eurekaclient1.service;

import online.suiyu.eurekaclient1.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
    List<User> getAllUser();

    List<User> getAllUser(int pageNum, int pageSize);

    List<User> getUserBySex(String sex);

    boolean addUsers(List<User> userList);
}
