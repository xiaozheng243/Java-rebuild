package online.suiyu.springdemo.dao;

import online.suiyu.springdemo.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserDao {
    List<User> getAllUser();
}
