package online.yuluo.eurekaclient.online.yuluo.service.impl;

import online.yuluo.eurekaclient.online.yuluo.dao.IUserDao;
import online.yuluo.eurekaclient.online.yuluo.entity.UserInfoVO;
import online.yuluo.eurekaclient.online.yuluo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserInfoVO getUserInfoById(int id) {
        return userDao.getUserInfoById(id);
    }
}
