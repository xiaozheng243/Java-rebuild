package online.yuluo.eurekaclient.online.yuluo.controller;

import online.yuluo.eurekaclient.online.yuluo.entity.UserInfoVO;
import online.yuluo.eurekaclient.online.yuluo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    @Value("${user.name}")
    private String userName;

    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    public String getName() {
        return "Hello," + userName;
    }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    public UserInfoVO getUserById(@PathVariable("id") int id) {
        return userService.getUserInfoById(id);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<UserInfoVO> getAllUsers() {
        List<UserInfoVO> users = userService.getAllUsers();
//        redisTemplate.opsForValue().set("users", users);
        return users;
    }
}
