package online.yuluo.eurekaclient.online.yuluo.service;

import online.yuluo.eurekaclient.online.yuluo.entity.UserInfoVO;

import java.util.List;

public interface IUserService {
    UserInfoVO getUserInfoById(int id);
    List<UserInfoVO> getAllUsers();
}
