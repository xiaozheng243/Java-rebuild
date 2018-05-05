package online.suiyu.annioc.dao.impl;

import online.suiyu.annioc.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userDao执行了！");
    }
}
