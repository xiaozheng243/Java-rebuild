package online.suiyu;

import online.suiyu.aopxml.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}