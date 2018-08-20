package online.suiyu.springdemo.service.impl;

import com.github.pagehelper.PageHelper;
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

    @Override
    public List<User> getAllUser(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        return userDao.getAllUser();
    }

    @Override
    public List<User> getUserBySex(String sex) {
        return userDao.getUserBySex(sex);
    }

    @Override
    public boolean addUsers(List<User> userList) {

        return userDao.addUsers(userList) > 0;
    }
}
