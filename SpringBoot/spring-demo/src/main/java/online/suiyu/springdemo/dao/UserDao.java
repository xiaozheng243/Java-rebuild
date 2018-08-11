package online.suiyu.springdemo.dao;

import online.suiyu.springdemo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    List<User> getAllUser();

    @Select("select * from user where sex like #{sex}")
    List<User> getUserBySex(String sex);
}
