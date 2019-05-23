package online.yuluo.eurekaclient.online.yuluo.dao;

import online.yuluo.eurekaclient.online.yuluo.entity.UserInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    UserInfoVO getUserInfoById(int id);

    List<UserInfoVO> getAllUsers();
}
