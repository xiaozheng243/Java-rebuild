package online.yuluo.controller;

import online.yuluo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController("userController")
public class UserController {

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @Value(value = "Lisa")
    private String name;

    public void getUser() {
        userService.getUser(name);
    }
}
