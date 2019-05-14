import online.yuluo.service.impl.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlIOCTest {
    @Test
    public void run() {
        // 创建工厂
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService us = (UserService) ac.getBean("userService");
        us.printHello();
    }
}
