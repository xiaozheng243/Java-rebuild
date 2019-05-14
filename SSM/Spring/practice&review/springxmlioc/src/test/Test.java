import online.yuluo.service.impl.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {


//    private UserService userService;

    @org.junit.Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService us = (UserService) ac.getBean("userService");
        us.sayHello();
    }
}
