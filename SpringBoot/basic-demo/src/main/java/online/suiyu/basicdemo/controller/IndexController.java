/**
 * SpringBoot基本注解、基本运行方式
 */

package online.suiyu.basicdemo.controller;

import online.suiyu.basicdemo.model.User;
import online.suiyu.basicdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "suiyu", method = RequestMethod.GET)
public class IndexController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = {"/index", "i"}, method = RequestMethod.GET)
    public String index() {
        return "Hello,Welcome to the world of SpringBoot";
    }


    @RequestMapping(value = "getuseraslist", method = RequestMethod.GET)
    public List<User> getUserAsList1() {
        List<User> list = userMapper.selectAll();
        return list;
    }

    @RequestMapping(value = "getuser", method = RequestMethod.GET)
    public User selectUserById(@RequestParam(value = "id", required = true) Integer userId) {
        User user = new User();

        return user;
    }

    @GetMapping("get-user")
    public User selectUserById1(int id) {
        User user = new User();
        return user;
    }

    @GetMapping("/getuserbyid/{id}/info")
    public User selectUserById2(@PathParam(value = "id") int userId) {
        User user = new User();
        return user;
    }
}
