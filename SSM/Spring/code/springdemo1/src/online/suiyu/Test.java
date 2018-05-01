package online.suiyu;

import online.suiyu.service.impl.CollectionDemoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        //创建工厂
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
//
//        //从工厂中获取对象
//        UserService usi = (UserServiceImpl) ac.getBean("userService");
//
//        //调用对象的方法执行
////        usi.sayHello();
////        ((UserServiceImpl) usi).getUserDao();
////        测试构造器注入
//
//        ((UserServiceImpl) usi).getNewUserDao();
//        ((ClassPathXmlApplicationContext) ac).close();
        run0();
    }

    public static void run0() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        CollectionDemoImpl collectionDemo = (CollectionDemoImpl) applicationContext.getBean("collection");
        collectionDemo.getMap();
    }
}
