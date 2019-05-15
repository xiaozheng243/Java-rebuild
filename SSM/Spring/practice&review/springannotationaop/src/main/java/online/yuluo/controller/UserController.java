package online.yuluo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController(value = "userController")
public class UserController {


    public void getUser() {
        System.out.println("UserController getUser");
    }
}
