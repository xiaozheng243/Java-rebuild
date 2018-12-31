package online.yuluo.mybatisdemo.controller;

import online.yuluo.mybatisdemo.entity.UserVO;
import online.yuluo.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Long insertUser(@RequestBody UserVO userVO) {
        return userService.insertUser(userVO);
    }
}
