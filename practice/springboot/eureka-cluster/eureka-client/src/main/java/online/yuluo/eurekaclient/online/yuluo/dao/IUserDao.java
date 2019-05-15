package online.yuluo.eurekaclient.online.yuluo.dao;

import online.yuluo.eurekaclient.online.yuluo.entity.UserInfoVO;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
    UserInfoVO getUserInfoById(int id);
}
