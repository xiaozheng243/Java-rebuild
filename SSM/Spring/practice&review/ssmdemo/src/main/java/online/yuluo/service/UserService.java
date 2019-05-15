package online.yuluo.service;

import online.yuluo.dao.UserDao;
import online.yuluo.entity.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserInfoVO getUserById(int id) {
        return userDao.getUserById(id);
    }
}
