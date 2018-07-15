/**
 * SpringBoot基本注解、基本运行方式
 */

package online.suiyu.basicdemo.controller;

import online.suiyu.basicdemo.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "suiyu", method = RequestMethod.GET)
public class IndexController {

    @RequestMapping(value = {"/index", "i"}, method = RequestMethod.GET)
    public String index() {
        return "Hello,Welcome to the world of SpringBoot";
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
