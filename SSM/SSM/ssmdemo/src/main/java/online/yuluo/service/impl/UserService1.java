package online.yuluo.service.impl;

import online.yuluo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService1 implements IUserService {
    @Override
    public void printHello() {
        System.out.println("UserService1 printHello");
    }
}
