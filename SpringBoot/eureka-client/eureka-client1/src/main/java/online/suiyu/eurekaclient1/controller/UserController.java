package online.suiyu.eurekaclient1.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.suiyu.eurekaclient1.entity.User;
import online.suiyu.eurekaclient1.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Api(value = "User类")
@RestController
@Component
@RequestMapping(value = "/index", method = RequestMethod.GET)
public class UserController {

//    private static final String REST_URL_PREFIX="";
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private final IUserService userService;
//    private final RestTemplate restTemplate;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
//        this.restTemplate = restTemplate;
    }


    @ApiOperation(value = "字符串返回数据测试")
    @PostMapping(value = "/hello")
    public String index() {
        logger.info("文本测试");
        return "Hello,SpringBoot";
    }

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

    @ApiOperation(value = "获取所有的用户列表")
    @PostMapping(value = "/getalluser1")
    public List<User> getAllUser(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "4") int pageSize) {
        return userService.getAllUser(pageNum, pageSize);
    }

    @Transactional
    @ApiOperation(value = "插入多条语句")
    @PostMapping(value = "/addUsers")
    public boolean addUsers(@RequestBody List<User> userList) {
        return userService.addUsers(userList);
    }
}
