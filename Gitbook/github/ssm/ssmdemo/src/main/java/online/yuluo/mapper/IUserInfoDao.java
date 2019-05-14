package online.yuluo.mapper;

import online.yuluo.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository(value = "userInfoDao")
public interface IUserInfoDao {
    void add(UserInfo info);
    UserInfo getUser(@Param("id") int id);
}
