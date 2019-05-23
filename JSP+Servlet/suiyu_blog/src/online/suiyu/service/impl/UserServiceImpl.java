package online.suiyu.service.impl;

import online.suiyu.dao.UserDao;
import online.suiyu.dao.impl.UserDaoImpl;
import online.suiyu.domain.User;
import online.suiyu.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return userDao.getUserByNameAndPwd(username, password);
    }

    @Override
    public User getUserProfile(User user) {
        return userDao.getUserProfile(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}
