package online.yuluo.eurekaclient.online.yuluo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Value("${user.name}")
    private String userName;

    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    public String getName() {
        return "Hello," + userName;
    }
}
