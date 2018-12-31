package online.yuluo.mybatisdemo.dao;

import online.yuluo.mybatisdemo.entity.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface IUserDao {

    Long insertUser(UserVO userVOs);
}
