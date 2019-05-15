package online.yuluo.dao;

import online.yuluo.entity.UserInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    UserInfoVO getUserById(@Param("id") int id);
}
