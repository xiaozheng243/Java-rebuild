package online.suiyu.springdemo.service.impl;

import com.github.pagehelper.PageHelper;
import online.suiyu.springdemo.dao.UserDao;
import online.suiyu.springdemo.entity.User;
import online.suiyu.springdemo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;


    private static Logger logger = LoggerFactory.getLogger("UserServiceImpl");

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public List<User> getAllUser(int pageNum, int pageSize) {
        logger.info("UserServiceImpl.getAllUser开始");
        PageHelper.startPage(pageNum, pageSize);
        logger.info("UserServiceImpl.getAllUser结束");
        return userDao.getAllUser();
    }

    @Override
    public List<User> getUserBySex(String sex) {
        return userDao.getUserBySex(sex);
    }


    @Transactional
    @Override
    public boolean addUsers(List<User> userList) {
        logger.info("UserServiceImpl.addUsers开始");
        int num = userDao.addUsers(userList);
//        int i = 10 / 0;
        logger.info("UserServiceImpl.addUsers结束");
        return num > 0;
    }
}
