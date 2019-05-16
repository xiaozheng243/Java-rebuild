package online.yuluo.yuluoblog.online.yuluo.controller;

import online.yuluo.yuluoblog.online.yuluo.entity.UserInfoVO;
import online.yuluo.yuluoblog.online.yuluo.feign.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping(value = "/getRemoteUser/{id}", method = RequestMethod.GET)
    public UserInfoVO getRemoteUser(@PathVariable int id) {
        return helloRemote.getUserById(id);
    }

}
