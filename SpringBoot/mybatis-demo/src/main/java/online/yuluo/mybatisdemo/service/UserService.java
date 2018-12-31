package online.yuluo.mybatisdemo.service;

import online.yuluo.mybatisdemo.dao.IUserDao;
import online.yuluo.mybatisdemo.entity.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    public Long insertUser(UserVO userVO) {
        return userDao.insertUser(userVO);
    }
}
