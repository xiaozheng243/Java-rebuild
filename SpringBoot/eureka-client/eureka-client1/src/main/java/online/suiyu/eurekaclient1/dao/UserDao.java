package online.suiyu.eurekaclient1.dao;

import online.suiyu.eurekaclient1.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    List<User> getAllUser();

    @Select("select * from user where sex like #{sex}")
    List<User> getUserBySex(String sex);

    int addUsers(@Param("userList") List<User> userList);
}
