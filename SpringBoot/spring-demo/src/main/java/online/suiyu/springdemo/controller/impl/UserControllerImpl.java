package online.suiyu.springdemo.controller.impl;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.suiyu.springdemo.controller.UserController;
import online.suiyu.springdemo.entity.User;
import online.suiyu.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "User类")
@RestController
@RequestMapping(value = "/index", method = RequestMethod.GET)
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "字符串返回数据测试", notes = "测试方法", tags = "hello")
    @PostMapping(value = "/hello")
    public String index() {
        return "Hello,SpringBoot";
    }


    @ApiOperation(value = "获取所有的用户")
    @PostMapping(value = "/getalluser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
}
