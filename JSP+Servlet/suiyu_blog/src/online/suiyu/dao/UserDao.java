package online.suiyu.dao;

import online.suiyu.domain.User;

public interface UserDao {
    public User getUserByNameAndPwd(String username, String password);

    public boolean updateUser(User user);

    public User getUserProfile(User user);
}
