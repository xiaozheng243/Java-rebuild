package online.suiyu.annioc.service.impl;

import online.suiyu.annioc.dao.UserDao;
import online.suiyu.annioc.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service(value = "userService")
@Scope(value = "prototype")
public class UserServiceImpl implements UserService {

    //    注入小明
    @Value(value = "小明")
    private String name;
    //自动按类型装配

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void sayHello() {
        System.out.println("Hello，" + name);
        userDao.save();
    }

    /**
     * 初始化操作
     */
    @PostConstruct
    public void init() {
        System.out.println("初始化操作。。。");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁操作。。。");
    }
}
