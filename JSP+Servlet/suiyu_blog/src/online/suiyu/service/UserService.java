package online.suiyu.service;

import online.suiyu.domain.User;

public interface UserService {
    public User login(String username, String password);

    public User getUserProfile(User user);

    public boolean updateUser(User user);
}
