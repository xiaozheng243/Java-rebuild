package online.yuluo.controller;

import online.yuluo.entity.UserInfo;
import online.yuluo.mapper.IUserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private IUserInfoDao userInfoDao;

    @RequestMapping(value = "/getString", method = RequestMethod.GET)
    public @ResponseBody
    String getString1() {
        return "Hello,SSM";
    }

    @RequestMapping(value = "/addUsers/{id}/{name}/{age}", method = RequestMethod.GET)
    public @ResponseBody
    String getUser(@PathVariable(value = "id") int id,
                   @PathVariable(value = "name") String name,
                   @PathVariable(value = "age") int age
    ) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(name);
        userInfo.setAge(age);
        userInfoDao.add(userInfo);
        System.out.println("success");
        return "success";
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public @ResponseBody
    UserInfo getUserInfo(@PathVariable Integer id) {
        System.out.println("hello" + id);
        UserInfo userInfo = userInfoDao.getUser(id);
        System.out.println(userInfo.getName());
        return userInfo;
    }
}
