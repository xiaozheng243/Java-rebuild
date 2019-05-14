import online.yuluo.service.impl.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlIOCTest {
    @Test
    public void run() {
        // 创建工厂
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取Bean
        UserService us = (UserService) ac.getBean("userService");
        // 执行方法
        us.printHello();
    }
}