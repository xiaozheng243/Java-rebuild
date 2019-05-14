package online.yuluo.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    public void getUser(String name) {
        System.out.println("UserService getUser " + name);
    }
}
