package online.suiyu.eurekaclient1.service.impl;

import com.github.pagehelper.PageHelper;
import online.suiyu.eurekaclient1.dao.UserDao;
import online.suiyu.eurekaclient1.entity.User;
import online.suiyu.eurekaclient1.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserDao userDao;
    private final RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public UserServiceImpl(UserDao userDao, RedisTemplate<Object, Object> redisTemplate) {
        this.userDao = userDao;
        this.redisTemplate = redisTemplate;
    }

    private static Logger logger = LoggerFactory.getLogger("UserServiceImpl");

    @Override
    public List<User> getAllUser() {
        List<User> userList = (List<User>) redisTemplate.opsForValue().get("allUser");
        logger.info("是否有缓存：" + (userList != null));
        if (null == userList) {
            userList = userDao.getAllUser();
            redisTemplate.opsForValue().set("allUser", userList);
        }
        return userList;
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
