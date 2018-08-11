package online.suiyu.springdemo.service.impl;

import online.suiyu.springdemo.dao.UserDao;
import online.suiyu.springdemo.entity.User;
import online.suiyu.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
