package online.suiyu.springdemo.controller.impl;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.suiyu.springdemo.controller.UserController;
import online.suiyu.springdemo.entity.User;
import online.suiyu.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "User类")
@RestController
@RequestMapping(value = "/index", method = RequestMethod.GET)
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;


    @Override
    @ApiOperation(value = "字符串返回数据测试", notes = "测试方法", tags = "hello")
    @PostMapping(value = "/hello")
    public String index() {
        return "Hello,SpringBoot";
    }

    @Override
    @ApiOperation(value = "根据性别获取用户列表")
    @PostMapping(value = "/getuserbysex")
    public List<User> getUserBySex(@RequestParam(value = "sex", required = false, defaultValue = "man") String sex) {
        return userService.getUserBySex(sex);
    }


    @ApiOperation(value = "获取所有的用户列表")
    @PostMapping(value = "/getalluser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
}
