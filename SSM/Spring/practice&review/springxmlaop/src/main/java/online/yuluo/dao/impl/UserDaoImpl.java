package online.yuluo.dao.impl;

import online.yuluo.dao.IUserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public void saveUser() {
        System.out.println("UserDaoImpl.saveUser");
    }

    @Override
    public void updateUser() {
        System.out.println("UserDaoImpl.updateUser");
    }
}
