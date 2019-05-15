package online.yuluo.controller;

import online.yuluo.entity.UserInfoVO;
import online.yuluo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getString", method = RequestMethod.GET)
    public String getString() {
        return "Hello,Spring";
    }

    @RequestMapping(value = "/getString/{name}", method = RequestMethod.GET)
    public String getString(@PathVariable("name") String name) {
        return "Hello," + name;
    }


    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public UserInfoVO getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }
}
